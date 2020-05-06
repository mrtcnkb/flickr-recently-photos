package com.mrtcnkb.recentphotos.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.mrtcnkb.recentphotos.R
import com.mrtcnkb.recentphotos.databinding.PhotoDetailFragmentBinding
import com.mrtcnkb.recentphotos.ui.base.BaseFragment
import com.mrtcnkb.recentphotos.util.observeNonNull
import com.mrtcnkb.recentphotos.viewmodel.VMPhotoDetailFragment
import com.muratcan.model.remote.Photo

class PhotoDetailFragment : BaseFragment<VMPhotoDetailFragment, PhotoDetailFragmentBinding>() {

    override fun getViewModel(): Class<VMPhotoDetailFragment> = VMPhotoDetailFragment::class.java
    override fun getLayoutRes(): Int = R.layout.photo_detail_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        observeOperations()
        getBundleArguments()
        return binding.root
    }

    private fun observeOperations() {
        viewModel.photoObject.observeNonNull(this@PhotoDetailFragment) {
            setToolbarTitle(it.title)
        }
    }

    private fun setToolbarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.let { toolbar ->
            toolbar.title = if (title.isNotBlank()) title else "Untitled"
        }
    }

    private fun getBundleArguments() {
        arguments?.getParcelable<Photo>("photoObject")?.let {
            viewModel.photoObject.value = it
        }
    }

}
