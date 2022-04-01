package com.catsapp.data.repository.remote.api

import com.catsapp.data.repository.remote.model.CatsResponse
import retrofit2.Response
import retrofit2.http.*

interface CatsApiInterface {

    @GET("breeds?api_key=a3ec83f9-dba0-48f8-9d37-522af566773a")
    suspend fun getCats(
    ) : Response<CatsResponse>
}