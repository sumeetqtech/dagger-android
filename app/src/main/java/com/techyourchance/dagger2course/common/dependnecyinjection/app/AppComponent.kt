package com.techyourchance.dagger2course.common.dependnecyinjection.app

import android.app.Application
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationModule
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
}