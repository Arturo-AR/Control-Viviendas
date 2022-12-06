package com.segared.controlviviendas.core.util

import android.content.Context
import android.widget.Toast
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import com.segared.controlviviendas.core.navigation.MainScreens
import com.segared.controlviviendas.usecases.login.data.network.response.LoginObject
import java.io.ByteArrayOutputStream

fun String.getRoute(): String {
    return when (this) {
        "Mis Mascotas" -> MainScreens.MyPetsScreen.route
        "Mis Vehiculos" -> MainScreens.MyVehiclesScreen.route
        "Anuncios" -> MainScreens.AdvertisementsScreen.route
        "Control de acceso" -> MainScreens.AccessControlScreen.route
        "Escanear QR" -> MainScreens.ScanQrScreen.route
        "Subir Quejas" -> MainScreens.ComplaintsScreen.route
        "Reservaciones" -> MainScreens.CommonAreasScreen.route
        "Administración de usuarios",
        "Comprobantes",
        "Generar código QR",
        "Subir comprobantes",
        "Visitas temporales ",
        "Registro mantenimiento",
        "Generar adeudos",
        "Validar usuarios",
        "Mis Adeudos" -> ""
        else -> ""
    }
}

fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun String.toBitmap(): Bitmap {
    val newString = this.replace("data:image/png;base64,", "")
    val imageBytes = Base64.decode(newString, 0)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}

fun Bitmap.toBase64String(): String {
    val bas = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, 100, bas)
    val b = bas.toByteArray()
    return "data:image/png;base64," + Base64.encodeToString(b, Base64.DEFAULT)
}
