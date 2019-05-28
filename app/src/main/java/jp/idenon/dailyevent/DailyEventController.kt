package jp.idenon.dailyevent

import android.icu.util.Calendar.MINUTE
import android.util.Log
import java.util.*

class DailyEventController {

    // デイリー範囲内で実行済みかどうかを返す
    fun isDoneDaily(): Boolean {
        return false
    }

    // イベントを実行し、実行時間を保持する
    fun execute() {
        val prevTime = Calendar.getInstance()
        Log.d("execute date", "date: ${prevTime.get(MINUTE)}")
    }
}