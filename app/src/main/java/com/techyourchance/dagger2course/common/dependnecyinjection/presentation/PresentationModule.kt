package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import android.view.LayoutInflater
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionsUseCase(stackoverflowApi)

}