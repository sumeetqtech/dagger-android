package com.techyourchance.dagger2course.common.composition

import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory

class PresentationCompositionRoot(private val activityCompositionRoot: ActivityCompositionRoot) {

    private val stackoverflowApi: StackoverflowApi get() = activityCompositionRoot.stackoverflowApi
    private val fragmentManager: FragmentManager get() = activityCompositionRoot.fragmentManager
    private val layoutInflater get() = activityCompositionRoot.layoutInflater

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)
    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
    val dialogsNavigator get() = DialogsNavigator(fragmentManager)
    val screenNavigator get() = activityCompositionRoot.screenNavigator
}