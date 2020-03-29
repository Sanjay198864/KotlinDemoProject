package com.mydemoapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mydemoapp.R
import com.mydemoapp.adapters.AnimalAdapter
import com.mydemoapp.database.AppDatabase
import com.mydemoapp.database.UserDao
import com.mydemoapp.database.UserEntity
import com.mydemoapp.databinding.ActivityHomeBinding
import com.mydemoapp.viewModel.HomeActivityViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    // private lateinit var userEntity: LiveData<List<UserEntity>>
    var homeActivityBinding: ActivityHomeBinding? = null
    var homeActivityViewModel: HomeActivityViewModel? = null
    // Initializing an empty ArrayList to be filled with animals
    val animals: ArrayList<String> = ArrayList()
    var userEntity: List<UserEntity>? = null
    val db = AppDatabase(this)
    var userDao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeActivityViewModel = ViewModelProvider(this)[HomeActivityViewModel::class.java]
        // Loads animals into the ArrayList
        userDao = db.userDao();
        addAnimals()
        addUsers()

        // Creates a vertical Layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
        //  recyclerview.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        recyclerview.adapter = AnimalAdapter(userEntity!!, this)
        recyclerview.adapter!!.notifyDataSetChanged()

    }

    fun addUsers() {

        GlobalScope.launch {
            userEntity = userDao!!.getAll()
        }
        //  DialogUtil().showToast(this,"user:"+userEntity!!.value)
    }

    // Adds animals to the empty animals ArrayList
    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }
}
