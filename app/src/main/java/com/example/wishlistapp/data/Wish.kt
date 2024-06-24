package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
data class Wish(

    @PrimaryKey(autoGenerate = true )
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-description")
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(1, "Title 1", "Description 1"),
        Wish(2, "Title 2", "Description 2"),
        Wish(3, "Title 3", "Description 3"),
        Wish(4, "Title 4", "Description 4"),
        Wish(5, "Title 5", "Description 5"),
        Wish(6, "Title 6", "Description 6"),
    )
}


