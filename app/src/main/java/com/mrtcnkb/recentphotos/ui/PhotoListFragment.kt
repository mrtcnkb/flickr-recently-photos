package com.mrtcnkb.recentphotos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mrtcnkb.recentphotos.R
import com.mrtcnkb.recentphotos.databinding.PhotoListFragmentBinding
import com.mrtcnkb.recentphotos.ui.base.BaseFragment
import com.mrtcnkb.recentphotos.viewmodel.VMPhotoListFragment
import com.muratcan.domain.PhotoListUseCase

class PhotoListFragment : BaseFragment<VMPhotoListFragment, PhotoListFragmentBinding>(){

    override fun getViewModel(): Class<VMPhotoListFragment> = VMPhotoListFragment::class.java
    override fun getLayoutRes(): Int = R.layout.photo_list_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        with(binding) {
            navigateClick.setOnClickListener {
                toast("Navigated to photo detail..")
                safeNavigate(R.id.action_photoListFragment_to_photoDetailFragment)
            }
        }
    }

}
