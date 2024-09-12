package com.techyourchance.dagger2course.common.dependnecyinjection

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {
    fun dialogsNavigator(): DialogsNavigator
    fun screenNavigator(): ScreenNavigator
    fun fetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase
    fun fetchQuestionsUseCase(): FetchQuestionsUseCase
    fun viewMvcFactory(): ViewMvcFactory
}