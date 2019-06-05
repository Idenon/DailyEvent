package jp.idenon.dailyevent

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
        // 直近のしきい日時を計算する
        val thresholdTime = calculateThresholdDate(thresholdHour, thresholdMinute, currentTime)

        // しきい日時が、前回実行日時よりも後にあったら false
        // |----+[executeTime]+----+[thresholdTime]+----+[currentTime]+---|
        if (thresholdTime.after(executeTime)) return false

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
    fun calculateThresholdDate(thresholdHour: Int, thresholdMinute: Int, currentTime: Calendar): Calendar {
        var thresholdTime = currentTime.clone() as Calendar

        thresholdTime.set(Calendar.HOUR_OF_DAY, thresholdHour)
        thresholdTime.set(Calendar.MINUTE, thresholdMinute)

        // 現在時刻がしきい日時より先に来てたら、しきい日時を１日前にする
        if (currentTime.before(thresholdTime)) {
            thresholdTime.add(Calendar.DAY_OF_MONTH, -1)
        }

        Log.d("threshold", "threshold time is: ${thresholdTime.get(Calendar.MONTH)+1}/${thresholdTime.get(Calendar.DAY_OF_MONTH)} ${thresholdTime.get(Calendar.HOUR_OF_DAY)}:${thresholdTime.get(Calendar.MINUTE)}")

        return thresholdTime
    }

}