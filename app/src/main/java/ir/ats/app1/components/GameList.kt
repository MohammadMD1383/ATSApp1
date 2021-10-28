package ir.ats.app1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ats.app1.R
import ir.ats.app1.model.GameStruct

@Composable
fun GameList(listItems: SnapshotStateList<GameStruct>) {
	LazyColumn {
		items(listItems) { currentItem ->
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
					.padding(16.dp)
					.clickable(onClick = {})
			) {
				Box(
					Modifier
						.size(140.dp)
						.clip(RoundedCornerShape(8.dp))
				) {
					Image(painterResource(R.drawable.ic_launcher_background), "Game Pic", Modifier.fillMaxSize())
					Image(painterResource(R.drawable.ic_launcher_foreground), "Game Pic", Modifier.fillMaxSize())
				}
				
				Card(
					elevation = 0.dp,
					shape = RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp),
					backgroundColor = Color(0xFFFDF7FF),
					modifier = Modifier.fillMaxWidth()
				) {
					Column(
						modifier = Modifier
							.fillMaxWidth()
							.padding(vertical = 16.dp, horizontal = 8.dp)
					) {
						Text(
							text = currentItem.name,
							fontSize = 20.sp,
							fontWeight = FontWeight.Bold,
							overflow = TextOverflow.Ellipsis,
							softWrap = false
						)
						
						Text(
							text = currentItem.company,
							color = Color.Gray,
							modifier = Modifier.padding(top = 4.dp)
						)
						
						Row(
							verticalAlignment = Alignment.CenterVertically,
							horizontalArrangement = Arrangement.SpaceBetween,
							modifier = Modifier
								.fillMaxWidth()
								.padding(top = 16.dp)
						) {
							Row {
								Icon(Icons.Rounded.Star, "Ranking", tint = MaterialTheme.colors.primary)
								Text("${currentItem.rating}(${currentItem.rateCount})")
							}
							
							Text(
								"$%.2f".format(currentItem.cost),
								color = MaterialTheme.colors.primary,
								fontWeight = FontWeight.Bold
							)
						}
					}
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun ThisPreview() {
	MaterialTheme {
		GameList(
			mutableStateListOf(
				GameStruct(0, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
				GameStruct(1, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
				GameStruct(2, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
				GameStruct(3, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
				GameStruct(4, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
				GameStruct(5, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
				GameStruct(6, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
				GameStruct(7, "Some Game", "Rockstar", 4.5f, 566, 15.5f),
			)
		)
	}
}
