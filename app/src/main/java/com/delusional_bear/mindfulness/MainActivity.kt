package com.delusional_bear.mindfulness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.delusional_bear.mindfulness.data.DataSource
import com.delusional_bear.mindfulness.ui.MindfulnessCard
import com.delusional_bear.mindfulness.ui.MindfulnessCenterTopAppBar
import com.delusional_bear.mindfulness.ui.theme.MindfulnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindfulnessTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) { MindfulnessApp() }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MindfulnessApp(modifier: Modifier = Modifier) {
    Scaffold(topBar = { MindfulnessCenterTopAppBar() }) { paddingValues ->
        LazyVerticalGrid(
            modifier = modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_small)),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = paddingValues,
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(DataSource.challengeList) { MindfulnessCard(challenge = it) }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MindfulnessAppLightThemePreview() {
    MindfulnessTheme {
        MindfulnessApp()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MindfulnessAppDarkThemePreview() {
    MindfulnessTheme(darkTheme = true) {
        MindfulnessApp()
    }
}