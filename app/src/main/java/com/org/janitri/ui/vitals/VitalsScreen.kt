package com.org.janitri.ui.vitals


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.org.janitri.components.JanitriAppBar
import com.org.janitri.ui.theme.PurpleFooter
import com.org.janitri.util.RequestNotificationPermissionIfNeeded

@Composable
fun VitalsScreen(
    vm: VitalsViewModel,
    openDialogInitially: Boolean
) {
    RequestNotificationPermissionIfNeeded()

    var showDialog by rememberSaveable { mutableStateOf(openDialogInitially) }
    val state by vm.uiState.collectAsState()

    Scaffold(
        topBar = {
            JanitriAppBar(
                title = "Track My Pregnancy",
                
            )
        },

        floatingActionButton = {

            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = PurpleFooter
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (state) {
                VitalsUiState.Loading ->
                    CircularProgressIndicator(Modifier.align(Alignment.Center))

                VitalsUiState.Empty ->
                    Text("No vitals added yet", Modifier.align(Alignment.Center))

                is VitalsUiState.Content -> {
                    LazyColumn {
                        items((state as VitalsUiState.Content).list) { vital ->
                            VitalsCard(vital)
                        }
                    }
                }

                is VitalsUiState.Error ->
                    Text(
                        (state as VitalsUiState.Error).message,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
            }
        }

        if (showDialog) {
            AddVitalsDialog(
                onDismiss = { showDialog = false },
                onSubmit = vm::addVitals
            )
        }
    }
}
