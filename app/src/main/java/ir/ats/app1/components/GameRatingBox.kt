package ir.ats.app1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.ats.app1.R
import ir.ats.app1.ui.theme.ATSApp1Theme

@Composable
fun GameRatingBox(modifier: Modifier = Modifier, image: Painter, communityName: String, availability: String) {
	Row(
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically,
		modifier = modifier
	) {
		Row(verticalAlignment = Alignment.CenterVertically) {
			Image(
				painter = image,
				contentDescription = "Rating Community",
				contentScale = ContentScale.Crop,
				modifier = Modifier
					.requiredSize(48.dp)
					.clip(RoundedCornerShape(4.dp))
			)
			
			Column(Modifier.padding(start = 16.dp)) {
				Text(text = communityName)
				Text(text = availability, color = Color.Gray)
			}
		}
		
		Row {
			repeat(5) {
				Icon(Icons.Rounded.Star, "Star", tint = MaterialTheme.colors.primary)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun ThisPreview() {
	ATSApp1Theme {
		GameRatingBox(Modifier.fillMaxWidth(), painterResource(id = R.drawable.red_dead), "Epic Games", "Available")
	}
}
