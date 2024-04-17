package com.webservice.prontoticket.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.webservice.prontoticket.ui.theme.ProntoticketTheme

@Composable
fun Screen(content: @Composable () -> Unit) {
    ProntoticketTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            content = content
        )
    }
}
