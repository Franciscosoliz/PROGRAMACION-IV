package com.example.hellojetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Nueva estructura de datos simple para un vehículo de cliente
data class CustomerVehicle(val licensePlate: String, val customerName: String, val makeAndModel: String)

class MainCustomerVehicles : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { VehicleListApp() }
    }
}

@Composable
fun VehicleListApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            VehicleListScreen()
        }
    }
}

@Composable
fun VehicleListScreen() {
    // Lista de vehículos en el taller
    val vehicles = remember {
        listOf(
            CustomerVehicle("PQT-789", "Ricardo Soto", "Toyota Hilux 2018"),
            CustomerVehicle("ABC-123", "Elena Vargas", "Honda Civic 2022"),
            CustomerVehicle("XY-001", "Javier López", "Ford F-150 2015"),
            CustomerVehicle("GTH-456", "Marta Gómez", "Chevrolet Spark 2020")
        )
    }

    // Estado del vehículo seleccionado
    var selectedVehicle by remember { mutableStateOf<CustomerVehicle?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Inventario de Vehículos en Espera",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        // --- Lista de Vehículos ---
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(vehicles, key = { it.licensePlate }) { vehicle ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedVehicle = vehicle }
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(
                            text = vehicle.licensePlate,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Dueño: ${vehicle.customerName}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Modelo: ${vehicle.makeAndModel}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

        Divider()

        // --- Detalle del Vehículo Seleccionado ---
        if (selectedVehicle != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Detalles del Cliente:", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.height(4.dp))
                    Text("Placa: ${selectedVehicle!!.licensePlate}", fontWeight = FontWeight.Bold)
                    Text("Cliente: ${selectedVehicle!!.customerName}")
                    Text("Vehículo: ${selectedVehicle!!.makeAndModel}")
                }
            }
        } else {
            Text("Selecciona un vehículo para ver los detalles del cliente.")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewVehicleList() { VehicleListApp() }