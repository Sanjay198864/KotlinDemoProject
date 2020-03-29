package com.mydemoapp.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel


class LoginViewModel() : ViewModel() {

    var email: ObservableField<String> = ObservableField("")
    var password: ObservableField<String> = ObservableField("")

}