package com.angelfgdeveloper.android_architecture_app.view

import com.angelfgdeveloper.android_architecture_app.model.Coupon

interface CouponView {
    // View
    fun showCoupons(coupons: List<Coupon>?)

    // Presenter
    fun getCoupons()
}