package com.angelfgdeveloper.android_architecture_app.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.angelfgdeveloper.android_architecture_app.R
import com.angelfgdeveloper.android_architecture_app.databinding.ActivityMainBinding
import com.angelfgdeveloper.android_architecture_app.model.Coupon
import com.angelfgdeveloper.android_architecture_app.viewmodel.CouponViewModel

class MainActivity : AppCompatActivity() {

    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // VIEW
        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?) {
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponViewModel = ViewModelProvider(this).get(CouponViewModel::class.java)
        activityMainBinding.model = couponViewModel
        setupListUpdate()
    }

    fun setupListUpdate() {
        // callCoupons
        couponViewModel?.callCoupon()
        // getCoupons - Lista de cupones
        couponViewModel?.getCoupon()?.observe(this, Observer { coupons: List<Coupon> ->
            Log.w("COUPON", coupons.toString())
            Log.w("COUPON", coupons[0].title)
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
        })
    }

}