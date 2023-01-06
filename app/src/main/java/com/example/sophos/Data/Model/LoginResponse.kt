package com.example.sophos.Data.Model

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("id") var id : String,
    @SerializedName("nombre") var uname : String,
    @SerializedName("apellido") var ulastname : String,
    @SerializedName("acceso") var uaccess : Boolean,
    @SerializedName("admin") var uadmin : Boolean
)
