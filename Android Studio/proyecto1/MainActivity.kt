package com.example.proyecto1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto1.ui.theme.Proyecto1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Proyecto1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    activity1(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun IesComercio(modifier : Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        //texto IES Comercio
        Text(
            text = "IES COMERCIO",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        //imagen pequeña: ieclogo.png
        Image(
            painter = painterResource(id = R.drawable.ieclogo),
            contentDescription = "Logo IES Comercio",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun activity1(modifier : Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //texto TITULO PRINCIPAL
        Text(
            text = "TITULO PRINCIPAL",
            fontSize = 32.sp,
            fontWeight = FontWeight.Light,
            color = Color.Blue,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        //TextField "escriba aqui"
        input(modifier)

    }
}

@Composable
fun input(modifier : Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Escriba aqui") },
       singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Proyecto1Theme {
        activity1()
    }
}