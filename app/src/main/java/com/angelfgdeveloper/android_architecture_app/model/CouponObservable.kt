package com.angelfgdeveloper.android_architecture_app.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable : BaseObservable() {

    private var couponRepository: CouponRepository = CouponRepositoryImpl()

    // Repositorio
    fun callCoupon() {
        couponRepository.callCouponsAPI()
    }

    // ViewModel
    fun getCoupon(): MutableLiveData<List<Coupon>> {
        return couponRepository.getCoupons()
    }
}