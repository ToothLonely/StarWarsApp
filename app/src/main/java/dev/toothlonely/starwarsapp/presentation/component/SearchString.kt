package dev.toothlonely.starwarsapp.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import dev.toothlonely.starwarsapp.R

@Composable
fun SearchString(query: String, onQueryChanged: (String) -> Unit, search: () -> Unit) {

    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
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
        keyboardActions = KeyboardActions(
            onSearch = {
                search()
            }
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
@Preview(showBackground = true)
private fun SearchStringPreview() {
    SearchString("", {}, {})
}