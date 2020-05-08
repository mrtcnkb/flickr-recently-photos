package com.mrtcnkb.recentphotos.ui.view

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import com.mrtcnkb.recentphotos.R
import com.mrtcnkb.recentphotos.databinding.PhotoListFragmentBinding
import com.mrtcnkb.recentphotos.ui.adapter.PhotoListAdapter
import com.mrtcnkb.recentphotos.ui.base.BaseFragment
import com.mrtcnkb.recentphotos.util.EndlessScrollListener
import com.mrtcnkb.recentphotos.util.Functions.dismissSnackBar
import com.mrtcnkb.recentphotos.util.Functions.showSnackBar
import com.mrtcnkb.recentphotos.util.ItemClickListener
import com.mrtcnkb.recentphotos.util.observeNonNull
import com.mrtcnkb.recentphotos.viewmodel.VMPhotoListFragment
import com.muratcan.model.remote.Photo

class PhotoListFragment : BaseFragment<VMPhotoListFragment, PhotoListFragmentBinding>(){

    override fun getViewModel(): Class<VMPhotoListFragment> = VMPhotoListFragment::class.java
    override fun getLayoutRes(): Int = R.layout.photo_list_fragment

    private var photoListAdapter: PhotoListAdapter? = null
    private var initialPage = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.viewModel = viewModel
        initListeners()
        initObservers()

        savedInstanceState.runIfNull {
            loadPhotos(initialPage)
        }
        return binding.root
    }

    private fun initObservers() {
        viewModel.apply {
            photosObject.observeNonNull(this@PhotoListFragment) {
                Handler().postDelayed({
                    dismissSnackBar()
                }, 200)
                if (it.page == initialPage) {
                    initRecycler(it.pages)
                }
                photoListAdapter?.setPostItemList(it.photo)
            }
        }
    }

    private fun loadPhotos(page: Int) {
        viewModel.fetchRecentlyPhotos(page)
    }

    private fun initListeners() {
        binding.apply {
            swipeToRefresh.setOnRefreshListener {
                photoListAdapter?.clearList()
                loadPhotos(initialPage)
                Handler().postDelayed({
                    swipeToRefresh.isRefreshing = false
                }, 400)
            }
        }
    }

    private fun initRecycler(totalPage: Int) {
        photoListAdapter = PhotoListAdapter(object: ItemClickListener {
            override fun onItemClick(view: View, photo: Photo) {
                Handler().postDelayed({
                    safeNavigate(R.id.action_photoListFragment_to_photoDetailFragment, bundleOf("photoObject" to photo))
                }, 200)
            }
        })
        GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false).let {
            binding.recyclerview.apply {
                adapter = photoListAdapter
                layoutManager = it
                addOnScrollListener(
                    object: EndlessScrollListener(it, totalPage) {
                        override fun onLoadMore(page: Int) {
                            showSnackBar(context, binding.recyclerview as View, R.color.md_black_1000)
                            loadPhotos(page)
                        }
                    }
                )
            }
        }
    }

}
