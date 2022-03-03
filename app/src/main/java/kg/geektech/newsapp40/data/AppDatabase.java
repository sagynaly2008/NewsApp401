package kg.geektech.newsapp40.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import kg.geektech.models.News;

@Database(entities = {News.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
 public abstract NewsDao newsDao();
}
