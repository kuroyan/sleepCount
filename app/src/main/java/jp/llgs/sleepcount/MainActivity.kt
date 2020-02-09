package jp.llgs.sleepcount

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var sheepCount = 0
    var mp: MediaPlayer? = null // 追加

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var greeting = "こんにちは"
        val trialTime = Date()
        val calendar = GregorianCalendar()
        calendar.time = trialTime

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        if (hour in 1..11) {
            greeting = "おはよう"
        } else if (hour > 15) {
            greeting = "こんばんは"
        }

        greeting += "ねむれませんか？"

        mp = MediaPlayer.create(applicationContext, R.raw.sheep_cry1) // 追加
        mp?.start()

        textview.text = greeting
        this.rootLayout.setOnClickListener {
            sheepCount++
            val sheepText = "ひつじが$sheepCount 匹"
            textview.text = sheepText

            when (sheepCount % 2) {
                0 -> {
                    imageView1.setImageResource(R.drawable.sheep_1)
                    mp?.start()
                }    // 追加
                else -> {
                    imageView1.setImageResource(R.drawable.sheep_2)
                    mp?.start()
                } // 追加
            }
        }
    }
}
