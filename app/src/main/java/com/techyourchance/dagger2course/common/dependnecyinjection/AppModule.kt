package com.techyourchance.dagger2course.common.dependnecyinjection

import android.app.Application
import androidx.annotation.UiThread
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@UiThread
@Module
class AppModule(val application: Application) {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val stackoverflowApi: StackoverflowApi by lazy { retrofit.create(StackoverflowApi::class.java) }

    @Provides
    fun stackoverflowApi(): StackoverflowApi = stackoverflowApi

    @Provides
    fun application(): Application = application
}