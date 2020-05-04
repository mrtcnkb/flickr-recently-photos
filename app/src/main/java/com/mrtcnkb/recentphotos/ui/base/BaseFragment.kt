package com.mrtcnkb.recentphotos.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    lateinit var binding: DB

    abstract fun getViewModel(): Class<VM>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        return binding.root
    }

    /**
     * Yalnızca action'lar için kullanılacak, direkt fragment'e navigate işlemleri için normal findNavController().navigate işlemi uygulanacak.
     * Action'larda duplicate click crash'e sebebiyet verebiliyor.
     */
    protected fun safeNavigate(@IdRes actionId: Int, bundle: Bundle? = null) {
        findNavController().apply {
            (currentDestination?.getAction(actionId) ?: graph.getAction(actionId))?.let { action ->
                if (currentDestination?.id != action.destinationId) {
                    navigate(actionId, bundle)
                }
            }
        }
    }

    internal fun toast(string: String?) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
    }

}