package com.mrtcnkb.recentphotos.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muratcan.model.remote.Photo
import javax.inject.Inject

class VMPhotoDetailFragment @Inject constructor() : ViewModel() {
    var photoObject = MutableLiveData<Photo>()
}
