package jp.idenon.dailyevent

import android.icu.util.Calendar.DATE
import android.icu.util.Calendar.MINUTE
import android.util.Log
import java.util.*

class DailyEventController(val thresholdHour: Int, val thresholdMinute: Int) {

    var isDone: Boolean = false
    lateinit var executeTime: Calendar

    // デイリー範囲内で実行済みかどうかを返す
    fun isDoneDaily(): Boolean {

        // 以前に実行されたことがないのであれば false
        if (!isDone) return false

        // 現在時刻を取得する
        val currentTime = Calendar.getInstance()

        // ２日以上離れていたら確実に超えている
        if (executeTime.get(DATE) <= currentTime.get(DATE) - 2) return false

        Log.d("executeTime", "date: ${executeTime?.get(MINUTE)}")
        return true
    }

    // イベントを実行し、実行時間を保持する
    fun execute() {
        val executeTime = Calendar.getInstance()
        Log.d("execute date", "date: ${executeTime.get(MINUTE)}")
        this.executeTime = executeTime
        isDone = true
    }

    // 現在時刻の直前のリセット時刻を作る
    fun calculateThresoldDate(thresholdHour: Int, thresholdMinute: Int, currentTime: Calendar){
        var thresholdTime = currentTime

        val currentHour = currentTime.get(Calendar.HOUR)
        val currentMinute = currentTime.get(Calendar.MINUTE)

        if (currentTime.get(Calendar.HOUR) > thresholdHour) {
            thresholdHour.set(Calendar.HOUR, currentHour)
        }

    }

    // 前回実行時間がリセット時刻より前にあるかどうかを返す
    fun isBeforeResetTime(){

    }

}