package com.org.janitri.components
import android.R
import android.R.id.bold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.text.font.FontWeight
import com.org.janitri.ui.theme.IconPurple
import com.org.janitri.ui.theme.PurpleFooter
import com.org.janitri.ui.theme.PurpleHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JanitriAppBar(
    title: String,
    showBack: Boolean = false,
    onBackClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = IconPurple,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            if (showBack && onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PurpleHeader,
        )
    )
}

