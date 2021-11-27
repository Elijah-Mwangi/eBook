package com.example.deved


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_signup
import kotlinx.android.synthetic.main.activity_main.et_email
import kotlinx.android.synthetic.main.activity_main.et_firstname
import kotlinx.android.synthetic.main.activity_main.et_lastname
import kotlinx.android.synthetic.main.activity_main.et_password
import kotlinx.android.synthetic.main.activity_main.login
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()

        btn_signup.setOnClickListener{
            addUser()
        }

       login.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
        }


    }

    private fun addUser(){

        if (et_firstname.text.toString().isEmpty()) {
            et_firstname.error = "PLease enter your first name"
            et_firstname.requestFocus()
            return
        }

        if (et_lastname.text.toString().isEmpty()) {
            et_lastname.error = "PLease enter your last name"
            et_lastname.requestFocus()
            return
        }


        if(!Patterns.EMAIL_ADDRESS.matcher(et_email.text.toString()).matches()){
            et_email.error = "Please enter your address."
            et_email.requestFocus()
            return
        }

        if (et_password.text.toString().isEmpty()){
            et_password.error="PLease enter the correct password"
            et_firstname.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(et_email.text.toString(),et_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this,LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(baseContext, "Sign Up failed.",
                        Toast.LENGTH_SHORT).show()
                }


            }
    }


}
