package com.oxygenik.notey.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ColorPickerComp(setOfColors: List<Color>, selectedColor: Color, onColorSelected: (Color) -> Unit) {

    LazyRow(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(setOfColors) { clr ->
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .clip(CircleShape)
                    .background(clr)
                    .border(
                        width = if (clr == selectedColor) 3.dp else 0.dp,
                        shape = CircleShape,
                        color = if (clr == selectedColor) Color.White else Color.Transparent
                    )
                    .clickable(
                        onClick = { onColorSelected(clr) }
                    )
            ) {
            }
        }

    }
}