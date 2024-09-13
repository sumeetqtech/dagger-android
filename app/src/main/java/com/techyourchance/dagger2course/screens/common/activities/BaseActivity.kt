package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependnecyinjection.app.AppModule
import com.techyourchance.dagger2course.common.dependnecyinjection.app.DaggerAppComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent

open class BaseActivity : AppCompatActivity() {

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule((application as MyApplication))).build()
    }

    val activityComponent: ActivityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent: PresentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent

}