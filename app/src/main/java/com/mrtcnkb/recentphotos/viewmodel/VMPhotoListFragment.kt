package com.mrtcnkb.recentphotos.viewmodel

import android.util.Log
import com.mrtcnkb.recentphotos.util.SingleLiveEvent
import com.mrtcnkb.recentphotos.viewmodel.base.BaseViewModel
import com.muratcan.domain.PhotoListUseCase
import com.muratcan.model.remote.Photos
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class VMPhotoListFragment @Inject constructor(
    private val photoListUseCase: PhotoListUseCase
) : BaseViewModel() {

    internal var photosObject = SingleLiveEvent<Photos>()

    fun fetchRecentlyPhotos(page: Int) {
        photoListUseCase
            .fetchRecentlyPhotos(page = page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response?.let {
                    if (it.stat == "ok") {
                        photosObject.value = it.photos
                    }
                }
            },{
                Log.e("RxError", "--> ${it.message}")
            }).also {
                disposables += it
            }
    }
}
