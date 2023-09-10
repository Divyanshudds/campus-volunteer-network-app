package com.example.collegefest_volunteernetwork.college_database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.collegefest_volunteernetwork.college_dao.IonformationDao;
import com.example.collegefest_volunteernetwork.model_class.InformationModel;

@Database(entities = {InformationModel.class},version = 1)
public abstract class CollegefestDatabase extends RoomDatabase {
    private static CollegefestDatabase db;
    private static final String DB_NAME = "donation.db";
    public abstract IonformationDao getCollegeDao();

    public static CollegefestDatabase getInstance(Context context){
        if (db != null){
            return db;
        }

        db = Room.databaseBuilder(context.getApplicationContext(), CollegefestDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();
        return db;
    }
}
