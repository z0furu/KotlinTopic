package com.kotlintopic.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.kotlintopic.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {


    val TAG : String = MainActivity::class.java.simpleName

    //Google Login Result code
    val SignCode : Int = 100
    lateinit var mGoogleApiClient : GoogleApiClient


    private lateinit var btnSign : SignInButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initParam()
        initView()
    }

    override fun initParam() {

    }

    private fun initView() {
        btnSign = findViewById(R.id.btn_sign) as SignInButton
        btnSign.setOnClickListener(this)
    }

    /**
     * Google Login
     */
    fun googleLogin() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()


        startActivityForResult(Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient), SignCode)
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.d(TAG, p0.errorMessage)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SignCode) {
            showResult(Auth.GoogleSignInApi.getSignInResultFromIntent(data))
        }
    }

    /**
     * 顯示Google 登入結果
     */
    private fun showResult(signInResultFromIntent: GoogleSignInResult?) {
        if (signInResultFromIntent!!.isSuccess) {
            val account = signInResultFromIntent.signInAccount!!.displayName
            Toast.makeText(this, account, Toast.LENGTH_SHORT).show()
            startActivity(Main2Activity.IntentWithBundle(this, account!!))
            Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback {
                Log.d(TAG, "revokeAccess")
            }

            finish()

        } else {
            Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show()
        }
    }



    override fun onClick(v: View?) {
        googleLogin()
    }

}
