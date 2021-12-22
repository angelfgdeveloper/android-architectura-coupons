package com.angelfgdeveloper.android_architecture_app.model

import android.annotation.SuppressLint
import com.google.gson.JsonObject
import java.io.Serializable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Coupon(couponJson: JsonObject?) : Serializable {

    var id: String = ""
    var image_url: String = ""
    var title: String = ""
    var descriptionShort: String = ""
    var category: String = ""
    var description: String = ""
    var offer: String = ""
    var website: String = ""
    var endDate: String = ""
    var url: String = ""

    init {
        try {
            id = couponJson!!.get(ID).asString
            image_url = couponJson.get(IMAGE_URL).asString
            title = couponJson.get(TITLE).asString
            descriptionShort = chunkWords(couponJson.get(DESCRIPTION_SHORT).asString, ' ', 5)
            category = chunkWords(couponJson.get(CATEGORY).asString, ',', 1)
            description = couponJson.get(DESCRIPTION).asString
            offer = couponJson.get(OFFER).asString
            website = couponJson.get(WEBSITE).asString
            endDate = getFormatDate(couponJson.get(END_DATE).asString)
            url = couponJson.get(URL).asString
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    companion object {
        private const val ID = "lmd_id"
        private const val IMAGE_URL = "image_url"
        private const val TITLE = "title"
        private const val DESCRIPTION_SHORT = "offer_text"
        private const val CATEGORY = "categories"
        private const val DESCRIPTION = "description"
        private const val OFFER = "offer"
        private const val WEBSITE = "store"
        private const val END_DATE = "end_date"
        private const val URL = "url"
    }

    @SuppressLint("SimpleDateFormat")
    private fun getFormatDate(dateCoupon: String): String {
        val format = SimpleDateFormat("yyyy-MM-dd")
        val dateFormat = SimpleDateFormat("dd MMMM yyyy")
        return try {
            val parsedDateFormat = format.parse(dateCoupon)
            val cal = Calendar.getInstance()
            cal.time = parsedDateFormat
            dateFormat.format(cal.time)
        } catch (e: ParseException) {
            e.printStackTrace()
            ""
        }
    }


    private fun chunkWords(string: String, delimiter: Char, quantity: Int): String {
        val words = string.split(delimiter)
        var newString = ""

        for (i in 0..quantity) {
            newString += words[i] + " "
        }

        return newString
    }

}
