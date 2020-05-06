package com.mrtcnkb.recentphotos.viewmodel.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by MuratCan on 6.05.2020.
 */
open class BaseViewModel : ViewModel() {
    protected var disposables = CompositeDisposable()

    override fun onCleared() {
        if (!disposables.isDisposed) {
            disposables.clear()
        }
        super.onCleared()
    }
}