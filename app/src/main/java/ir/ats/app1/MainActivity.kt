package ir.ats.app1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ats.app1.components.GameList
import ir.ats.app1.components.SearchBox
import ir.ats.app1.model.GameStruct
import ir.ats.app1.ui.theme.ATSApp1Theme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ATSApp1Theme {
				MainView(remember {
					mutableStateListOf(GameStruct(1, "Red Dead Redemption 2", "RockStar", 4.5f, 125, 12f))
				})
			}
		}
	}
}

@Composable
private fun MainView(listItems: SnapshotStateList<GameStruct>) {
	val searchTerm = remember { mutableStateOf(TextFieldValue()) }
	
	Column(Modifier.fillMaxWidth()) {
		SearchBox(searchTerm)
		
		Divider(Modifier.padding(bottom = 24.dp))
		
		Text(
			"Found ${listItems.size} result${if (listItems.size > 1) "s" else ""}",
			modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold
		)
		
		GameList(listItems)
	}
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
	ATSApp1Theme {
		MainView(remember {
			mutableStateListOf(GameStruct(1, "Red Dead Redemption 2", "RockStar", 4.5f, 125, 12f))
		})
	}
}