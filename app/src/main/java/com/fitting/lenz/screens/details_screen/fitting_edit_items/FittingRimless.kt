package com.fitting.lenz.screens.details_screen.fitting_edit_items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fitting.lenz.LenzViewModel
import com.fitting.lenz.models.ColorSchemeModel

@Composable
fun FittingRimless(
    colorScheme: ColorSchemeModel,
    lenzViewModel: LenzViewModel
) {
    var fittingRimlessNormal_LS by lenzViewModel::fittingRimlessNormal_LS
    var fittingRimlessNormal_LD by lenzViewModel::fittingRimlessNormal_LD
    var fittingRimlessNormal_HS by lenzViewModel::fittingRimlessNormal_HS
    var fittingRimlessNormal_HD by lenzViewModel::fittingRimlessNormal_HD
    var fittingRimlessPR_LS by lenzViewModel::fittingRimlessPR_LS
    var fittingRimlessPR_LD by lenzViewModel::fittingRimlessPR_LD
    var fittingRimlessPR_HS by lenzViewModel::fittingRimlessPR_HS
    var fittingRimlessPR_HD by lenzViewModel::fittingRimlessPR_HD
    var fittingRimlessSunglass_LS by lenzViewModel::fittingRimlessSunglass_LS
    var fittingRimlessSunglass_LD by lenzViewModel::fittingRimlessSunglass_LD
    var fittingRimlessSunglass_HS by lenzViewModel::fittingRimlessSunglass_HS
    var fittingRimlessSunglass_HD by lenzViewModel::fittingRimlessSunglass_HD
    var fittingRimlessPoly_LS by lenzViewModel::fittingRimlessPoly_LS
    var fittingRimlessPoly_LD by lenzViewModel::fittingRimlessPoly_LD
    var fittingRimlessPoly_HS by lenzViewModel::fittingRimlessPoly_HS
    var fittingRimlessPoly_HD by lenzViewModel::fittingRimlessPoly_HD
    var fittingRimlessPolyPR_LS by lenzViewModel::fittingRimlessPolyPR_LS
    var fittingRimlessPolyPR_LD by lenzViewModel::fittingRimlessPolyPR_LD
    var fittingRimlessPolyPR_HS by lenzViewModel::fittingRimlessPolyPR_HS
    var fittingRimlessPolyPR_HD by lenzViewModel::fittingRimlessPolyPR_HD

    Text(
        text = "Rimless - Normal",
        color = colorScheme.compColor,
        fontSize = 24.sp
    )
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessNormal_LS,
                onValueChange = { fittingRimlessNormal_LS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessNormal_LD,
                onValueChange = { fittingRimlessNormal_LD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessNormal_HS,
                onValueChange = { fittingRimlessNormal_HS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessNormal_HD,
                onValueChange = { fittingRimlessNormal_HD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(top = 24.dp),
        color = colorScheme.compColor
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Rimless - PR",
        color = colorScheme.compColor,
        fontSize = 24.sp
    )
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPR_LS,
                onValueChange = { fittingRimlessPR_LS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPR_LD,
                onValueChange = { fittingRimlessPR_LD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPR_HS,
                onValueChange = { fittingRimlessPR_HS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPR_HD,
                onValueChange = { fittingRimlessPR_HD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(top = 24.dp),
        color = colorScheme.compColor
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Rimless - Sunglass",
        color = colorScheme.compColor,
        fontSize = 24.sp
    )
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessSunglass_LS,
                onValueChange = { fittingRimlessSunglass_LS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessSunglass_LD,
                onValueChange = { fittingRimlessSunglass_LD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessSunglass_HS,
                onValueChange = { fittingRimlessSunglass_HS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessSunglass_HD,
                onValueChange = { fittingRimlessSunglass_HD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(top = 24.dp),
        color = colorScheme.compColor
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Rimless - Poly",
        color = colorScheme.compColor,
        fontSize = 24.sp
    )
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPoly_LS,
                onValueChange = { fittingRimlessPoly_LS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPoly_LD,
                onValueChange = { fittingRimlessPoly_LD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPoly_HS,
                onValueChange = { fittingRimlessPoly_HS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPoly_HD,
                onValueChange = { fittingRimlessPoly_HD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(top = 24.dp),
        color = colorScheme.compColor
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Rimless - PolyPR",
        color = colorScheme.compColor,
        fontSize = 24.sp
    )
    Spacer(modifier = Modifier.height(12.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPolyPR_LS,
                onValueChange = { fittingRimlessPolyPR_LS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Low > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPolyPR_LD,
                onValueChange = { fittingRimlessPolyPR_LD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Single",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPolyPR_HS,
                onValueChange = { fittingRimlessPolyPR_HS = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .background(colorScheme.bgColor)
                .padding(start = 5.dp, top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "High > Double",
                color = colorScheme.compColor,
                fontSize = 22.sp
            )
        }
        Column(Modifier.weight(1f)) {
            OutlinedTextField(
                value = fittingRimlessPolyPR_HD,
                onValueChange = { fittingRimlessPolyPR_HD = it },
                placeholder = {
                    Text(
                        text = "Enter New Price",
                        fontSize = 12.sp
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 4.dp)
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(top = 24.dp),
        color = colorScheme.compColor
    )
    Spacer(modifier = Modifier.height(8.dp))
}