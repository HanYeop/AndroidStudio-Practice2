package com.hanyeop.alarmex

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import com.hanyeop.alarmex.Constant.Companion.ALARM_TIMER
import com.hanyeop.alarmex.Constant.Companion.NOTIFICATION_ID
import com.hanyeop.alarmex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰바인딩
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        val intent = Intent(this,MyReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this, NOTIFICATION_ID, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // 토글버튼 활성화 시 알림을 생성하고 토스트 메세지로 출력
        binding.toggleButton.setOnCheckedChangeListener { _, check ->
            val toastMessage = if (check) {
                val triggerTime = (SystemClock.elapsedRealtime() // 기기가 부팅된 후 경과한 시간 사용
                        + ALARM_TIMER * 1000) // ms 이기 때문에 초단위로 변환 (*1000)
                alarmManager.set(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    triggerTime,
                    pendingIntent
                ) // set : 일회성 알림
                "$ALARM_TIMER 초 후에 알림이 발생합니다."
            } else {
                alarmManager.cancel(pendingIntent)
                "알림 예약을 취소하였습니다."
            }

            /*
            1. ELAPSED_REALTIME : ELAPSED_REALTIME 사용. 절전모드에 있을 때는 알람을 발생시키지 않고 해제되면 발생시킴.
            2. ELAPSED_REALTIME_WAKEUP : ELAPSED_REALTIME 사용. 절전모드일 때도 알람을 발생시킴.
            3. RTC : Real Time Clock 사용. 절전모드일 때는 알람을 발생시키지 않음.
            4. RTC_WAKEUP : Real Time Clock 사용. 절전모드 일 때도 알람을 발생시킴.
             */

            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}