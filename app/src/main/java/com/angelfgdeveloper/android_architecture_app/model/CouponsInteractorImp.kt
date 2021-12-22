package com.angelfgdeveloper.android_architecture_app.model

import com.angelfgdeveloper.android_architecture_app.presenter.CouponPresenter

class CouponsInteractorImp(var couponsPresenter: CouponPresenter) : CouponsInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponsPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}