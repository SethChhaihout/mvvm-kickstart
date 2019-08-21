package com.planbcambodia.projectkickstart.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Panha Sakvisa on 3/21/2019.
 */
class Service(@SerializedName("service_name") val serviceName:String, val photo:String)