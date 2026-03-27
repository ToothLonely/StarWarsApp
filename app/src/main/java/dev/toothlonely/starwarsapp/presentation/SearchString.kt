package dev.toothlonely.starwarsapp.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import dev.toothlonely.starwarsapp.R

@Composable
fun SearchString() {

    OutlinedTextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = "Search icon"
            )
        },
        placeholder = {
            Text(text = stringResource(R.string.search_string_placeholder))
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30))
    )
}

@Composable
@Preview
private fun SearchStringPreview() {
    SearchString()
}