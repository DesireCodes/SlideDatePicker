package com.desirecodes.materialslidedatepicker.example

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.desirecodes.materialslidedatepicker.SlideDatePickerDialog
import com.desirecodes.materialslidedatepicker.SlideDatePickerDialogCallback
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), SlideDatePickerDialogCallback {

    private val btnOpen: Button by lazy { findViewById<Button>(R.id.btn_open) }
    private val btnOpenTh: Button by lazy { findViewById<Button>(R.id.btn_open_th) }
    private val tvDate: TextView by lazy { findViewById<TextView>(R.id.tv_date) }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnOpen.setOnClickListener {
            SlideDatePickerDialog.newInstance(
                this,
                themeColor = getColor(com.desirecodes.materialslidedatepicker.example.R.color.colorPrimaryDark)
            )
                .show(supportFragmentManager, "TAG")
        }
        btnOpenTh.setOnClickListener {
            SlideDatePickerDialog.Builder(this)
                .setLocale(Locale("th"))
//                    .setYearModifier(543)
                .setThemeColor(getColor(com.desirecodes.materialslidedatepicker.example.R.color.colorAccent))
                .setHeaderDateFormat("EEE dd MMMM")
                .setCancelText("ยกเลิก")
                .setConfirmText("ตกลง")
                .setEndDate(Calendar.getInstance().apply {
                    add(Calendar.DATE, 15)
                })
                .setStartDate(Calendar.getInstance().apply {
                    set(Calendar.DATE, this.get(Calendar.DATE) - 0)
                })
                .setPreselectedDate(Calendar.getInstance())
                .build()
                .show(supportFragmentManager, "TAG")
        }

    }

    override fun onPositiveClick(day: Int, month: Int, year: Int, calendar: Calendar) {
        tvDate.text = SimpleDateFormat("EEEE, MMM dd, yyyy").format(calendar.time)
    }
}
