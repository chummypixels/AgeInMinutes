package com.example.ageinmins

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSelect.setOnClickListener {view ->
            clickDatePicker(view);

        }

    }

    fun clickDatePicker(view: View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                    Toast.makeText(this, "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth", Toast.LENGTH_LONG).show();
                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                    tvSelectedDate.setText(selectedDate)

                    val sdf = SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH)
                    val theDate = sdf.parse(selectedDate)

                    val dateInMinutes = theDate!!.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    val currentDateToMinutes = currentDate!!.time / 60000
                    val differenceInMinutes = currentDateToMinutes - dateInMinutes

                    tvSelectedDateInMinutes.setText(differenceInMinutes.toString())
                },

                year, month, day).show()

    }

}