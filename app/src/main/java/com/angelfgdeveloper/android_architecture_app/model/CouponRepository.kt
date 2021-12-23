package com.angelfgdeveloper.android_architecture_app.model

import androidx.lifecycle.MutableLiveData

interface CouponRepository {
    fun getCoupons(): MutableLiveData<List<Coupon>>
    fun callCouponsAPI()
}