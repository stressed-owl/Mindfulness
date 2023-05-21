package com.delusional_bear.mindfulness.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.delusional_bear.mindfulness.R
import com.delusional_bear.mindfulness.data.Challenge

@Composable
fun MindfulnessCard(
    challenge: Challenge,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    ElevatedCard(
        modifier = modifier.clickable { expanded = !expanded },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMediumLow,
                    )
                ),
        ) {
            Text(
                text = stringResource(id = R.string.day, challenge.day.toString()),
                style = MaterialTheme.typography.labelLarge,
                modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
            Image(
                painter = painterResource(id = challenge.challengeImage),
                contentDescription = stringResource(id = challenge.challengeDescription),
            )
            if (expanded) MindfulnessChallengeDescriptionText(
                description = challenge.challengeDescription,
                modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}
