package com.chen.kaixu.dbdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chen.kaixu.dbdemo.dblib.MyDbutil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var myDbutil: MyDbutil? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        myDbutil = MyDbutil(this, "main", 1)
    }

    private fun initView() {
        button.setOnClickListener(clistener)
    }

    val clistener = object : View.OnClickListener {
        override fun onClick(p0: View?) {
            if (p0 != null) {
                if (p0.id == button.id) {
                    myDbutil!!.findTableExiset("student")
                }
            }
        }
    }


}
