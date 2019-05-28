package jp.idenon.dailyevent

import android.icu.util.Calendar.MINUTE
import android.util.Log
import java.util.*

class DailyEventController {

    var prevTime: Calendar? = null

    // デイリー範囲内で実行済みかどうかを返す
    fun isDoneDaily(): Boolean {
        return false
    }

    // イベントを実行し、実行時間を保持する
    fun execute() {
        val executeTime = Calendar.getInstance()
        Log.d("execute date", "date: ${executeTime.get(MINUTE)}")
        prevTime = executeTime
    }
}