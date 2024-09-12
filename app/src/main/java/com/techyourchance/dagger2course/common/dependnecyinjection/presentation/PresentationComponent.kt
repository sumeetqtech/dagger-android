package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import dagger.Component

@PresentationScope
@Component(dependencies = [ActivityComponent::class], modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(questionsListFragment: QuestionsListFragment)
    fun inject(questionDetailsActivity: QuestionDetailsActivity)
}