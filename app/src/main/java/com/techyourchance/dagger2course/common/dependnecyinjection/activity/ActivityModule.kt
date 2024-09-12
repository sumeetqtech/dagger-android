package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.dependnecyinjection.app.AppComponent
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    private val activity: AppCompatActivity,
    private val component: AppComponent
) {

    val screenNavigator by lazy {
        ScreenNavigator(activity);
    }

    @Provides
    fun application() = component.application()

    @Provides
    fun stackoverflowApi(): StackoverflowApi = component.stackoverflowApi()

    @Provides
    fun fragmentManager(): FragmentManager = activity.supportFragmentManager

    @Provides
    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun screenNavigator(): ScreenNavigator = screenNavigator

}
