package deepak.opensource.com.daggerkotlin.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created by Ajay Deepak on 16-06-2019.
 */

val MIGRATIONS1_2 = object: Migration(1,2){

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE addresses ADD COLUMN code INTEGER")
    }
}