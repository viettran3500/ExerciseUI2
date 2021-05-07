package com.viet.exerciseui2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import kotlinx.android.synthetic.main.activity_email.*

class EmailActivity : AppCompatActivity() {

    var count: Int = 30
    var thread: HandlerThread = HandlerThread("Thread")
    lateinit var runnable: Runnable
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        thread.start()
        handler = Handler(thread.looper)

        runnable = Runnable {
            if(count > 0){
                count--
                this.runOnUiThread {
                    textCountdown.text = "Wait " +  count + " seconds before sending it"
                }
                handler.postDelayed(runnable, 1000)
            }
            else{
                handler.removeCallbacks(runnable)
            }
        }

        handler.post(runnable)
    }
}
