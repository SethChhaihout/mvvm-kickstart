package com.planbcambodia.projectkickstart.view.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.content.ContextWrapper
import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by Panha Sakvisa on 3/21/2019.
 */
object BindingAdapters {
    @BindingAdapter("mutableVisibility")
    @JvmStatic
    fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
        if(view.visibility != visibility?.value){
            view.visibility = visibility?.value!!
        }
    }

    @InverseBindingAdapter(attribute = "mutableVisibility")
    @JvmStatic
    fun getMutableVisibility(view: View) = view.visibility

    fun View.getParentActivity(): AppCompatActivity? {
        var context = this.context
        while (context is ContextWrapper) {
            if (context is AppCompatActivity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }
}