package ir.ats.app1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ats.app1.components.FavoriteButton
import ir.ats.app1.components.GameRatingBox
import ir.ats.app1.ui.theme.ATSApp1Theme

class GameInfoActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ATSApp1Theme {
				MainView("")
			}
		}
	}
}

@Composable
private fun MainView(overview: String) {
	BoxWithConstraints(Modifier.fillMaxSize()) {
		Box(
			Modifier
				.align(Alignment.TopCenter)
				.fillMaxWidth()
				.height(maxHeight * 0.35f)
		) {
			Image(
				painter = painterResource(R.drawable.red_dead),
				contentDescription = "Game Picture",
				modifier = Modifier.fillMaxSize(),
				contentScale = ContentScale.Crop
			)
			
			IconButton(
				modifier = Modifier
					.offset(24.dp, 24.dp)
					.shadow(4.dp, RoundedCornerShape(8.dp))
					.background(Color.White, RoundedCornerShape(8.dp)),
				onClick = { }
			) {
				Icon(Icons.Rounded.ArrowBackIosNew, "Back", tint = MaterialTheme.colors.primary)
			}
		}
		
		Column(
			Modifier
				.align(Alignment.BottomCenter)
				.fillMaxWidth()
				.padding(bottom = 100.dp)
				.height(maxHeight * 0.7f - 80.dp)
				.background(Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
		) {
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier
					.fillMaxWidth()
					.padding(16.dp)
			) {
				Column {
					Text(
						text = "Red Dead Redemption 2 with some",
						fontSize = 18.sp,
						fontWeight = FontWeight.Bold,
						softWrap = false,
						overflow = TextOverflow.Ellipsis
					)
					
					Text(
						text = "PlayStation and X-Box",
						color = Color.Gray,
						softWrap = false,
						overflow = TextOverflow.Ellipsis
					)
				}
				
				FavoriteButton()
			}
			
			Spacer(modifier = Modifier.height(32.dp))
			
			Text(
				text = "Overview",
				fontWeight = FontWeight.Bold,
				modifier = Modifier.padding(start = 16.dp)
			)
			
			Text(
				text = overview,
				color = Color.Gray,
				modifier = Modifier.padding(horizontal = 16.dp),
				softWrap = true,
			)
			
			Spacer(modifier = Modifier.height(16.dp))
			
			GameRatingBox(
				Modifier
					.fillMaxWidth()
					.padding(horizontal = 16.dp),
				image = painterResource(R.drawable.red_dead),
				communityName = "Steam",
				availability = "Available"
			)
			
			Spacer(modifier = Modifier.height(16.dp))
			
			GameRatingBox(
				Modifier
					.fillMaxWidth()
					.padding(horizontal = 16.dp),
				image = painterResource(R.drawable.red_dead),
				communityName = "Epic Games",
				availability = "Available"
			)
		}
		
		Row(
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.align(Alignment.BottomCenter)
				.fillMaxWidth()
				.height(100.dp)
				.background(Color(0xFFF1F0F7), RoundedCornerShape(16.dp, 16.dp))
				.padding(horizontal = 16.dp)
		) {
			Text("Price $200.00", fontSize = 20.sp)
			
			Button(onClick = { }) {
				Text("Add to Cart", fontSize = 20.sp, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp))
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
	ATSApp1Theme {
		MainView(
			"""
			Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
			Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
			Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
		""".trimIndent()
		)
	}
}
