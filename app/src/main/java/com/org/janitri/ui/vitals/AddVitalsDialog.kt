package com.org.janitri.ui.vitals

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.janitri.ui.theme.IconPurple

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (systolic: String, diastolic: String, heartRate: String, weight: String, babyKicks: String) -> Unit
) {
    var s by remember { mutableStateOf("") }
    var d by remember { mutableStateOf("") }
    var hr by remember { mutableStateOf("") }
    var w by remember { mutableStateOf("") }
    var k by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Add Vitals",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp) // space between fields
                ) {
                    OutlinedTextField(
                        value = s,
                        onValueChange = { s = it },
                        label = { Text("Sys BP") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )

                    OutlinedTextField(
                        value = d,
                        onValueChange = { d = it },
                        label = { Text("Dia BP") },
                        singleLine = true,
                        modifier = Modifier.weight(1f)
                    )
                }

                OutlinedTextField(
                    value = hr,
                    onValueChange = { hr = it },
                    label = { Text("Heart Rate") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = w,
                    onValueChange = { w = it },
                    label = { Text("Weight (in kg)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = k,
                    onValueChange = { k = it },
                    label = { Text("Baby Kicks") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        onSubmit(s, d, hr, w, k)
                        onDismiss()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = IconPurple),
                    modifier = Modifier
                        .padding(top = 38.dp)
                ) {
                    Text("Submit", color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}


