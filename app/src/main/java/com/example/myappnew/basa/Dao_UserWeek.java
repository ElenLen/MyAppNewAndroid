package com.example.myappnew.basa;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*методы для работы с базой данных*/
@Dao
public interface Dao_UserWeek {
    @Query("SELECT * FROM entity_userweek")
    List<Entity_UserWeek> getAll();

    @Query("SELECT * FROM entity_userweek WHERE id = :id")
    Entity_UserWeek getById(int id);

    @Insert
    void insert(Entity_UserWeek entity_userweek);

    @Update
    void update(Entity_UserWeek entity_userweek);

    @Delete
    void delete(Entity_UserWeek entity_userweek);
}
