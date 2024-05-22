package com.example.jetspend2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val wydatek = remember {
        mutableStateOf("")
    }
    val wydatki = remember { mutableStateListOf<String>()}
    
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = wydatek.value, onValueChange = {wydatek.value = it}, label = { Text(
            text = "Wprowadź wydatek"
        )})
        Button(onClick = { 
        if (wydatek.value.isNotEmpty()){
            wydatki.add(wydatek.value)
            wydatek.value = ""
        }
        }) {
           Text(text = "Dodaj wydatek") 
        }
        LazyColumn {
            items(wydatki) { wydatek -> Text(text = wydatek, modifier = Modifier.fillMaxWidth().padding(4.dp))
            }
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