package com.hedrich.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L,
    @ColumnInfo(name = "wish-title")
    val title:String="",
    @ColumnInfo(name = "wish-desc")
    val description:String="")


object DummyWish{
    val wishList = listOf(
        Wish(title = "Google Watch 2", description = "Android Watch"),
        Wish(title = "DJI Mini 3 Pro", description = "4k Drone"),
        Wish(title = "Traxxas Defender", description = "RC rock crawler"),
    )
}