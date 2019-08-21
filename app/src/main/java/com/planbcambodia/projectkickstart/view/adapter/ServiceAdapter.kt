package com.planbcambodia.projectkickstart.view.adapter

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.planbcambodia.projectkickstart.R
import com.planbcambodia.projectkickstart.data.model.Service
import com.planbcambodia.projectkickstart.utils.Constant
import com.planbcambodia.projectkickstart.view.ui.activity.MainActivity
import com.planbcambodia.projectkickstart.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.viewholder_service.view.*

/**
 * Created by Panha Sakvisa on 3/21/2019.
 */
class ServiceAdapter(val mainViewModel: MainViewModel,val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<ServiceViewHolder>() {
    val services:ArrayList<Service> = ArrayList()

    init {
        mainViewModel.services.observe(lifecycleOwner,object:Observer<List<Service>>{
            override fun onChanged(t: List<Service>?) {
                services.clear()
                services.addAll(t!!)
                notifyDataSetChanged()
            }
        })
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ServiceViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.viewholder_service,p0,false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(p0: ServiceViewHolder, p1: Int) {
        p0.bindView(services[p1])
    }

    override fun getItemCount(): Int = services.size
}

class ServiceViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bindView(service: Service){
        itemView.serviceName.text = service.serviceName
        itemView.serviceImage.setImageURI(Uri.parse("${Constant.baseUrl}${service.photo}"),null)
    }
}