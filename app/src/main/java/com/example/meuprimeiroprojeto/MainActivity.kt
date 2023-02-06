package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bntCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso : EditText = findViewById(R.id.edittext_peso)
        val edtAltura : EditText = findViewById(R.id.edittext_altura)

        bntCalcular.setOnClickListener {

            val alturaStar = edtAltura.text.toString()
            val pesoStar = edtPeso.text.toString()

            if (alturaStar.isNotEmpty() && pesoStar.isNotEmpty()) {
                val altura: Float = alturaStar.toFloat()
                val peso: Float = pesoStar.toFloat()

                val alturaFinal: Float = altura * altura
                val result: Float = peso / alturaFinal


                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }

                startActivity(intent)

            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}