package jp.idenon.dailyevent

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*

class DailyEventControllerTest {
    @Test
    fun calculateThresholdDateTest() {

        val dailyEvent = DailyEventController(5, 0)

        // 現在時刻は 2019/06/03 12:00
        val currentDate = setCalender(2019, 6, 3, 12, 0)
        // しきい値は 05:00
        val thresholdDate = dailyEvent.calculateThresoldDate(5, 0, currentDate)

        assertEquals(thresholdDate.get(Calendar.DATE), 3)
        assertEquals(thresholdDate.get(Calendar.HOUR), 5)
        assertEquals(thresholdDate.get(Calendar.MINUTE), 0)
    }

    private fun setCalender(year: Int, month: Int, day: Int, hour: Int, minute: Int): Calendar {
        val date = Calendar.getInstance()

        date.set(Calendar.YEAR, year)
        date.set(Calendar.MONTH, month)
        date.set(Calendar.DATE, day)
        date.set(Calendar.HOUR, hour)
        date.set(Calendar.MINUTE, minute)

        return date
    }
}