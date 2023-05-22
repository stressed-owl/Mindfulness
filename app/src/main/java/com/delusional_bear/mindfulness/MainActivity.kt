package com.delusional_bear.mindfulness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delusional_bear.mindfulness.data.DataSource
import com.delusional_bear.mindfulness.ui.MindfulnessCard
import com.delusional_bear.mindfulness.ui.MindfulnessCenterTopAppBar
import com.delusional_bear.mindfulness.ui.MindfulnessViewModel
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
    val viewModel: MindfulnessViewModel = viewModel()
    val context = LocalContext.current
    Scaffold(topBar = { MindfulnessCenterTopAppBar() }) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
        ) {
            LazyVerticalGrid(
                modifier = modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .weight(0.9f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(DataSource.challengeList) { MindfulnessCard(challenge = it) }
            }
            Text(
                text = stringResource(id = R.string.affirmation_text, viewModel.getRandomAffirmationOnDisplay(context)),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                lineHeight = 25.sp,
            )
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