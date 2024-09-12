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
) {

    @Provides
    fun fragmentManager(): FragmentManager = activity.supportFragmentManager

    @Provides
    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    @ActivityScope
    fun screenNavigator(): ScreenNavigator = ScreenNavigator(activity)

}
