package com.alphaomardiallo.a100_days_of_code.common.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.alphaomardiallo.a100_days_of_code.common.data.local.dao.ChallengeDao
import com.alphaomardiallo.a100_days_of_code.common.data.local.dao.UserDao
import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.ChallengeEntity
import com.alphaomardiallo.a100_days_of_code.common.data.model.Entry
import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.UserEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [(ChallengeEntity::class), (UserEntity::class)],
    version = 1,
    exportSchema = true
)
@TypeConverters(EntryListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun provideChallengeDao(): ChallengeDao
    abstract fun provideUserDao(): UserDao
}

fun provideAppDatabase(application: Application): AppDatabase =
    Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "app_database"
    ).fallbackToDestructiveMigration().build()

fun provideChallengeDao(appDatabase: AppDatabase) = appDatabase.provideChallengeDao()
fun provideUserDao(appDatabase: AppDatabase) = appDatabase.provideUserDao()

// Converter
class EntryListConverter {
    @TypeConverter
    fun fromEntryList(entries: List<Entry>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Entry>>() {}.type
        return gson.toJson(entries, type)
    }

    @TypeConverter
    fun toEntryList(entryString: String): List<Entry> {
        val gson = Gson()
        val type = object : TypeToken<List<Entry>>() {}.type
        return gson.fromJson(entryString, type)
    }
}
