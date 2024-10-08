package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {

    @Provides
    fun fragmentManager(activity: AppCompatActivity): FragmentManager =
        activity.supportFragmentManager

    @Provides
    fun layoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

    @Provides
    @ActivityScope
    fun screenNavigator(activity: AppCompatActivity): ScreenNavigator = ScreenNavigator(activity)

}
