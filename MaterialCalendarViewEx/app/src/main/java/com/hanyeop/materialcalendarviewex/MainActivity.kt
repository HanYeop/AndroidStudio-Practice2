package com.hanyeop.materialcalendarviewex

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calenderView : MaterialCalendarView = findViewById(R.id.calendarView)
        var textView : TextView = findViewById(R.id.textView)

        // 선택된 날짜를 오늘로 바꿔줌
        calenderView.selectedDate = CalendarDay.today()

        // 현재 시간에 맞는 캘린더 정보
        var currentTimeCalendar = Calendar.getInstance()

        // 현재의 년,월,일
        val currentYear = calenderView.selectedDate?.year
        val currentMonth = calenderView.selectedDate?.month
        val currentDay = calenderView.selectedDate?.day
        Log.d("test5", "$currentYear")
        Log.d("test5", "$currentMonth")
        Log.d("test5", "$currentDay")

        val sundayDecorator = SundayDecorator()
//        val saturdayDecorator = SaturdayDecorator()
        val todayDecorator = TodayDecorator(this)

        calenderView.addDecorators(todayDecorator,sundayDecorator)

        // 선택된 날짜 확인
        calenderView.setOnDateChangedListener { widget, date, selected ->
            Log.d("test5", "$date")
            Log.d("test5", "${date.year}")
            Log.d("test5", "${date.month}")
            Log.d("test5", "${date.day}")
        }
    }
}