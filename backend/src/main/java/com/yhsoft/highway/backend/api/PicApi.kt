package com.yhsoft.highway.backend.api

import com.yhsoft.highway.backend.model.MeiziPic
import com.yhsoft.highway.backend.model.wrapper.GankIoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PicApi {

    @GET("{count}/{pageNum}")
    fun getMeiziPics(
        @Path("count") count: Int,
        @Path("pageNum") pageNum: Int
    ): Observable<GankIoResponse<MeiziPic>>
}
