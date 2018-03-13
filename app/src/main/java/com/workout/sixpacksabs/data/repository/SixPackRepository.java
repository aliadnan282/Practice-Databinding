package com.workout.sixpacksabs.data.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.workout.sixpacksabs.data.dao.CategoryDao;
import com.workout.sixpacksabs.data.dao.PlanDaysDao;
import com.workout.sixpacksabs.data.database.AppDatabase;
import com.workout.sixpacksabs.data.entity.Category;
import com.workout.sixpacksabs.data.entity.PlanDays;

import java.util.List;

/**
 * Created by AdnanAli on 3/12/2018.
 */

public class SixPackRepository {
    private CategoryDao categoryDao;
    private PlanDaysDao planDaysDao;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<PlanDays>> allPlanDays;

    public SixPackRepository(Application application) {
        AppDatabase db = AppDatabase.getAppDatabase(application);
        categoryDao = db.categoryDao();
        planDaysDao = db.planDaysDao();
        allCategories = categoryDao.getAllCategory();
        allPlanDays = planDaysDao.getSelectedPlanDays(1);
    }

    public LiveData<List<PlanDays>> getAllPlanDays() {
        return allPlanDays;
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }
}
