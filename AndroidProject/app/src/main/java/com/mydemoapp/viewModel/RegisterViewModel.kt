package com.mydemoapp.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    var name: ObservableField<String> = ObservableField("")
    var email: ObservableField<String> = ObservableField("")
    var password: ObservableField<String> = ObservableField("")

}