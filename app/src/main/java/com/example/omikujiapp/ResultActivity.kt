package com.example.omikujiapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    lateinit var  backButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var resultTitle = findViewById<TextView>(R.id.result_title)
        var resultImage = findViewById<ImageView>(R.id.result_image)
        var resultMessage = findViewById<TextView>(R.id.result_message)

        // 結果によって内容を差し替え
        val result = intent.getIntExtra("result_id", -1)
        val resultData: Results = when (result) {
            -1-> {
                Log.d("TAG", "エラー")
                return
            }
            0-> Results(R.string.great_curse, R.drawable.great_curse, R.string.great_curse_message)
            1-> Results(R.string.curse, R.drawable.curse, R.string.curse_message)
            2-> Results(R.string.uncertain_luck,R.drawable.uncertain_luck,R.string.uncertain_luck_message)
            3-> Results(R.string.small_blessing, R.drawable.small_blessing, R.string.small_blessing_message)
            4-> Results(R.string.blessing, R.drawable.blessing, R.string.blessing_message)
            5-> Results(
                R.string.middle_blessing,
                R.drawable.middle_blessing,
                R.string.middle_blessing_message
            )
            6-> Results(
                R.string.great_blessing,
                R.drawable.great_blessing,
                R.string.great_blessing_message)

            else->Results(R.string.small_blessing, R.drawable.small_blessing, R.string.small_blessing_message)

        }
        resultTitle.setText(resultData.resultTitleResId)
        resultImage.setImageResource(resultData.resultImageResId)
        resultMessage.setText(resultData.resultMessageId)



        // 戻る
        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener(
            { v ->

                // おみくじ画面に遷移させる
                val intent = Intent(this@ResultActivity, MainActivity::class.java)
                startActivity(intent)


            }


        )
    }
}