package com.example.myappnew.basa;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/* будет использован для создания таблицы в базе*/
@Entity
public class Entity_UserWeek {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "textDay")
    int textDay;


    /*дата
    public String date;*/

    /*заметки на день
    public int textDay;*/
}
