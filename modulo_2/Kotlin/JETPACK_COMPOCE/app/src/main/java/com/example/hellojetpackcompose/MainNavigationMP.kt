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
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

// Estructura de datos para la asignación de una tarea
data class TaskAssignment(val taskId: Int, val technician: String, val vehiclePlate: String)

class MainWorkshopNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WorkshopNavApp() }
    }
}

@Composable
fun WorkshopNavApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            val nav = rememberNavController()
            // Pantalla inicial: Lista de asignaciones
            NavHost(navController = nav, startDestination = "assignmentList") {

                // Pantalla lista (Home)
                composable("assignmentList") {
                    AssignmentListScreen(
                        onOpenDetail = { taskId, technician ->
                            // Navegación simple de String/Int, SIN URL encoding
                            nav.navigate("taskDetail/$taskId/$technician")
                        }
                    )
                }

                // Pantalla detalle con argumentos tipados
                composable(
                    route = "taskDetail/{taskId}/{technicianName}",
                    arguments = listOf(
                        navArgument("taskId") { type = NavType.IntType },
                        navArgument("technicianName") { type = NavType.StringType }
                    )
                ) { backStack ->
                    val taskId = backStack.arguments?.getInt("taskId") ?: -1
                    val technician = backStack.arguments?.getString("technicianName") ?: ""
                    TaskDetailScreen(
                        taskId = taskId,
                        technician = technician,
                        onBack = { nav.popBackStack() }
                    )
                }
            }
        }
    }
}

@Composable
fun AssignmentListScreen(onOpenDetail: (Int, String) -> Unit) {
    // Datos de tareas y técnicos asignados
    val assignments = remember {
        listOf(
            TaskAssignment(101, "Carlos R.", "PQT-789"),
            TaskAssignment(102, "Luisa M.", "ABC-123"),
            TaskAssignment(103, "Carlos R.", "GTH-456"),
            TaskAssignment(104, "Pedro S.", "XY-001")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Asignaciones Pendientes", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(assignments, key = { it.taskId }) { assignment ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOpenDetail(assignment.taskId, assignment.technician) }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Tarea #${assignment.taskId}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                            Text("Técnico Asignado: ${assignment.technician}", style = MaterialTheme.typography.bodyMedium)
                            Text("Placa: ${assignment.vehiclePlate}", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TaskDetailScreen(taskId: Int, technician: String, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Detalle de la Tarea", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Orden de Servicio (ID): $taskId", style = MaterialTheme.typography.titleMedium)
                Text("Técnico Responsable: $technician", style = MaterialTheme.typography.bodyLarge)
                Divider()
                // Contenido de detalle simulado
                Text("Estado: En Progreso", style = MaterialTheme.typography.titleSmall)
                Text("Problema Reportado: Falla en el sistema de frenos trasero.")
                Text("Tiempo Estimado: 4 horas.")
            }
        }
        Button(onClick = onBack) { Text("⬅️ Volver a Asignaciones") }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHome() { MaterialTheme { AssignmentListScreen { _, _ -> } } }

@Preview(showBackground = true)
@Composable
private fun PreviewDetail() { MaterialTheme { TaskDetailScreen(105, "Laura G.", onBack = {}) } }