package com.example.yinyangabout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Preview
@Composable
private fun AboutScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()

            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xff8ecae6),
                        Color(0xff219ebc),
                    )
                )
            )
            .padding(16.dp)
    ) {
        LazyColumn(

        ) {

            item {
                TopBar()
                HorizontalDivider(thickness = 2.dp, color = Color.Black)
            }
            item {
                Spacer(
                    modifier = Modifier
                        .padding(top = 14.dp)
                )
                TextExpended()
            }
            item {
                YinYangImage()
            }
            item {
                Spacer(modifier = Modifier.padding(top = 14.dp))
                AboutImage()
            }
            item {
                Definition()
            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically


    ) {
        Text(
            text = "Yin Yang",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .weight(1f)
        )
        Image(
            imageVector = Icons.Outlined.Search,
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
        )
        Image(
            imageVector = Icons.Outlined.ShoppingCart,
            contentDescription = null,
            modifier = Modifier
                .size(35.dp)
        )
    }
}

@Composable
fun TextExpended(modifier: Modifier = Modifier) {
    var isExpended by remember { mutableStateOf(false) }

    Text(
        text = "Yin is passive and contractive, while yang is active and expansive",
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        maxLines = if (isExpended) Int.MAX_VALUE else 2,
        overflow = if (isExpended) TextOverflow.Clip else TextOverflow.Ellipsis,
        modifier = Modifier
            .clickable { isExpended = !isExpended }
    )
}

@Composable
fun YinYangImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.yinyang),
        contentDescription = null,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .size(430.dp)
    )
}

@Composable
fun AboutImage(modifier: Modifier = Modifier) {
    var isExpended by remember { mutableStateOf(false) }
    Text(
        text = "About Yin Yang...",
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold
    )
    Spacer(modifier = Modifier.padding(16.dp))
    Text(
        text = "Yin and yang are two complementary forces that are central to Chinese philosophy and cosmology:",
        fontSize = 25.sp,
        modifier = Modifier
            .clickable { isExpended = !isExpended },
        maxLines = if (isExpended) Int.MAX_VALUE else 2,
        overflow = if (isExpended) TextOverflow.Clip else TextOverflow.Ellipsis,
    )
}

@Composable
fun Definition(modifier: Modifier = Modifier) {
    var isExpended by remember { mutableStateOf(false) }
    Text(
        text = "Definition :- ",
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 16.dp, bottom = 10.dp)
    )
    HorizontalDivider(
        thickness = 3.dp, color = Color.Black,
        modifier = Modifier
            .width(107.dp)
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))

    Text(
        text = "Yin and yang are two opposing but interdependent forces that are often depicted in a circle. Yin is passive and contractive, while yang is active and expansive.",
        modifier = Modifier
            .clickable { isExpended = !isExpended },
        maxLines = if (isExpended) Int.MAX_VALUE else 2,
        overflow = if (isExpended) TextOverflow.Clip else TextOverflow.Ellipsis,
        fontSize = 25.sp
    )
}
