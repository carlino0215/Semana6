package com.xcheko51x.crud_room_compose_kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.xcheko51x.crud_room_compose_kotlin.viewmodels.UsuariosViewModel
import com.xcheko51x.crud_room_compose_kotlin.views.AgregarView
import com.xcheko51x.crud_room_compose_kotlin.views.EditarView
import com.xcheko51x.crud_room_compose_kotlin.views.InicioView

@Composable
fun NavManager(viewModel: UsuariosViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{rut}/{nombreApellido}/{fechaIngreso}/{fechaSalida}/{horaIngreso}/{horaSalida}/{deptoCasa}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("rut") { type = NavType.StringType },
            navArgument("nombreApellido") { type = NavType.StringType },
            navArgument("fechaIngreso") { type = NavType.StringType },
            navArgument("fechaSalida") { type = NavType.StringType },
            navArgument("horaIngreso") { type = NavType.StringType },
            navArgument("horaSalida") { type = NavType.StringType },
            navArgument("deptoCasa") { type = NavType.StringType }
        )) {
            EditarView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("rut"),
                it.arguments?.getString("nombreApellido"),
                it.arguments?.getString("fechaIngreso"),
                it.arguments?.getString("fechaSalida"),
                it.arguments?.getString("horaIngreso"),
                it.arguments?.getString("horaSalida"),
                it.arguments?.getString("deptoCasa")
            )
        }
    }

}