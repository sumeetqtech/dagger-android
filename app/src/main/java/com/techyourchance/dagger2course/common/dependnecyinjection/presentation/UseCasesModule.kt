package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionDetailsUseCase(stackoverflowApi)

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)
}