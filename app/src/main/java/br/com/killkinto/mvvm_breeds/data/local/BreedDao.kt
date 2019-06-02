package br.com.killkinto.mvvm_breeds.data.local

import android.arch.persistence.room.*
import br.com.killkinto.mvvm_breeds.data.Breed

@Dao
interface BreedDao {

    @Query("SELECT * FROM ".plus("breed"))
    fun getAll(): List<Breed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg  breed: Breed)

    @Delete
    fun delete(breed: Breed)
}