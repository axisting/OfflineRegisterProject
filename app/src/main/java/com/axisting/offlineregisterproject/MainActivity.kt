package com.axisting.offlineregisterproject

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var nameText : EditText
    private lateinit var surnameText : EditText
    private lateinit var ageText : EditText
    private lateinit var emailText : EditText
    private lateinit var passwordText : EditText
    private lateinit var saveButton : Button
    private lateinit var deleteButton : Button
    private lateinit var sharedPref : SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.nameText)
        surnameText = findViewById(R.id.surnameText)
        ageText = findViewById(R.id.ageText)
        emailText = findViewById(R.id.emailText)
        passwordText = findViewById(R.id.passwordText)
        saveButton = findViewById(R.id.saveButton)
        deleteButton = findViewById(R.id.deleteButton)
        sharedPref = this.getSharedPreferences("com.axisting.offlineregisterapp", Context.MODE_PRIVATE)


    }

    fun makePerson(view : View) {
        val name = nameText.text.toString()
        val surname = surnameText.text.toString()
        val age : Int? = ageText.text.toString().toIntOrNull()  //kişi burada yazı girebilir. Aslında ageText’i xml dosyasında tanımlarken number tipinde de tanımlayabilirdik. Veya bu yöntemi kullanarak kotlin dosyasında da güvenliğini sağlayabiliriz.
        val email = emailText.text.toString()
        val password = passwordText.text.toString()
        if (name.equals("") || surname.equals("") || age == null || email.equals("") || password.equals("")){
            Toast.makeText (applicationContext, "Tüm alanları doldurmalısın" , Toast.LENGTH_SHORT).show()
        }else
        {
            sharedPref.edit().putString ("name", name).apply()
            sharedPref.edit().putString("surname", surname).apply()
            sharedPref.edit().putInt("age", age).apply()
            sharedPref.edit().putString("email", email).apply()
            sharedPref.edit().putString("password", password).apply()


            val sharedName = sharedPref.getString("name","-1000")
            System.out.println(sharedName)



            Toast.makeText (applicationContext, "İsim : $name Soyad : $surname Yaş : $age Email : $email Şifre : $password" , Toast.LENGTH_LONG).show()
        }



    }
    fun deletePerson(view : View) {
        val sharedName = sharedPref.getString("name","-100")
        val sharedSurname = sharedPref.getString("surname","-100")
        val sharedAge = sharedPref.getInt("age",-100)
        val sharedEmail = sharedPref.getString("email","-100")
        val sharedPassword = sharedPref.getString("password","-100")
        if (!sharedName.equals("-100")){
            sharedPref.edit().remove("name").apply()
        }
        if (!sharedSurname.equals("-100")){
            sharedPref.edit().remove("surname").apply()
        }
        if (sharedAge != -100){
            sharedPref.edit().remove("age").apply()
        }
        if (!sharedEmail.equals("-100")){
            sharedPref.edit().remove("email").apply()
        }
        if (!sharedPassword.equals("-100")){
            sharedPref.edit().remove("password").apply()
        }

        Toast.makeText(applicationContext, "Paylaşılan Veriler Silindi..", Toast.LENGTH_SHORT).show()



    }


}
