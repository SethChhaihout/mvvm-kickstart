package com.planbcambodia.projectkickstart.data.model.base

/**
 * Created by Panha Sakvisa on 3/20/2019.
 */
data class BaseModel<T>(var success:Boolean,var code:Int,var message:String,var services:T)