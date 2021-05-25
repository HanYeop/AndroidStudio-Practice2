package com.hanyeop.materialcalendarviewex

import android.graphics.Color
import android.text.style.ForegroundColorSpan
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import java.util.*

class SundayDecorator: DayViewDecorator {
    val calendar = Calendar.getInstance()
    override fun shouldDecorate(day: CalendarDay): Boolean {

        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
    }
    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(object : ForegroundColorSpan(Color.RED) {})
    }
}



