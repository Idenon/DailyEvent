package jp.idenon.dailyevent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val event = DailyEventController()

        executeButton.setOnClickListener{
            event.execute()
        }

        isDoneButton.setOnClickListener{
            if (event.isDoneDaily()) {
                // true だった時の処理
                Toast.makeText(applicationContext, "Done.", Toast.LENGTH_LONG).show()
            } else {
                // false だった時の処理
                Toast.makeText(applicationContext, "Not Done.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
