package jp.idenon.dailyevent

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*

class DailyEventControllerTest {

    @Test
    fun calculateThresholdDateTest() {

        val dailyEvent = DailyEventController(5, 0)

        // 現在時刻は 2019/06/03 12:00
        var currentDate = setCalender(2019, 6, 3, 12, 0)

        // しきい値を 05:00 とする
        var thresholdDate = dailyEvent.calculateThresholdDate(5, 0, currentDate)

        assertEquals(thresholdDate.get(Calendar.DATE), 3)
        assertEquals(thresholdDate.get(Calendar.HOUR_OF_DAY), 5)
        assertEquals(thresholdDate.get(Calendar.MINUTE), 0)

        // しきい値を 17:00 とする
        thresholdDate = dailyEvent.calculateThresholdDate(14, 0, currentDate)

        assertEquals(thresholdDate.get(Calendar.DATE), 2)
        assertEquals(thresholdDate.get(Calendar.HOUR_OF_DAY), 14)
        assertEquals(thresholdDate.get(Calendar.MINUTE), 0)


        // 現在時刻を 2019/01/01 00:00 に変える
        // 年の境界テスト
        currentDate = setCalender(2019, 0, 1, 0, 0)

        // しきい値を 05:00 とする
        val thresholdDate2 = dailyEvent.calculateThresholdDate(5, 0, currentDate)

        assertEquals(thresholdDate2.get(Calendar.YEAR), 2018)
        assertEquals(thresholdDate2.get(Calendar.MONTH) ,11)
        assertEquals(thresholdDate2.get(Calendar.DATE), 31)
        assertEquals(thresholdDate2.get(Calendar.HOUR_OF_DAY), 5)
        assertEquals(thresholdDate2.get(Calendar.MINUTE), 0)

    }

    private fun setCalender(year: Int, month: Int, day: Int, hour: Int, minute: Int): Calendar {
        val date = Calendar.getInstance()

        date.set(Calendar.YEAR, year)
        date.set(Calendar.MONTH, month)
        date.set(Calendar.DATE, day)
        date.set(Calendar.HOUR_OF_DAY, hour)
        date.set(Calendar.MINUTE, minute)

        return date
    }

    @Test
    fun diffCalendarTest(){
        val a = setCalender(2019, 0, 1, 0, 0)
        val b = setCalender(1990, 0, 1, 0, 0)

        assertEquals(a.after(b), true)
    }
}