package com.org.janitri.ui.vitals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.janitri.data.local.VitalsEntity
import com.org.janitri.ui.theme.JanitriAppTheme
import com.org.janitri.ui.theme.PurpleCard
import com.org.janitri.ui.theme.PurpleFooter


@Composable
fun VitalsCard(
    vital: VitalsEntity,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = PurpleCard)
    ) {
        Column {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VitalItem(Icons.Default.Favorite, "${vital.heartRate} bpm")
                    VitalItem(
                        Icons.Default.MonitorHeart,
                        "${vital.systolic}/${vital.diastolic} mmHg"
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    VitalItem(Icons.Default.Scale, "${vital.weight} kg")
                    VitalItem(Icons.Default.DirectionsWalk, "${vital.babyKicks} kicks")
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PurpleFooter)
                    .padding(vertical = 8.dp, horizontal = 8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = formatTimestamp(vital.timestamp),
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
    }
}



@Preview(
    name = "Vitals Card",
    showBackground = true,
    backgroundColor = 0xFFF2F2F2,
    showSystemUi = true
)
@Composable
fun VitalsCardPreview() {
    JanitriAppTheme() {
        VitalsCard(
            vital = VitalsEntity(
                systolic = 120,
                diastolic = 80,
                heartRate = 90,
                weight = 68f,
                babyKicks = 15,
                timestamp = System.currentTimeMillis()
            )
        )
    }
}
