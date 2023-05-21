package com.delusional_bear.mindfulness.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * [Challenge] data class for the description of the challenge
 * on the 30-day mindfulness challenge
 */
data class Challenge(
    @StringRes val challengeDescription: Int,
    @DrawableRes val challengeImage: Int,
    val day: Int,
)
