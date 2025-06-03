package com.example.firstandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstandroidapp.ui.theme.FirstAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var thing by remember {
                mutableStateOf(" ")
            }
            var things by remember {
                mutableStateOf(listOf<String>())
            }
            FirstAndroidAppTheme {
                Column (modifier = Modifier.padding(top = 100.dp)) {
                    Row (modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(thing, onValueChange = {text -> thing = text}, modifier = Modifier.weight(1f))
                        Spacer(modifier = Modifier.width(16.dp));
                        Button(onClick = {
                            things = things + thing
                            thing = ""
                        }) {
                            Text("Add")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn {
                        items(things) {
                                currentValue -> Text(currentValue, modifier = Modifier.fillMaxWidth().padding(16.dp))
                            HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}

