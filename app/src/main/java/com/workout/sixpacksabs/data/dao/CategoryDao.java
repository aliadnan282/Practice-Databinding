package com.workout.sixpacksabs.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.workout.sixpacksabs.data.entity.Category;

import java.util.List;

/**
 * Created by AdnanAli on 3/12/2018.
 */

@Dao
public interface CategoryDao {
    @Query("SELECT * FROM category")
    LiveData<List<Category>> getAllCategory();

    @Query("SELECT * FROM category WHERE category_type LIKE :type")
    Category findByType(String type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(Category... categories);

    @Delete
    void deleteCategory(Category categories);


}
