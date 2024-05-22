package com.example.jetspend2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetspend2.ui.theme.Jetspend2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetspend2Theme {
                    menedzerwydatkow()

            }
        }
    }
}

@Composable
fun menedzerwydatkow(){
    val wydatki = remember {
        mutableStateOf("")
    }
    
    Column {
        OutlinedTextField(value = wydatki.value, onValueChange = {wydatki.value = it}, label = { Text(
            text = "Wprowadź wydatek"
        )})
        Button(onClick = { /*TODO*/ }) {
           Text(text = "Dodaj wydatek") 
        }
    }
}

@Preview(showBackground = true)
@Composable
fun menedzerwydatkowPreview() {
    Jetspend2Theme {
        menedzerwydatkow()
    }
}