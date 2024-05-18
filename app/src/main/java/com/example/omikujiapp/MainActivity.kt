package com.example.omikujiapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var startButton :  FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // ボタンのViewを読み込む

        startButton = findViewById(R.id.start_button)
        startButton.setOnClickListener(
            { v ->
                // todo: 占いロジックを実行する

                // 結果画面に遷移させる
                val intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("result_id",0)
                startActivity(intent)

            }

        )
    }
}