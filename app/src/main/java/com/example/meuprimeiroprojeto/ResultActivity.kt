package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvResult.text = result.toString()

        /* menor que 18,5 abaixo do peso
        * entre 18,5 e 24,9 normal
        * entre 25,0 e 29,9 sobrepeso
        * entre 30,0 e 39,9 obesidade
        * maior que 40,0 obesidade grave */

        val classificacao = if (result < 18.5f){
            "CLASSIFICAÇÃO: ABAIXO DO PESO"
        }else if (result in 18.5f..24.9f){
            "CLASSIFICAÇÃO: NORMAL"
        }else if (result in 25.0f..29.9f){
            "CLASSIFICAÇÃO: SOBREPESO"
        }else if (result in 30.0f..39.9f){
            "CLASSIFICAÇÃO: OBESIDADE"
        }else{
            "CLASSIFICAÇÃO: OBESIDADE GRAVE"
        }

        tvClassificacao.text = classificacao

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}