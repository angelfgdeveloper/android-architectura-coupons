package com.angelfgdeveloper.android_architecture_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angelfgdeveloper.android_architecture_app.model.Coupon
import com.angelfgdeveloper.android_architecture_app.R
import com.angelfgdeveloper.android_architecture_app.model.ApiAdapter
import com.angelfgdeveloper.android_architecture_app.presenter.CouponPresenter
import com.angelfgdeveloper.android_architecture_app.presenter.CouponPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)
        // VIEW
        rvCoupons = findViewById(R.id.rvCoupons) // UI
        rvCoupons?.layoutManager = LinearLayoutManager(this)
        // VIEW

        getCoupons()

    }

    override fun showCoupons(coupons: List<Coupon>?) {
        try {
            rvCoupons?.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }
}