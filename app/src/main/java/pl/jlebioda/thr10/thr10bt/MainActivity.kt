package pl.jlebioda.thr10.thr10bt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import kotlin.math.max
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    var counter = 1
    val MAX_COUNTER = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        val textViewCounter = findViewById<TextView>(R.id.TextViewCounter)
        val textViewStatus = findViewById<TextView>(R.id.TextViewStatus)


        button1.setOnClickListener {
            counter = max(1, counter - 1)
            updatePatch(textViewCounter)
        }

        button2.setOnClickListener {
            counter = min(MAX_COUNTER, counter + 1)
            updatePatch(textViewCounter)
        }

        button3.setOnClickListener {
            tryToConnect(textViewStatus)
        }
    }

    private fun tryToConnect(textViewStatus : TextView) {
        textViewStatus.text = getText(R.string.label4_caption_connecting)

        val r = Runnable {
            textViewStatus.text = getText(R.string.label4_caption_connected)
        }

        Handler().postDelayed(r, 3000)
    }

    private fun updatePatch(textViewCounter : TextView) {
        textViewCounter.text = counter.toString()
    }
}
