package com.techyourchance.dagger2course.screens.common.dialogs


import androidx.fragment.app.DialogFragment
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseDialog : DialogFragment() {

    private val presentationComponent: PresentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent

}