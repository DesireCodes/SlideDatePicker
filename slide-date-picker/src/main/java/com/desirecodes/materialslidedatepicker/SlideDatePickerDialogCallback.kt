package com.desirecodes.materialslidedatepicker

import java.util.*

interface SlideDatePickerDialogCallback {
    fun onPositiveClick(day: Int, month: Int, year: Int, calendar: Calendar)
}