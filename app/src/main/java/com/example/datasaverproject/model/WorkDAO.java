package com.example.datasaverproject.model;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WorkDAO {

    @Insert
    Void InsertWork(MyWork myWork);

    @Query("Select * from myWork")
    List<MyWork> getAllMyWork();

    @Update
    Void UpdateWork(MyWork myWork);

    @Delete
    Void DeleteWork(MyWork myWork);
}
