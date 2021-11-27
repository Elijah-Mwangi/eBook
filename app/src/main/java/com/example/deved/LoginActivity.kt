package com.example.deved

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_signup
import kotlinx.android.synthetic.main.activity_main.et_email
import kotlinx.android.synthetic.main.activity_main.et_firstname
import kotlinx.android.synthetic.main.activity_main.et_lastname
import kotlinx.android.synthetic.main.activity_main.et_password
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        signup.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()
        }

        btn_login.setOnClickListener{
            doLogin()
        }

    }

    private fun doLogin() {

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

        auth.signInWithEmailAndPassword(et_email.text.toString(), et_password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {

                    updateUI(null)
                    // ...
                }

                // ...
            }
    }

    public override fun onStart(){
        super.onStart()
        val currentUser:FirebaseUser? = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if(currentUser != null){
            startActivity(Intent(this,NavigationDrawer::class.java))
            finish()
            }else{
            Toast.makeText(baseContext, "Login failed.",
                Toast.LENGTH_SHORT).show()
        }

    }


}

