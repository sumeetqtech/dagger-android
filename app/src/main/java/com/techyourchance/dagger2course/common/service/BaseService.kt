package com.techyourchance.dagger2course.common.service

import android.app.Service
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependnecyinjection.app.AppModule
import com.techyourchance.dagger2course.common.dependnecyinjection.app.DaggerAppComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.service.ServiceComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.service.ServiceModule

abstract class BaseService : Service() {
    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule((application as MyApplication))).build()
    }

    val serviceComponent: ServiceComponent by lazy {
        appComponent.newServiceComponent(ServiceModule(this))
    }
}