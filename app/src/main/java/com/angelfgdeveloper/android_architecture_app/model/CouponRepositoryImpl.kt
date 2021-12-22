package com.angelfgdeveloper.android_architecture_app.model

import android.util.Log
import com.angelfgdeveloper.android_architecture_app.presenter.CouponPresenter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(var couponPresenter: CouponPresenter): CouponRepository {

    // TODA LA LÓGICA DE CONEXIÓN
    override fun getCouponsAPI() {
        // CONTROLLER
        val coupons: ArrayList<Coupon> = ArrayList()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message.toString())
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")

                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Coupon(jsonObject)
                    coupons.add(coupon)
                }

                couponPresenter.showCoupons(coupons)
            }
        })
        // CONTROLLER
    }
}