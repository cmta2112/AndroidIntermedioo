package pe.edu.cibertec.favouritemovies;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Movie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

   // public abstract MovieDao movieDao();

    private static AppDatabase instance = null;

    static AppDatabase getInstance(Context context) {

        if (instance == null) {
            instance
                    = Room.databaseBuilder(context, AppDatabase.class, "db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract MovieDao movieDao();
}
