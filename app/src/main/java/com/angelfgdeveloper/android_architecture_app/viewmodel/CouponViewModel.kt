package com.angelfgdeveloper.android_architecture_app.viewmodel

import android.annotation.SuppressLint
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angelfgdeveloper.android_architecture_app.R
import com.angelfgdeveloper.android_architecture_app.model.Coupon
import com.angelfgdeveloper.android_architecture_app.model.CouponObservable
import com.angelfgdeveloper.android_architecture_app.view.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponViewModel : ViewModel() {

    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupon() {
        couponObservable.callCoupon()
    }

    fun getCoupon(): MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupon()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>) {
        recyclerCouponsAdapter?.setCouponList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter? {
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCouponAt(position: Int): Coupon? {
        val coupons: List<Coupon>? = couponObservable.getCoupon().value
        return coupons?.get(position)
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?){
            imageUrl?.let {
                if (it.isNotEmpty())
                    Picasso.get().load(it).into(imageView)
            }
        }
    }

}