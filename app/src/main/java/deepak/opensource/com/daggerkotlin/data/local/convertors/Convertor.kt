package deepak.opensource.com.daggerkotlin.data.local.convertors

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by Ajay Deepak on 16-06-2019.
 */
class Convertor {

    @TypeConverter
    fun fromTimestamp(value: Long) = value?.let { Date(it) }

    @TypeConverter
    fun fromDate(date: Date) = Date().time
}