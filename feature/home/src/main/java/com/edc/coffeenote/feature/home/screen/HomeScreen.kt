package com.edc.coffeenote.feature.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.edc.coffeenote.core.model.CoffeeNote
import com.edc.coffeenote.feature.home.component.CoffeeNoteCardItem
import com.edc.coffeenote.feature.home.component.HomeTopBar
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    coffeeNoteList: PersistentList<CoffeeNote>,
    onCoffeeNoteClick: (CoffeeNote) -> Unit,
    onAddCoffeeClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            HomeTopBar(
                modifier = Modifier.fillMaxWidth(),
                onAddButtonClick = onAddCoffeeClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(
                    items = coffeeNoteList,
                    key = { it.id }
                ) {
                    CoffeeNoteCardItem(
                        modifier = Modifier.fillMaxWidth(),
                        beenName = it.coffeeBeenInfo.beenName,
                        roastery = it.coffeeBeenInfo.roastery ?: "",
                        notes = it.coffeeBeenInfo.flavorNotes,
                        pouringAmountList = persistentListOf(),
                        createDate = it.date.toString(),
                        onClick = { onCoffeeNoteClick(it) },
                    )
                }
            }
        }
    }
}