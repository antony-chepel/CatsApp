package com.catsapp.domain.repository

import com.catsapp.data.repository.remote.model.CatsResponse
import retrofit2.Response

interface CatsRepository {

   suspend fun getCats() : Response<CatsResponse>
}