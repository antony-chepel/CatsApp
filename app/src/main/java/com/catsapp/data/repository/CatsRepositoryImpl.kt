package com.catsapp.data.repository

import com.catsapp.data.repository.remote.api.CatsApiInterface
import com.catsapp.data.repository.remote.model.CatsResponse
import com.catsapp.domain.repository.CatsRepository
import retrofit2.Response
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val api : CatsApiInterface

) : CatsRepository {

    override suspend fun getCats(): Response<CatsResponse>{
        return api.getCats()
    }
}