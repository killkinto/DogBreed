package br.com.killkinto.mvvm_breeds.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Breed(@PrimaryKey var uid: Int, @ColumnInfo(name = "name") val name: String)