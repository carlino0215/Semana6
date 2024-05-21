package com.xcheko51x.crud_room_compose_kotlin.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.xcheko51x.crud_room_compose_kotlin.models.Usuarios
import com.xcheko51x.crud_room_compose_kotlin.viewmodels.UsuariosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView(navController: NavController, viewModel: UsuariosViewModel,
               id: Int, rut: String?, nombreApellido: String?, fechaIngreso: String?, fechaSalida: String?, horaIngreso: String?, horaSalida: String?, deptoCasa: String?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Editar View", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                }
            )
        }
    ) {
        ContentEditarView(it, navController, viewModel, id, rut, nombreApellido, fechaIngreso, fechaSalida, horaIngreso, horaSalida, deptoCasa)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentEditarView(it: PaddingValues, navController: NavController, viewModel: UsuariosViewModel, id: Int, rut: String?, nombreApellido: String?, fechaIngreso: String?, fechaSalida: String?, horaIngreso: String?, horaSalida: String?, deptoCasa: String?) {
    var rut by remember { mutableStateOf(rut) }
    var nombreApellido by remember { mutableStateOf(nombreApellido) }
    var fechaIngreso by remember { mutableStateOf(fechaIngreso) }
    var fechaSalida by remember { mutableStateOf(fechaSalida) }
    var horaIngreso by remember { mutableStateOf(horaIngreso) }
    var horaSalida by remember { mutableStateOf(horaSalida) }
    var deptoCasa by remember { mutableStateOf(deptoCasa) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = rut ?: "",
            onValueChange = { rut = it },
            label = { Text(text = "rut") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = nombreApellido ?: "",
            onValueChange = { nombreApellido = it },
            label = { Text(text = "nombreApellido") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = fechaIngreso ?: "",
            onValueChange = { fechaIngreso = it },
            label = { Text(text = "fechaIngreso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = fechaSalida ?: "",
            onValueChange = { fechaSalida = it },
            label = { Text(text = "fechaSalida") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = horaIngreso ?: "",
            onValueChange = { horaIngreso = it },
            label = { Text(text = "horaIngreso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = horaSalida ?: "",
            onValueChange = { horaSalida = it },
            label = { Text(text = "horaSalida") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = deptoCasa ?: "",
            onValueChange = { deptoCasa = it },
            label = { Text(text = "deptoCasa") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        Button(
            onClick = {
                val usuario = Usuarios(id = id, rut = rut!!, nombreApellido = nombreApellido!!, fechaIngreso = fechaIngreso!!, fechaSalida = fechaSalida!!, horaIngreso = horaIngreso!!, horaSalida = horaSalida!!, deptoCasa = deptoCasa!!)

                viewModel.actualizarUsuario(usuario)
                navController.popBackStack()
            }
        ) {
            Text(text = "Editar")
        }
    }
}