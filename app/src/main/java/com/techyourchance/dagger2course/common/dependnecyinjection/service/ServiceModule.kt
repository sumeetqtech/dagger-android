package com.techyourchance.dagger2course.common.dependnecyinjection.service

import android.app.Service
import dagger.Module
import dagger.Provides

@Module
class ServiceModule(
    private val service: Service,
) {

    @Provides
    fun context() = service

}
