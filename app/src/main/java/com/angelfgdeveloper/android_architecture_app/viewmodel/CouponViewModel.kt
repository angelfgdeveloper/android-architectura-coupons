package com.angelfgdeveloper.android_architecture_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angelfgdeveloper.android_architecture_app.model.Coupon
import com.angelfgdeveloper.android_architecture_app.model.CouponObservable

class CouponViewModel : ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()

    fun callCoupon() {
        couponObservable.callCoupon()
    }

    fun getCoupon(): MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupon()
    }

}