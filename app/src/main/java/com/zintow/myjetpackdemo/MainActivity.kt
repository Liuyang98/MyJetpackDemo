package com.zintow.myjetpackdemo

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.zintow.myjetpackdemo.base.BaseActivity
import com.zintow.myjetpackdemo.bean.MainHomeBean
import com.zintow.myjetpackdemo.config.App
import com.zintow.myjetpackdemo.databinding.ActivityMainBinding
import com.zintow.myjetpackdemo.viewmodel.MainHomeViewModel


class MainActivity : BaseActivity() {
    private lateinit var bind: ActivityMainBinding
    private lateinit var vm: MainHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bind.lifecycleOwner = this

        vm=  (applicationContext as App). getAppViewModelProvider(this).get(MainHomeViewModel::class.java)

        bind.imageView.setOnClickListener {
            val nb = MainHomeBean()
            nb.tip = "通过ViewModel修改Fragment中的数据"
            vm.liveData.value = nb
        }
    }

}
