package com.mrtcnkb.recentphotos

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.mrtcnkb.recentphotos.databinding.ActivityMainBinding
import com.mrtcnkb.recentphotos.ui.base.BaseActivity
import com.mrtcnkb.recentphotos.viewmodel.VMMainActivity

class MainActivity : BaseActivity<VMMainActivity, ActivityMainBinding>() {

    override fun getViewModel(): Class<VMMainActivity> = VMMainActivity::class.java
    override fun getLayoutRes(): Int = R.layout.activity_main

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        setNavController()
    }

    private fun setNavController() {
        navController = findNavController(R.id.nav_host_container)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

}
