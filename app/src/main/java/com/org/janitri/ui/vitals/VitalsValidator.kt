package com.org.janitri.ui.vitals

object VitalsValidator {

    fun validate(
        s: String, d: String,
        hr: String, w: String, k: String
    ): String? {

        val sys = s.toIntOrNull() ?: return "Invalid systolic BP"
        val dia = d.toIntOrNull() ?: return "Invalid diastolic BP"
        val heart = hr.toIntOrNull() ?: return "Invalid heart rate"
        val weight = w.toFloatOrNull() ?: return "Invalid weight"
        val kicks = k.toIntOrNull() ?: return "Invalid baby kicks"

        if (sys <= 0 || dia <= 0) return "BP must be positive"
        if (heart !in 40..200) return "Heart rate out of range"
        if (weight <= 0f) return "Weight must be positive"
        if (kicks < 0) return "Baby kicks cannot be negative"

        return null
    }
}
