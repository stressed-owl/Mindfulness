package com.delusional_bear.mindfulness.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun MindfulnessChallengeDescriptionText(
    description: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = description),
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier,
    )
}