package deepak.opensource.com.daggerkotlin.data.local.entity

import androidx.room.*
import java.util.*

/**
 * Created by Ajay Deepak on 15-06-2019.
 */

@Entity(tableName = "user",
    foreignKeys = [ForeignKey(
        entity = Address::class,
        parentColumns = ["id"],
        childColumns = ["address_id"],
        onDelete = ForeignKey.CASCADE
    )]) // this avoids proguard to obfuscate my model class
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Long =0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "dob")
    var dateOfBirth: Date, // Need to use type convertors as room does not allow to store complex datatype than primitives

    @ColumnInfo(name = "address_id")
    var addressId: Long,

    @Ignore // Use ignore to specify the field to be used and not be persisted in room
    var selected: Boolean = false

){
    constructor() : this(0,"", Date(),0)
}