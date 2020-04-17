package com.example.braintreetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loopj.android.http.*
import com.braintreepayments.api.BraintreeFragment
import com.braintreepayments.api.exceptions.InvalidArgumentException
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import sun.jvm.hotspot.utilities.IntArray




class MainActivity : AppCompatActivity(), PaymentMethodNonceCreatedListener {

    var mAuthorization = ""
    var mBrainTreeFragment : BraintreeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initBrainTree() {

        try {
            mBrainTreeFragment = BraintreeFragment.newInstance(this, mAuthorization)
            // mBraintreeFragment is ready to use!
        } catch (e: InvalidArgumentException) {
            // There was an issue with your authorization string.
        }

    }



    fun getClientToken() {
        var client = AsyncHttpClient()

    }
}
