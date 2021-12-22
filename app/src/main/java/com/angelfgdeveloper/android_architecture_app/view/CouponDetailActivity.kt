package com.angelfgdeveloper.android_architecture_app.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.angelfgdeveloper.android_architecture_app.model.Coupon
import com.angelfgdeveloper.android_architecture_app.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponDetailActivity : AppCompatActivity() {
    private var couponSelected: Coupon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coupon_detail)

        couponSelected = intent.getSerializableExtra("COUPON") as Coupon

        val tvTitleDetail: TextView = findViewById(R.id.tvTitleDetail)
        val tvDescriptionShortDetail: TextView = findViewById(R.id.tvDescriptionShortDetail)
        val tvCategoryDetail: TextView = findViewById(R.id.tvCategoryDetail)
        val tvDateDetail: TextView = findViewById(R.id.tvDateDetail)
        val tvDescriptionDetailData: TextView = findViewById(R.id.tvDescriptionDetailData)
        val tvOffertDetailData: TextView = findViewById(R.id.tvOffertDetailData)
        val tvWebsiteDetailData: TextView = findViewById(R.id.tvWebsiteDetailData)
        val tvDateEndData: TextView = findViewById(R.id.tvDateEndData)
        val imgHeaderDetail: ImageView = findViewById(R.id.imgHeaderDetail)
        val imgCouponDetail: CircleImageView = findViewById(R.id.imgCouponDetail)
        val btnOpenOffer: Button = findViewById(R.id.btnOpenOffer)

        tvTitleDetail.text = couponSelected?.title
        tvDescriptionShortDetail.text = couponSelected?.descriptionShort
        tvCategoryDetail.text = couponSelected?.category
        tvDateDetail.text = couponSelected?.endDate
        tvDescriptionDetailData.text = couponSelected?.description
        tvOffertDetailData.text = couponSelected?.offer
        tvWebsiteDetailData.text = couponSelected?.website
        tvDateEndData.text = couponSelected?.endDate

        if (couponSelected?.image_url!!.isNotEmpty()) {
            Picasso.get().load(couponSelected?.image_url).resize(520, 520).centerCrop()
                .into(imgHeaderDetail)

            Picasso.get().load(couponSelected?.image_url).resize(520, 520).centerCrop()
                .into(imgCouponDetail)
        } else {
            Picasso.get()
                .load("https://c.cfjump.com/Avatars/ECED3475-931C-41F1-B3CD-513CD7FDFDCA.png")
                .resize(520, 520).centerCrop()
                .into(imgHeaderDetail)
            Picasso.get()
                .load("https://c.cfjump.com/Avatars/ECED3475-931C-41F1-B3CD-513CD7FDFDCA.png")
                .resize(520, 520).centerCrop()
                .into(imgCouponDetail)
        }

        btnOpenOffer.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(couponSelected?.url)
            startActivity(openURL)
        }

    }
}