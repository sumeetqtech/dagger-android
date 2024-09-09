package com.techyourchance.dagger2course.common.dependnecyinjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(fragment: QuestionsListFragment) {
        fragment.screenNavigator = compositionRoot.screenNavigator
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }


    fun inject(activity: QuestionDetailsActivity) {
        activity.screenNavigator = compositionRoot.screenNavigator
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }
}