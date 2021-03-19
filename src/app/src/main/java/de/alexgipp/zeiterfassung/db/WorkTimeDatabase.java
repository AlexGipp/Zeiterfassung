package de.alexgipp.zeiterfassung.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {WorkTime.class}, version = 1)
public abstract class WorkTimeDatabase extends RoomDatabase {
    public abstract WorkTimeDao workTimeDato();
}
