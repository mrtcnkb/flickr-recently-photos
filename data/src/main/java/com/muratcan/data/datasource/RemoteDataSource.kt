package com.muratcan.data.datasource

import com.muratcan.data.remote.RestServiceInterface
import javax.inject.Inject

/**
 * Created by MuratCan on 6.05.2020.
 */
class RemoteDataSource @Inject constructor(private val restInterface: RestServiceInterface) {
    fun fetchRecentlyPhotos(page: Int) = restInterface.fetchRecentlyPhotos(page = page)
}