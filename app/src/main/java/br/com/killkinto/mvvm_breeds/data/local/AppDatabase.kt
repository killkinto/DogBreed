package br.com.killkinto.mvvm_breeds.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.killkinto.mvvm_breeds.data.Breed

@Database(entities = arrayOf(Breed::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
}