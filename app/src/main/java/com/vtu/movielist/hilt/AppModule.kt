package com.vtu.movielist.hilt

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.viewbinding.BuildConfig
import com.vtu.movielist.api.MovieApiHelper
import com.vtu.movielist.api.MovieApiHelperImpl
import com.vtu.movielist.api.MovieApiService
import com.vtu.movielist.dao.MovieDao
import com.vtu.movielist.database.MovieDatabase
import com.vtu.movielist.repository.MovieRepository
import com.vtu.movielist.repository.MovieRepositoryImpl
import com.vtu.movielist.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constant.BASE_URL

    @Provides
    @Singleton
    fun provideOkhttpClient() = if (BuildConfig.DEBUG) {
        val loginInterceptor = HttpLoggingInterceptor()
        loginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loginInterceptor)
            .build()
    } else {
        OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl : String) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit)  =
        retrofit.create(MovieApiService::class.java)


    @Provides
    @Singleton
    fun provideApiHelper(apiService: MovieApiService) : MovieApiHelper{
        return MovieApiHelperImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "MovieDatabase").build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: MovieDatabase) : MovieDao {
        return movieDatabase.dao
    }

    @Provides
    @Singleton
    fun provideMovieRepository(apiHelper: MovieApiHelper, dao: MovieDao) : MovieRepository {
        return MovieRepositoryImpl(apiHelper, dao)
    }

 }