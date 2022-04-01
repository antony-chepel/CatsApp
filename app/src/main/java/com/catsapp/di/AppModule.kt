package com.catsapp.di

import android.content.Context
import com.catsapp.common.Constans
import com.catsapp.data.repository.CatsRepositoryImpl
import com.catsapp.data.repository.remote.api.CatsApiInterface
import com.catsapp.domain.repository.CatsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCatsApi() : CatsApiInterface {
        return Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatsApiInterface::class.java)
    }



    @Provides
    @Singleton
    fun provideCatsRepository(api: CatsApiInterface) : CatsRepository{
        return CatsRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideRealm(@ApplicationContext context : Context) : Realm{
        Realm.init(context)
        val configuration = RealmConfiguration.Builder()
            .name("fav_cats.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(0)
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .build()

        Realm.setDefaultConfiguration(configuration)
        return Realm.getDefaultInstance()
    }
}