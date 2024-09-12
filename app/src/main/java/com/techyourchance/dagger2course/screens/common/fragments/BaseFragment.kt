package com.techyourchance.dagger2course.screens.common.fragments


import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependnecyinjection.Injector
import com.techyourchance.dagger2course.common.dependnecyinjection.PresentationModule
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val compositionRoot: PresentationModule by lazy {
        PresentationModule((requireActivity() as BaseActivity).activityCompositionRoot)
    }

    protected val injector: Injector by lazy {
        Injector(compositionRoot)
    }

}