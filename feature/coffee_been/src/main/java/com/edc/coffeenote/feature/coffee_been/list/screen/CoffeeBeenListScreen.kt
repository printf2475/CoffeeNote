package com.edc.coffeenote.feature.coffee_been.list.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.edc.coffeenote.core.model.CoffeeBeenInfo
import com.edc.coffeenote.feature.coffee_been.list.component.CoffeeBeenListItem
import com.edc.coffeenote.feature.coffee_been.list.component.CoffeeBeenListTopBar
import kotlinx.collections.immutable.PersistentList

@Composable
fun CoffeeBeenListScreen(
    coffeeBeenList: PersistentList<CoffeeBeenInfo>,
    onCoffeeBeenClick: (CoffeeBeenInfo) -> Unit,
    onAddCoffeeBeenClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0),
        topBar = {
            CoffeeBeenListTopBar(
                modifier = Modifier.fillMaxWidth(),
                onAddButtonClick = onAddCoffeeBeenClick
            )
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(
                items = coffeeBeenList,
                key = { it.id }
            ) {
                CoffeeBeenListItem(
                    beenName = it.beenName,
                    roastery = it.roastery ?: "",
                    notes = it.flavorNotes,
                    roastingPoint = it.roastingPoint,
                    roastingDate = it.roastingDate,
                    onClick = { onCoffeeBeenClick(it) }
                )
            }
        }
    }

}