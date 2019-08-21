package com.planbcambodia.projectkickstart.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.planbcambodia.projectkickstart.data.model.Service
import com.planbcambodia.projectkickstart.data.repository.Repository
import javax.inject.Inject

/**
 * Created by Panha Sakvisa on 3/21/2019.
 */
class MainViewModel @Inject constructor(var repository: Repository) : NetworkViewModel() {
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val services: MutableLiveData<List<Service>> = MutableLiveData()
    val name: MutableLiveData<String> = MutableLiveData()
    val status: MutableLiveData<String> = MutableLiveData()

    init {
        onCreate()
    }

    private fun onCreate(){
        loadingVisibility.value = View.VISIBLE
        callApi(repository.getService(),{ response->
            Log.d("NetworkViewModel","Success")
//            if(response.success){
                loadingVisibility.value = View.GONE
                services.value = response.services
//            }
        },
        { error->
            Log.d("NetworkViewModel","${error.localizedMessage}")
        })
    }

    fun onOKClicked(){
        Log.d("NetworkViewModel","click")
        status.value = "My name is ${name.value}"
    }
}