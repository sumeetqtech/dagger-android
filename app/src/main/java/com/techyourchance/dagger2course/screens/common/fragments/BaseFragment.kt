package com.techyourchance.dagger2course.screens.common.fragments


import androidx.fragment.app.Fragment
import com.techyourchance.dagger2course.common.dependnecyinjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.Injector
import com.techyourchance.dagger2course.common.dependnecyinjection.PresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.PresentationModule
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

open class BaseFragment : Fragment() {

    private val component: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule((requireActivity() as BaseActivity).activityComponent))
            .build()
    }

    protected val injector: Injector by lazy {
        Injector(component)
    }

}