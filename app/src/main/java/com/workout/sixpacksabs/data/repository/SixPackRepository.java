package com.workout.sixpacksabs.data.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;


import com.workout.sixpacksabs.data.dao.CategoryDao;
import com.workout.sixpacksabs.data.database.AppDatabase;
import com.workout.sixpacksabs.data.entity.Category;

import java.util.List;

/**
 * Created by AdnanAli on 3/12/2018.
 */

public class SixPackRepository {
    private CategoryDao categoryDao;
    private LiveData<List<Category>> allCategories;

    public SixPackRepository(Application application) {
        AppDatabase db = AppDatabase.getAppDatabase(application);
        categoryDao = db.categoryDao();
        allCategories = categoryDao.getAllCategory();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }
}
