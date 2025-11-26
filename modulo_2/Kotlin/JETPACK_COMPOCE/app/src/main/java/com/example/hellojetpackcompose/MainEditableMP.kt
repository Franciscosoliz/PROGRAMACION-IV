package com.example.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Nueva estructura de datos para una Tarea de Servicio (Orden de Trabajo)
data class ServiceTask(val taskId: Int, val description: String, val priority: String)

class MainTaskBoard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WorkshopTaskBoardApp() }
    }
}

@Composable
fun WorkshopTaskBoardApp() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) { TaskBoardScreen() }
    }
}

@Composable
fun TaskBoardScreen() {
    // Estado de la lista de tareas
    var nextTaskId by rememberSaveable { mutableStateOf(4) }
    val tasks = remember {
        mutableStateListOf(
            ServiceTask(1, "Cambio de aceite y filtro", "Alta"),
            ServiceTask(2, "Rotación y balanceo de ruedas", "Media"),
            ServiceTask(3, "Diagnóstico eléctrico (Falla luz)", "Baja")
        )
    }

    // Estado de los campos del nuevo formulario de tarea
    var taskDescription by rememberSaveable { mutableStateOf("") }
    var selectedPriority by rememberSaveable { mutableStateOf("Baja") } // Valor inicial de prioridad
    var isDropdownExpanded by remember { mutableStateOf(false) }

    // Estado para ver el detalle de la tarea seleccionada
    var selectedTask by remember { mutableStateOf<ServiceTask?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Build, contentDescription = "Herramienta", tint = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.width(8.dp))
            Text("Gestión de Órdenes de Servicio", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        }

        // --- Formulario agregar ---
        OutlinedTextField(
            value = taskDescription,
            onValueChange = { taskDescription = it },
            label = { Text("Descripción del Servicio") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Dropdown para Prioridad (Diferenciación con el código anterior)
            Box {
                OutlinedButton(onClick = { isDropdownExpanded = true }) {
                    Text("Prioridad: $selectedPriority")
                }
                DropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false }
                ) {
                    listOf("Alta", "Media", "Baja").forEach { priority ->
                        DropdownMenuItem(
                            text = { Text(priority) },
                            onClick = {
                                selectedPriority = priority
                                isDropdownExpanded = false
                            }
                        )
                    }
                }
            }

            // Botones de acción
            Row(horizontalArrangement = Arrangement.End) {
                TextButton(onClick = { taskDescription = ""; selectedPriority = "Baja" }) { Text("Limpiar") }
                Spacer(Modifier.width(8.dp))
                Button(
                    onClick = {
                        val desc = taskDescription.trim()
                        if (desc.isNotEmpty()) {
                            nextTaskId += 1
                            tasks.add(ServiceTask(nextTaskId, desc, selectedPriority))
                            taskDescription = ""; selectedPriority = "Baja"; selectedTask = null
                        }
                    },
                    enabled = taskDescription.isNotBlank()
                ) { Text("Añadir Tarea") }
            }
        }

        Divider()

        // --- Lista de Tareas (LazyColumn) ---
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks, key = { it.taskId }) { task ->
                val color = when (task.priority) {
                    "Alta" -> Color(0xFFFFCCBC) // Rojo claro
                    "Media" -> Color(0xFFFFECB3) // Amarillo claro
                    else -> Color(0xFFE0F7FA) // Azul claro
                }

                Card(
                    Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = color)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selectedTask = task }
                        ) {
                            Text(
                                text = "ID #${task.taskId}",
                                style = MaterialTheme.typography.labelSmall
                            )
                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Prioridad: ${task.priority}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                        TextButton(onClick = {
                            tasks.removeIf { it.taskId == task.taskId }
                            if (selectedTask?.taskId == task.taskId) selectedTask = null
                        }) { Text("Completar") } // Cambiado de "Eliminar" a "Completar"
                    }
                }
            }
        }

        // --- Detalle seleccionado ---
        if (selectedTask != null) {
            Card(
                Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Detalle de la Orden:", style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    Text("ID de Tarea: ${selectedTask!!.taskId}")
                    Text("Descripción: ${selectedTask!!.description}")
                    Text("Prioridad Asignada: ${selectedTask!!.priority}", fontWeight = FontWeight.Bold)
                }
            }
        } else {
            Text("Selecciona una tarea para ver el detalle de la Orden.")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTaskBoard() { TaskBoardScreen() }