package com.edc.coffeenote.core.common.transition

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.navigation.NavBackStackEntry

data class DefaultTransitions(
    val enter: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
    val exit: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
    val popEnter: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
    val popExit: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null
)