package com.giuseppesorce.cartanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var countBadge: CountetCartItemText?=null
    private var countItem =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCartAnimation()
    }

    private fun setupCartAnimation() {
        toolBar.title="Shop"
        setSupportActionBar(toolBar)
        fabAddCart.setOnClickListener {
            addCart()
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.shop, menu)
        val alertMenuItem = menu?.findItem(R.id.cart)
        val rootView = alertMenuItem?.actionView as FrameLayout
        // get custom view badge
        countBadge = rootView.findViewById(R.id.view_alert_count_textview) as CountetCartItemText
        return true
    }

    private fun addCart() {
        countItem++
        countBadge?.setCount(countItem)
    }
}
