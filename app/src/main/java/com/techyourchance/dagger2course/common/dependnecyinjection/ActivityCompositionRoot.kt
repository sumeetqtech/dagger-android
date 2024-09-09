package com.techyourchance.dagger2course.common.dependnecyinjection

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.screens.common.ScreenNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    val screenNavigator by lazy {
        ScreenNavigator(activity);
    }

    val application get() = appCompositionRoot.application
    val stackoverflowApi: StackoverflowApi get() = appCompositionRoot.stackoverflowApi
    val fragmentManager: FragmentManager get() = activity.supportFragmentManager
    val layoutInflater: LayoutInflater get() = LayoutInflater.from(activity)

}
