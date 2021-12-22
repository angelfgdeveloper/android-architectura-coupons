package com.angelfgdeveloper.android_architecture_app.presenter

import com.angelfgdeveloper.android_architecture_app.model.Coupon

interface CouponPresenter {
    // View
    fun showCoupons(coupons: List<Coupon>?)

    // Interactor
    fun getCoupons()

}