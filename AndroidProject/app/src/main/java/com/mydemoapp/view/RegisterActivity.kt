package com.mydemoapp.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mydemoapp.R
import com.mydemoapp.database.AppDatabase
import com.mydemoapp.database.UserEntity
import com.mydemoapp.databinding.ActivityRegisterBinding
import com.mydemoapp.utils.DialogUtil
import com.mydemoapp.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_register
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    var registerActivityBinding: ActivityRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var registerViewModel: RegisterViewModel
        registerActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        btn_register.setOnClickListener {
            DialogUtil().showToast(this, "Register clicked")
            if (edt_username.text.toString().equals("")) {
                DialogUtil().showToast(this, "Name requied")
            } else if (edt_email_.text.toString().equals("")) {
                DialogUtil().showToast(this, "Email Id requied")
            } else if (edt_password_.text.toString().equals("")) {
                DialogUtil().showToast(this, "Password requied")
            } else {
                // DialogUtil().showToast(this,registerViewModel!!.name.toString())
                val db = AppDatabase(this)
                GlobalScope.launch {
                    db.userDao().insertAll(
                        UserEntity(
                            0,
                            edt_username.text.toString(),
                            edt_email_.text.toString(),
                            edt_password_.text.toString()
                        )
                    )
                }
                startActivity(Intent(this@RegisterActivity, HomeActivity::class.java))
            }
        }
    }
}