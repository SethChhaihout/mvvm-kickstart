package com.planbcambodia.projectkickstart.view.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.planbcambodia.projectkickstart.R
import com.planbcambodia.projectkickstart.databinding.ActivityMainBinding
import com.planbcambodia.projectkickstart.view.adapter.ServiceAdapter
import com.planbcambodia.projectkickstart.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this,viewModelFactory).get(MainViewModel::class.java)
        binding.viewModel = mainViewModel
        binding.setLifecycleOwner(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ServiceAdapter(mainViewModel,this)

        mainViewModel.status.observe(this, Observer { status->
            Toast.makeText(this,status,Toast.LENGTH_SHORT).show()
        })
    }
}
