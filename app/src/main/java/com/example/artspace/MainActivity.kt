package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtDisplay(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtDisplay(modifier: Modifier = Modifier) {
    var btnClickCount by remember { mutableStateOf(1) }
    if(btnClickCount== 0){
        btnClickCount = 21
    }
    if(btnClickCount==22){
        btnClickCount = 1
    }
    val artPiece = when (btnClickCount){
        1,0 -> R.drawable.ai_art1
        2 -> R.drawable.ai_art2
        3 -> R.drawable.ai_art3
        4 -> R.drawable.ai_art4
        5 -> R.drawable.ai_art5
        6 -> R.drawable.ai_art6
        7 -> R.drawable.ai_art7
        8 -> R.drawable.ai_art8
        9 -> R.drawable.ai_art9
        10 -> R.drawable.ai_art10
        11 -> R.drawable.ai_art11
        12 -> R.drawable.ai_art12
        13 -> R.drawable.ai_art13
        14 -> R.drawable.ai_art14
        15 -> R.drawable.ai_art15
        16 -> R.drawable.ai_art16
        17 -> R.drawable.ai_art17
        18 -> R.drawable.ai_art18
        19 -> R.drawable.ai_art19
        20 -> R.drawable.ai_art20
        else -> R.drawable.ai_art21
    }
    val artArtist = when (btnClickCount){
        1,0 -> R.string.ai_art1_artist
        2 -> R.string.ai_art2_artist
        3 -> R.string.ai_art3_artist
        4 -> R.string.ai_art1_artist
        5 -> R.string.ai_art2_artist
        6 -> R.string.ai_art3_artist
        7 -> R.string.ai_art1_artist
        8 -> R.string.ai_art2_artist
        9 -> R.string.ai_art3_artist
        10 -> R.string.ai_art1_artist
        11 -> R.string.ai_art2_artist
        12 -> R.string.ai_art3_artist
        13 -> R.string.ai_art1_artist
        14 -> R.string.ai_art2_artist
        15 -> R.string.ai_art3_artist
        16 -> R.string.ai_art1_artist
        17 -> R.string.ai_art2_artist
        18 -> R.string.ai_art3_artist
        19 -> R.string.ai_art1_artist
        20 -> R.string.ai_art2_artist
        else -> R.string.ai_art3_artist
    }
    val artTitle= when (btnClickCount){
        1,0 -> R.string.ai_art1_title
        2 -> R.string.ai_art2_title
        3 -> R.string.ai_art3_title
        4 -> R.string.ai_art4_title
        5 -> R.string.ai_art5_title
        6 -> R.string.ai_art6_title
        7 -> R.string.ai_art7_title
        8 -> R.string.ai_art8_title
        9 -> R.string.ai_art9_title
        10 -> R.string.ai_art10_title
        11 -> R.string.ai_art11_title
        12 -> R.string.ai_art12_title
        13 -> R.string.ai_art13_title
        14 -> R.string.ai_art14_title
        15 -> R.string.ai_art15_title
        16 -> R.string.ai_art16_title
        17 -> R.string.ai_art17_title
        18 -> R.string.ai_art18_title
        19 -> R.string.ai_art19_title
        20 -> R.string.ai_art20_title
        else -> R.string.ai_art21_title
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.art_bg))
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = artPiece),
                contentDescription = stringResource(id = artTitle) + stringResource(id = artArtist),
                modifier = Modifier
                    .size(300.dp)
                    .padding(16.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .padding(start = 8.dp, top = 16.dp, bottom = 16.dp)
                .align(AbsoluteAlignment.Left)
        ) {
            Text(
                text = stringResource(artTitle),
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(artArtist),
                textAlign = TextAlign.Left
            )
        }
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        Row {
        changeButton(btnLabel = R.string.previous, onClick = { btnClickCount-- })
        changeButton(btnLabel = R.string.next, onClick = { btnClickCount++ })
    }

    }
}

@Composable
fun changeButton(
    modifier:Modifier = Modifier,
    @StringRes btnLabel : Int,
    onClick : () -> Unit
){
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(16.dp)
            .size(128.dp, 32.dp)
    ){
        Text(
            text = stringResource(btnLabel),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtDisplay()
    }
}