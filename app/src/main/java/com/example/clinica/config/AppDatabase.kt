package com.example.clinica.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clinica.dao.CitasDao
import com.example.clinica.dao.DoctoresDao
import com.example.clinica.models.CitaModel
import com.example.clinica.models.DoctorModel

    @Database(entities=[CitaModel::class,DoctorModel::class], version=1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun citas(): CitasDao
        abstract fun doctores(): DoctoresDao

        companion object {
            @Volatile
            private var INSTANCE: AppDatabase? = null

            fun getDatabase(context: Context): AppDatabase {
                var tempInstance = INSTANCE

                if (tempInstance != null) return  tempInstance

                synchronized(this) {
                    var instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).allowMainThreadQueries().build()

                    INSTANCE = instance

                    return instance
                }
            }
        }
}