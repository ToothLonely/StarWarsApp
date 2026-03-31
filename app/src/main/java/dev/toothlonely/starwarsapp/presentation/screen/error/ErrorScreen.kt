package dev.toothlonely.starwarsapp.presentation.screen.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import dev.toothlonely.starwarsapp.R
import dev.toothlonely.starwarsapp.presentation.component.RefreshButton

@Composable
fun ErrorScreen(onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.error_loading_message),
            textAlign = TextAlign.Center
        )
        RefreshButton(onClick)
    }
}