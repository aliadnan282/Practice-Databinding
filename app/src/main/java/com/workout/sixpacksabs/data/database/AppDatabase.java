package com.workout.sixpacksabs.data.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


import com.workout.sixpacksabs.data.dao.CategoryDao;
import com.workout.sixpacksabs.data.entity.Category;
import com.workout.sixpacksabs.helper.JsonManager;

import java.util.List;

/**
 * Created by AdnanAli on 3/12/2018.
 */

@Database(entities = {Category.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "six_pack";
    private static AppDatabase INSTANCE;
    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     */
    private static Callback sRoomDatabaseCallback = new Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                    .addCallback(sRoomDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract CategoryDao categoryDao();

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final CategoryDao mDao;

        PopulateDbAsync(AppDatabase db) {
            mDao = db.categoryDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
           // mDao.deleteAllCategory();

            List<Category> categoryList = JsonManager.getInstance().getCategoriseModel();
            for (Category category : categoryList) {
                mDao.insertAllCategory(category);
            }
            return null;
        }
    }
}
