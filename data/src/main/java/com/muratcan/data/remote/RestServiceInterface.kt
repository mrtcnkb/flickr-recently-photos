package com.muratcan.data.remote

import com.muratcan.model.remote.PhotoListItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by MuratCan on 6.05.2020.
 */
interface RestServiceInterface {
    @GET("rest") fun fetchRecentlyPhotos(
        @Query("method") method: String? = "flickr.photos.getRecent",
        @Query("api_key") apiKey: String? = "193fb6a7a88823ff6aa694a86ea42c81",
        @Query("format") format: String? = "json",
        @Query("nojsoncallback") noJsonCallback: Int? = 1,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int? = 20
    ): Observable<PhotoListItem>
}