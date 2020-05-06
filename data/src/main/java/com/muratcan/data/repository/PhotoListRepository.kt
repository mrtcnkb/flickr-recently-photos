package com.muratcan.data.repository

import com.muratcan.data.datasource.RemoteDataSource
import com.muratcan.model.remote.PhotoListItem
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by MuratCan on 4.05.2020.
 */
class PhotoListRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    fun fetchRecentlyPhotos(page: Int): Observable<PhotoListItem> =
        remoteDataSource
            .fetchRecentlyPhotos(page)
            .subscribeOn(Schedulers.io())
}