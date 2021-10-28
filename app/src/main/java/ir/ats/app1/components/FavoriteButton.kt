package ir.ats.app1.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.ats.app1.ui.theme.ATSApp1Theme

@Composable
fun FavoriteButton() {
	var isChecked by remember { mutableStateOf(false) }
	val animation = updateTransition(targetState = isChecked, label = "Favorite toggle button")
	val tintColor by animation.animateColor(label = "Tint") { if (it) Color.White else MaterialTheme.colors.primary }
	val bgColor by animation.animateColor(label = "Background") { if (it) MaterialTheme.colors.primary else Color.White }
	
	IconToggleButton(
		modifier = Modifier
			.shadow(4.dp, CircleShape)
			.background(bgColor, CircleShape),
		checked = isChecked,
		onCheckedChange = { isChecked = !isChecked }
	) {
		Icon(Icons.Rounded.Favorite, "Favorite", tint = tintColor)
	}
}

@Preview(showBackground = true)
@Composable
private fun ThisPreview() {
	ATSApp1Theme {
		FavoriteButton()
	}
}
