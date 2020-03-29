package com.mydemoapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mydemoapp.R
import com.mydemoapp.database.AppDatabase
import com.mydemoapp.database.UserEntity
import com.mydemoapp.databinding.ActivityLoginBinding
import com.mydemoapp.utils.DialogUtil
import com.mydemoapp.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var loginActivityBinding: ActivityLoginBinding
    var data: UserEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loginModel: LoginViewModel
        loginActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginModel = ViewModelProvider(this)[LoginViewModel()::class.java]
        //loginModel!!.setContext(this)
        //Intent inten
        /* val user = LoginInfo()
         user.userEmail = "abc@gmail.com"
         user.userPassword = "1234"
         loginActivityBinding.loginUser = user

 */
        btn_login.setOnClickListener {
            DialogUtil().showToast(this, "Login Clicked")
            if (edt_email.text.toString().equals("")) {
                DialogUtil().showToast(this, "Email Id requied")
            } else if (edt_password.text.toString().equals("")) {
                DialogUtil().showToast(this, "Password requied")
            } else {
                try {
                    val db = AppDatabase(this)
                    GlobalScope.launch {
                        data = db.userDao().findByTitle(edt_email.text.toString())
                        //data = db.userDao().findByTitle()
                    }
                    DialogUtil().showToast(this, "" + data.toString())
                    if (data != null) {
                        startActivity(Intent(this, HomeActivity::class.java))
                        // edt_email.text =
                        //  edt_password.text =""
                    } else {
                        DialogUtil().showToast(this, "Invalid User")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        btn_register.setOnClickListener {
            DialogUtil().showToast(this, "Register Clicked")
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

}