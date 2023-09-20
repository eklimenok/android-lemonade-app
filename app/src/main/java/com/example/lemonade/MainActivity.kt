package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}


val slideImages = mapOf(
    1 to R.drawable.lemon_tree,
    2 to R.drawable.lemon_squeeze,
    3 to R.drawable.lemon_drink,
    4 to R.drawable.lemon_restart,
)

val slideImagesDescription = mapOf(
    1 to R.string.lemon_tree_image_description,
    2 to R.string.lemon_squeeze_image_description,
    3 to R.string.lemon_drink_image_description,
    4 to R.string.lemon_restart_image_description
)

val slideDescription = mapOf(
    1 to R.string.lemon_tree_slide_description,
    2 to R.string.lemon_squeeze_slide_description,
    3 to R.string.lemon_drink_slide_description,
    4 to R.string.lemon_restart_slide_description,
)

const val maxSliderValue = 4
const val firstSliderValue = 1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    var slideNumber by remember { mutableStateOf(firstSliderValue) }
    val setSliderNumber = { slideNumber = if (slideNumber < maxSliderValue) slideNumber + 1 else firstSliderValue }

    Box(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.lemonade),
            modifier = modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            onClick = setSliderNumber,
            color = Color.Green,
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = painterResource(slideImages[slideNumber] as Int),
                contentDescription = stringResource(slideImagesDescription[slideNumber] as Int),
                modifier = modifier.padding(top = 15.dp, bottom = 15.dp, start = 25.dp, end = 25.dp)
            )
        }
        Text(
            text = stringResource(slideDescription[slideNumber] as Int),
            modifier = modifier.padding(16.dp),
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}