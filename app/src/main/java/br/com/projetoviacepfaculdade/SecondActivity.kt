package br.com.projetoviacepfaculdade

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.projetoviacepfaculdade.databinding.ActivitySecondBinding
const val tag1 = "second"
class SecondActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnVoltar.setOnClickListener {
            onRestart()
        }
    }
    override fun onStart() {
        Log.i("second"::class.java.simpleName, "onStart")
        super.onStart()
    }
    override fun onResume() {
        super.onResume()
        Log.i(tag1, "onResume: ")
    }
    override fun onPause() {
        super.onPause()
        Log.d(tag1, "onPause: ")
    }
    override fun onStop() {
        super.onStop()
        Log.i(tag1, "onStop: ")
    }
    override fun onRestart() {
        super.onRestart()
        segundaTela()
        Log.d(tag1, "onRestart main")

    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag1, "onDestroy: ")
    }
    fun segundaTela(){
        val segunda_tela = Intent(this, MainActivity::class.java)
        startActivity(segunda_tela)
    }
}