package com.techyourchance.dagger2course.common.dependnecyinjection.app

import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependnecyinjection.service.ServiceComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.service.ServiceModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
    fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}