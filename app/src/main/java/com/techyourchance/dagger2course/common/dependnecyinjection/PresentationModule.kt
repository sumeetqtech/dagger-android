package com.techyourchance.dagger2course.common.dependnecyinjection

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val component: ActivityComponent) {

    @Provides
    fun stackoverflowApi() = component.stackoverflowApi()

    @Provides
    fun fragmentManager() = component.fragmentManager()

    @Provides
    fun layoutInflater() = component.layoutInflater()

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionDetailsUseCase(stackoverflowApi)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun screenNavigator() = component.screenNavigator()
}