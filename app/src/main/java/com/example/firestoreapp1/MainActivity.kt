package com.example.firestoreapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firestoreapp1.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore


        binding.loginBtn.setOnClickListener {
            val user = hashMapOf(
                "name" to binding.nameEtxt.text.toString(),
                "pass" to binding.passEtxt.text.toString()
            )
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(this@MainActivity, "DocumentSnapshot added with ID: ${documentReference.id}",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this@MainActivity, "Error adding document"+e.localizedMessage,Toast.LENGTH_SHORT).show()
                }
        }


    }
}