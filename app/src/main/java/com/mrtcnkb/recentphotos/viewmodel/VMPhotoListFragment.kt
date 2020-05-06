package com.mrtcnkb.recentphotos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrtcnkb.recentphotos.viewmodel.base.BaseViewModel
import com.muratcan.domain.PhotoListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class VMPhotoListFragment @Inject constructor(
    private val photoListUseCase: PhotoListUseCase
) : BaseViewModel() {

    var photoListStatus = MutableLiveData<String>()

    fun fetchRecentlyPhotos() {
        photoListUseCase
            .fetchRecentlyPhotos(1, 2)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ response ->
                response?.let {
                    photoListStatus.value = it.stat
                }
            }
            .also {
                disposables += it
            }
    }
}
