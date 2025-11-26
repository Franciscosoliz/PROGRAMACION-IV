package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Definición de colores temáticos para el taller
val WorkshopBlue = Color(0xFF1E88E5) // Azul profesional
val StatusAvailable = Color(0xFF4CAF50) // Verde para disponible
val StatusOccupied = Color(0xFFD32F2F) // Rojo para ocupado

class MainWorkshopStatus : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WorkshopStatusApp() }
    }
}

@Composable
fun WorkshopStatusApp() {
    MaterialTheme(colorScheme = lightColorScheme(primary = WorkshopBlue)) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            ServiceBayStatusScreen()
        }
    }
}

@Composable
fun ServiceBayStatusScreen() {
    // El estado representa si la bahía de servicio rápido está ocupada (true) o libre (false)
    var isBayOccupied by remember { mutableStateOf(false) }

    // Determinar la información visual basada en el estado
    val statusText = if (isBayOccupied) "OCUPADO 🛠️" else "DISPONIBLE ✅"
    val statusColor = if (isBayOccupied) StatusOccupied else StatusAvailable
    val buttonText = if (isBayOccupied) "Finalizar Servicio" else "Iniciar Nuevo Servicio"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Gestión de Bahía Rápida",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = WorkshopBlue
        )

        // Tarjeta de estado visual
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = statusColor.copy(alpha = 0.9f)),
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Bahía de Servicio 1",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = statusText,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            }
        }

        // Botón de acción para cambiar el estado
        Button(
            onClick = { isBayOccupied = !isBayOccupied },
            colors = ButtonDefaults.buttonColors(
                containerColor = WorkshopBlue,
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(56.dp)
        ) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WorkshopStatusPreview() {
    WorkshopStatusApp()
}