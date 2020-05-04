package com.mrtcnkb.recentphotos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mrtcnkb.recentphotos.R
import com.mrtcnkb.recentphotos.databinding.PhotoDetailFragmentBinding
import com.mrtcnkb.recentphotos.ui.base.BaseFragment
import com.mrtcnkb.recentphotos.viewmodel.VMPhotoDetailFragment

class PhotoDetailFragment : BaseFragment<VMPhotoDetailFragment, PhotoDetailFragmentBinding>() {

    override fun getViewModel(): Class<VMPhotoDetailFragment> = VMPhotoDetailFragment::class.java
    override fun getLayoutRes(): Int = R.layout.photo_detail_fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel

        return binding.root
    }

}
