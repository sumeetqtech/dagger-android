package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun stackoverflowApi(): StackoverflowApi
    fun fragmentManager(): FragmentManager
    fun layoutInflater(): LayoutInflater
    fun screenNavigator(): ScreenNavigator
}