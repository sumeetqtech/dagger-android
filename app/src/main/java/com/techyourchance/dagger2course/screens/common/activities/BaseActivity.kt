package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependnecyinjection.ActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.ActivityModule
import com.techyourchance.dagger2course.common.dependnecyinjection.AppModule
import com.techyourchance.dagger2course.common.dependnecyinjection.DaggerActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.DaggerAppComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.DaggerPresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.Injector
import com.techyourchance.dagger2course.common.dependnecyinjection.PresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.PresentationModule

open class BaseActivity : AppCompatActivity() {

    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule((application as MyApplication))).build()
    }

    val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().activityModule(ActivityModule(this, appComponent))
            .build()
    }

    private val component: PresentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent)).build()
    }

    protected val injector: Injector by lazy {
        Injector(component)
    }

}