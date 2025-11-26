package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.PendingActions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Colores específicos para la gestión de vehículos
val WorkshopPrimary = Color(0xFF00796B) // Teal oscuro
val StatusService = Color(0xFFFDD835) // Amarillo para "En Servicio"
val StatusWaiting = Color(0xFF9E9E9E) // Gris para "En Espera"

class MainVehicleEntry : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { VehicleEntryApp() }
    }
}

@Composable
fun VehicleEntryApp() {
    MaterialTheme(colorScheme = lightColorScheme(primary = WorkshopPrimary)) {
        Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            VehicleEntryScreen()
        }
    }
}

@Composable
fun VehicleEntryScreen() {
    // Estado del vehículo
    var licensePlate by rememberSaveable { mutableStateOf("") } // Placa del vehículo
    var isInService by rememberSaveable { mutableStateOf(false) } // true = En Servicio, false = En Espera

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro de Vehículo",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = WorkshopPrimary
        )

        // Entrada de la Placa del vehículo
        OutlinedTextField(
            value = licensePlate,
            onValueChange = { licensePlate = it.uppercase() }, // Convertir a mayúsculas para placas
            label = { Text("Número de Placa") },
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.DirectionsCar, contentDescription = "Car Icon") },
            modifier = Modifier.fillMaxWidth()
        )

        // Switch para definir el estado
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Estado: ${if (isInService) "EN SERVICIO 🛠️" else "EN ESPERA 🕑"}",
                style = MaterialTheme.typography.titleMedium
            )
            Switch(checked = isInService, onCheckedChange = { isInService = it })
        }

        Divider(Modifier.padding(vertical = 10.dp))

        // Tarjeta con la Ficha de Registro del Vehículo
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {

                val statusText = if (isInService) "En Proceso de Reparación" else "A la espera de diagnóstico"
                val statusIcon = if (isInService) Icons.Default.DirectionsCar else Icons.Default.PendingActions
                val statusColor = if (isInService) StatusService else StatusWaiting

                // Encabezado de la Ficha (Icono y Placa)
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    // Icono de estado con color
                    Icon(
                        imageVector = statusIcon,
                        contentDescription = "Status Icon",
                        tint = if (isInService) WorkshopPrimary else Color.Black,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(statusColor)
                            .padding(8.dp)
                    )

                    Column {
                        Text(
                            text = if (licensePlate.isBlank()) "VEHÍCULO SIN PLACA" else "Placa: $licensePlate",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Text(
                            text = statusText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Sección de Acciones
                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    TextButton(onClick = { licensePlate = ""; isInService = false }) { Text("Borrar Datos") }
                    Spacer(Modifier.width(8.dp))
                    Button(
                        onClick = { /* Lógica para enviar o registrar la orden de trabajo */ },
                        enabled = licensePlate.isNotBlank()
                    ) {
                        Text("Generar OT") // OT = Orden de Trabajo
                    }
                }
            }
        }

        Spacer(Modifier.height(30.dp))

        // Pequeño indicador de uso
        Text(
            text = "Use el botón para cambiar entre 'En Espera' y 'En Servicio'.",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewVehicleEntry() {
    VehicleEntryApp()
}