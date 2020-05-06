package com.muratcan.domain

import com.muratcan.data.repository.PhotoListRepository
import com.muratcan.model.remote.PhotoListItem
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by MuratCan on 4.05.2020.
 */

class PhotoListUseCase @Inject constructor(
    private val repository: PhotoListRepository
) {
    fun fetchRecentlyPhotos(page: Int, perpage: Int): Observable<PhotoListItem> {
        return repository
            .fetchRecentlyPhotos(page, perpage)
            .doOnError {
                it.printStackTrace()
            }
    }
}