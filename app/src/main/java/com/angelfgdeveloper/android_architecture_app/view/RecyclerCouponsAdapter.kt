package com.angelfgdeveloper.android_architecture_app.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.angelfgdeveloper.android_architecture_app.BR
import com.angelfgdeveloper.android_architecture_app.model.Coupon
import com.angelfgdeveloper.android_architecture_app.viewmodel.CouponViewModel

class RecyclerCouponsAdapter(var couponViewModel: CouponViewModel, var resource: Int) :
    RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    private var coupons: List<Coupon>? = null

    fun setCouponList(coupons: List<Coupon>?) {
        this.coupons = coupons
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardCouponHolder(binding)
    }

    override fun getItemCount(): Int = coupons?.size ?: 0

    override fun onBindViewHolder(p0: CardCouponHolder, position: Int) {
        p0.setDataCard(couponViewModel, position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }

    class CardCouponHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        private var binding: ViewDataBinding? = null

        init {
            this.binding = binding
        }

        fun setDataCard(couponViewModel: CouponViewModel, position: Int) {
            binding?.setVariable(BR.model, couponViewModel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }

    }

}