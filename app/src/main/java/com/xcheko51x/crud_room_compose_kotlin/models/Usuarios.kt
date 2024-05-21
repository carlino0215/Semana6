package com.xcheko51x.crud_room_compose_kotlin.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("rut")
    val rut: String,
    @ColumnInfo("nombreApellido")
    val nombreApellido: String,
    @ColumnInfo("fechaIngreso")
    val fechaIngreso: String,
    @ColumnInfo("fechaSalida")
    val fechaSalida: String,
    @ColumnInfo("horaIngreso")
    val horaIngreso: String,
    @ColumnInfo("horaSalida")
    val horaSalida: String,
    @ColumnInfo("deptoCasa")
    val deptoCasa: String
)
