package com.uragiristereo.noctiluca.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uragiristereo.noctiluca.app.theme.NoctilucaTheme

@Composable
fun App() {
    NoctilucaTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.systemBarsPadding()) {
                Text(text = "Hello, $platformName")
            }
        }
    }
}
