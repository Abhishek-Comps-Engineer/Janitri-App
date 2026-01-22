package com.org.janitri

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.org.janitri.ui.vitals.VitalsScreen
import com.org.janitri.ui.vitals.VitalsViewModel
import com.org.janitri.util.NavigationResolver
import com.org.janitri.util.ReminderScheduler
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ReminderScheduler.schedule(this)

        val openDialog = NavigationResolver.shouldOpenAddVitals(intent)

        setContent {
            val vm = hiltViewModel<VitalsViewModel>()
            VitalsScreen(vm = vm, openDialogInitially = openDialog)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
    }
}
