package com.edc.coffeenote.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edc.coffeenote.core.designsystem.theme.CoffeeNoteTheme
import com.edc.coffeenote.core.designsystem.theme.Gray500
import com.edc.coffeenote.core.designsystem.theme.LocalTypography
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun CoffeeNoteCardItem(
    modifier: Modifier = Modifier,
    beenName: String,
    roastery: String,
    notes: PersistentList<String>,
    pouringAmountList: PersistentList<Int>,
    createDate: String,
    onClick: () -> Unit
) {
    val typography = LocalTypography.current
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        onClick = onClick
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
            ) {
                Text(
                    text = beenName,
                    style = typography.b20
                )

                Text(
                    text = roastery,
                    style = typography.m14,
                    color = Gray500
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "레시피",
                        style = typography.m14
                    )
                    pouringAmountList.forEach { amount ->
                        Text(
                            text = amount.toString(),
                            style = typography.m14
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    notes.forEach { note ->
                        Text(
                            text = note,
                            style = typography.b10
                        )
                    }
                }



                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = createDate,
                    style = typography.m12
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun CoffeeNoteCardItemPreview() {
    CoffeeNoteTheme {
        CoffeeNoteCardItem(
            modifier = Modifier.fillMaxWidth(0.5f),
            beenName = "kitch",
            roastery = "아이텐티티 커피랩",
            notes = persistentListOf("카카오", "꿀", "바닐라"),
            createDate = "2023.01.01",
            pouringAmountList = persistentListOf(80, 60, 60),
            onClick = {}
        )
    }
}