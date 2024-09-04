package com.techyourchance.dagger2course.screens.common.viewsmvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes


open class BaseViewMvc<LISTENER_TYPE>(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    @LayoutRes resId: Int
) {

    val rootView: View = layoutInflater.inflate(resId, parent, false)
    protected val listeners = HashSet<LISTENER_TYPE>()
    protected val context: Context get() = rootView.context

    fun addListener(listener: LISTENER_TYPE) {
        listeners.add(listener)
    }

    fun removeListener(listener: LISTENER_TYPE) {
        listeners.remove(listener)
    }


    protected fun <T : View?> findViewById(@IdRes id: Int): T {
        return rootView.findViewById<T>(id)
    }

}