package com.angelfgdeveloper.android_architecture_app.presenter

import com.angelfgdeveloper.android_architecture_app.model.Coupon
import com.angelfgdeveloper.android_architecture_app.model.CouponsInteractor
import com.angelfgdeveloper.android_architecture_app.model.CouponsInteractorImp
import com.angelfgdeveloper.android_architecture_app.view.CouponView

class CouponPresenterImpl(var couponView: CouponView) : CouponPresenter {

    private var couponInteractor: CouponsInteractor = CouponsInteractorImp(this)

    override fun showCoupons(coupons: List<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}