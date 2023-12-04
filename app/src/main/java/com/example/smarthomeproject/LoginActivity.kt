package com.example.smarthomeproject

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smarthomeproject.models.Loginuserpass
import com.example.smarthomeproject.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.time.Duration
import java.util.Locale

class LoginActivity : AppCompatActivity() {
    lateinit var dd: Loginuserpass
    private lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.funchangelang = this
        dd = Loginuserpass("behnam", "123456")
        binding.logindata = dd

        viewModel.respons.observe(this, Observer { it ->

            Toast.makeText(this@LoginActivity, it.toString(), Toast.LENGTH_SHORT).show()
        })

        println("Starting...")

        val job1 = GlobalScope.async {
            delay(4000)
            return@async "Result from job1"
        }

        val job2 = GlobalScope.async {
            delay(6000)
            return@async "Result from job2"
        }

        GlobalScope.launch {
            val result1 = job1.await()
            val result2 = job2.await()

            println("Result 1: $result1")
            println("Result 2: $result2")
        }
        println("End of onCreate.")
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..10) {
                delay(1500)
                withContext(Dispatchers.Main){
                    binding.textView.text = i.toString()
                }

            }

           /* async(Dispatchers.Main) {
                for (i in 1..10) {
                    delay(1500)
                    binding.textView.text = i.toString()
                }
            }.await()
            async(Dispatchers.Main) {
                for (i in 10 downTo 1) {
                    delay(1000)
                    binding.textView.text = i.toString()
                }
            }*/

        }

    }

    fun loginGetData(data: Loginuserpass) {
        viewModel.login(data.username, data.password);


        //  Toast.makeText(this@LoginActivity,data.username+" "+data.password, Toast.LENGTH_SHORT).show()
    }


    fun changelang() {
        // تغییر زبان از فارسی به انگلیسی (معکوس کردن زبان)
        val newLocale = if (isCurrentLanguagePersian()) Locale.ENGLISH else Locale("fa")

        // ذخیره تغییرات در تنظیمات زبان
        val res = resources
        val config = Configuration(res.configuration)
        Locale.setDefault(newLocale)
        config.setLocale(newLocale)
        res.updateConfiguration(config, res.displayMetrics)

        // اعمال تغییرات به اپلیکیشن
        recreate()
    }

    private fun isCurrentLanguagePersian(): Boolean {
        val currentLocale = resources.configuration.locale
        return currentLocale.language == "fa"
    }
}