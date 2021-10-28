package ir.ats.app1.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.ats.app1.ui.theme.ATSApp1Theme

@Composable
fun SearchBox(searchTerm: MutableState<TextFieldValue>) {
	TextField(
		value = searchTerm.value,
		onValueChange = { searchTerm.value = it },
		singleLine = true,
		label = { Text("Search") },
		leadingIcon = { Icon(Icons.Rounded.Search, "Search") },
		trailingIcon = { Icon(Icons.Rounded.Tune, "Filter") },
		shape = RoundedCornerShape(8.dp),
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 16.dp, vertical = 24.dp)
			.border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
			.shadow(4.dp, RoundedCornerShape(8.dp)),
		colors = TextFieldDefaults.textFieldColors(
			backgroundColor = MaterialTheme.colors.background,
			disabledIndicatorColor = Color.Transparent,
			errorIndicatorColor = Color.Transparent,
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent
		)
	)
}

@Preview(showBackground = true)
@Composable
private fun ThisPreview() {
	ATSApp1Theme {
		SearchBox(remember { mutableStateOf(TextFieldValue()) })
	}
}