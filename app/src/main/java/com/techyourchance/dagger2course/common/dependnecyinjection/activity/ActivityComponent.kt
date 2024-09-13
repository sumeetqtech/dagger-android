package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import com.techyourchance.dagger2course.common.dependnecyinjection.app.AppComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationModule
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.UseCasesModule
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule, useCasesModule: UseCasesModule): PresentationComponent
}