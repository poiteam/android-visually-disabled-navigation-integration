package com.poilabs.android_visually_disabled_navigation_integration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.getpoi.android_vd_nav_ui.view.PoiVdNavigationActivity
import com.poilabs.poilabspositioning.model.PLPStatus
import com.poilabs.vd.nav.non.ui.jsonclient.VDResponseListener
import com.poilabs.vd.nav.non.ui.models.LocationCallback
import com.poilabs.vd.nav.non.ui.models.PoiManager
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"

    }

    private var localeLanguage = Locale.forLanguageTag(Locale.getDefault().language).toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSDK()

    }


    private fun initSDK() {
        //Blindoors
        PoiManager.init(context = this,
            appId = BuildConfig.APPID,
            secret = BuildConfig.APPSECRET,
            language = localeLanguage,
            title = "Test title",
            vdResponseListener = object :
                VDResponseListener {
                override fun onSuccess() {
                    Intent(this@MainActivity, PoiVdNavigationActivity::class.java).also {
                        startActivity(it)
                    }
                }

                override fun onFail(p0: Throwable?) {
                    p0?.printStackTrace()
                }
            },
        locationCallback = object : LocationCallback {
            override fun onLocation(
                latitude: Double,
                longitude: Double,
                floorLevel: Int?,
                floorName: String?
            ) {

            }

            override fun onStatusChanged(status: PLPStatus) {

            }
        })
        PoiManager.setUniqueId("test unique id")
    }


}