package com.example.smartappwear.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.TransformingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberTransformingLazyColumnState
import androidx.wear.compose.material3.AppScaffold
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ListHeader
import androidx.wear.compose.material3.ScreenScaffold
import androidx.wear.compose.material3.SurfaceTransformation
import androidx.wear.compose.material3.Text
import androidx.wear.compose.material3.lazy.rememberTransformationSpec
import androidx.wear.compose.material3.lazy.transformedHeight
import com.example.smartappwear.presentation.theme.SmartAppWearTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartAppWearApp()
        }
    }
}

@Composable
fun SmartAppWearApp() {
    // Variable para controlar qué pantalla se muestra ("home", "ritmo", "pasos", "config")
    var pantallaActual by remember { mutableStateOf("home") }

    SmartAppWearTheme {
        AppScaffold {
            val listState = rememberTransformingLazyColumnState()
            val transformationSpec = rememberTransformationSpec()

            ScreenScaffold(scrollState = listState) { contentPadding ->
                TransformingLazyColumn(contentPadding = contentPadding, state = listState) {

                    when (pantallaActual) {
                        "home" -> {
                            item {
                                ListHeader(
                                    modifier = Modifier.fillMaxWidth().transformedHeight(this, transformationSpec),
                                    transformation = SurfaceTransformation(transformationSpec),
                                ) {
                                    Text(text = "SmartAppWear")
                                }
                            }
                            item {
                                Button(
                                    onClick = { pantallaActual = "ritmo" },
                                    modifier = Modifier.fillMaxWidth().transformedHeight(this, transformationSpec),
                                    transformation = SurfaceTransformation(transformationSpec),
                                ) {
                                    Text("Medir Ritmo")
                                }
                            }
                            item {
                                Button(
                                    onClick = { pantallaActual = "pasos" },
                                    modifier = Modifier.fillMaxWidth().transformedHeight(this, transformationSpec),
                                    transformation = SurfaceTransformation(transformationSpec),
                                ) {
                                    Text("Ver Pasos")
                                }
                            }
                            item {
                                Button(
                                    onClick = { pantallaActual = "config" },
                                    modifier = Modifier.fillMaxWidth().transformedHeight(this, transformationSpec),
                                    transformation = SurfaceTransformation(transformationSpec),
                                ) {
                                    Text("Configuración")
                                }
                            }
                        }

                        // Vista detallada para Ritmo Cardíaco
                        "ritmo" -> {
                            item {
                                Column(
                                    modifier = Modifier.fillMaxSize().padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(text = "❤️ Ritmo Cardíaco", style = androidx.wear.compose.material3.MaterialTheme.typography.titleMedium)
                                    Text(text = "75 bpm\n(Estable)", textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 8.dp))
                                    Button(onClick = { pantallaActual = "home" }) {
                                        Text("Regresar")
                                    }
                                }
                            }
                        }

                        // Vista detallada para Pasos
                        "pasos" -> {
                            item {
                                Column(
                                    modifier = Modifier.fillMaxSize().padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(text = "👟 Conteo de Pasos", style = androidx.wear.compose.material3.MaterialTheme.typography.titleMedium)
                                    Text(text = "3,420 pasos\nMeta: 5,000", textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 8.dp))
                                    Button(onClick = { pantallaActual = "home" }) {
                                        Text("Regresar")
                                    }
                                }
                            }
                        }

                        // Vista detallada para Configuración
                        "config" -> {
                            item {
                                Column(
                                    modifier = Modifier.fillMaxSize().padding(16.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(text = "⚙️ Configuración", style = androidx.wear.compose.material3.MaterialTheme.typography.titleMedium)
                                    Text(text = "Modo Ahorro: OFF\nVersión: 1.0", textAlign = TextAlign.Center, modifier = Modifier.padding(vertical = 8.dp))
                                    Button(onClick = { pantallaActual = "home" }) {
                                        Text("Regresar")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}