package de.alexgipp.zeiterfassung.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WorkTimeDao {
    @Query("Select * From time_data")
    List<WorkTime> getAll();

    @Query("Select * From time_data Where _id = :id")
    WorkTime getById(int id);

    @Insert
    void add(WorkTime workTime);
}
