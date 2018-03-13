package com.workout.sixpacksabs.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.workout.sixpacksabs.data.entity.PlanDays;

import java.util.List;

/**
 * Created by AdnanAli on 3/13/2018.
 */
@Dao
public interface PlanDaysDao {
    @Query("SELECT * FROM plan_days WHERE category_id=:type LIMIT 21")
    LiveData<List<PlanDays>> getSelectedPlanDays(int type);

    @Query("SELECT * FROM plan_days WHERE category_id=:type AND complete_status=1")
    PlanDays findCompleteDays(int type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPlanDays(PlanDays... planDays);

    @Delete
    void deletePlanDay(PlanDays planDays);

}
