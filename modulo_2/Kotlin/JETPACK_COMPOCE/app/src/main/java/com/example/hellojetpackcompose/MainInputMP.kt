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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Nueva estructura de datos para una Tarea de Servicio (Orden de Trabajo)
// RENOMBRADA a WorkOrder para evitar conflicto con MainEditableMP.kt
data class WorkOrder(val taskId: Int, val description: String, val priority: String)

class MainTaskBoardSimple : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { WorkshopTaskBoardAppSimple() }
    }
}

@Composable
fun WorkshopTaskBoardAppSimple() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) { TaskBoardScreenSimple() }
    }
}

@Composable
fun TaskBoardScreenSimple() {
    // Estado de la lista de tareas
    var nextTaskId by rememberSaveable { mutableStateOf(4) }
    // Usamos WorkOrder en lugar de ServiceTask
    val tasks = remember {
        mutableStateListOf(
            WorkOrder(1, "Cambio de aceite y filtro", "Alta"),
            WorkOrder(2, "Rotación y balanceo", "Media"),
            WorkOrder(3, "Diagnóstico eléctrico", "Baja")
        )
    }

    // Estado de los campos del nuevo formulario de tarea
    var taskDescription by rememberSaveable { mutableStateOf("") }
    var priorityInput by rememberSaveable { mutableStateOf("") }

    // Estado para ver el detalle de la tarea seleccionada
    var selectedTask by remember { mutableStateOf<WorkOrder?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Gestión de Órdenes de Servicio", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

        // --- Formulario agregar ---
        OutlinedTextField(
            value = taskDescription,
            onValueChange = { taskDescription = it },
            label = { Text("Descripción del Servicio") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // Campo de Prioridad Simple
        OutlinedTextField(
            value = priorityInput,
            onValueChange = { priorityInput = it },
            label = { Text("Prioridad (Alta/Media/Baja)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { taskDescription = ""; priorityInput = "" }) { Text("Limpiar") }
            Spacer(Modifier.width(8.dp))

            // Botón para Añadir Tarea
            Button(
                onClick = {
                    val desc = taskDescription.trim()
                    val prio = priorityInput.trim()
                    if (desc.isNotEmpty() && prio.isNotEmpty()) {
                        nextTaskId += 1
                        // Añadimos WorkOrder
                        tasks.add(WorkOrder(nextTaskId, desc, prio))
                        taskDescription = ""; priorityInput = ""; selectedTask = null
                    }
                },
                enabled = taskDescription.isNotBlank() && priorityInput.isNotBlank()
            ) { Text("Añadir Tarea") }
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
                Card(
                    Modifier.fillMaxWidth(),
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
                        }) { Text("Completar") }
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
private fun PreviewTaskBoardSimple() { WorkshopTaskBoardAppSimple() }