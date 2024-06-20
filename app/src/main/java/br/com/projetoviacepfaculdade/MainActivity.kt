package br.com.projetoviacepfaculdade

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.projetoviacepfaculdade.databinding.ActivityMainBinding
const val tag = "main"
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(tag, "onCreate")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.btnAbrir.setOnClickListener{
            startActivity(
                Intent(this, SecondActivity::class.java)
            )
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        Log.d("main", "onStart")

        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause: ")
    }
    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy: ")
    }
    inner class MinhaClasse: Thread() {
         override  fun run()  {
             super.run()
         }
     }



}