package dev.toothlonely.starwarsapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.toothlonely.starwarsapp.domain.Character

@Composable
fun Item(
    firstLine: String,
    secondLine: String? = null,
    thirdLine: String? = null,
    modifier: Modifier = Modifier
) {

    val firstLineTextStyle = TextStyle(
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    val secondLineTextStyle = TextStyle(
        color = Color(0xFF454545),
        fontSize = 13.sp
    )
    val thirdLineTextStyle = TextStyle(
        color = Color.Gray,
        fontSize = 12.sp
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = firstLine, style = firstLineTextStyle)
        if (secondLine != null) {
            Text(text = secondLine, style = secondLineTextStyle)
        }
        if (thirdLine != null) {
            Text(text = thirdLine, style = thirdLineTextStyle)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ItemPreview() {
    val character = Character(
        name = "Luke",
        birthYear = "1996",
        gender = "male",
        height = "200",
        homeworld = "Tatooine",
        species = "Wookie"
    )
    with(character) {
        Item(
            firstLine = name,
            secondLine = "$species, $gender,  $height cm",
            thirdLine = homeworld
        )
    }
}