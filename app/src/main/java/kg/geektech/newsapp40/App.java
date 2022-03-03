package kg.geektech.newsapp40;

import android.app.Application;

import androidx.room.Room;

import kg.geektech.newsapp40.data.AppDatabase;

public class App extends Application {

    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database= Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "news-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();
    }
}
