package com.workout.sixpacksabs.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

/**
 * Created by AdnanAli on 3/13/2018.
 */
@Entity(tableName = "plan_days", primaryKeys = {"day_number", "category_id"})
public class PlanDays {
    @ColumnInfo(name = "day_number")
    int dayNumber;
    @ColumnInfo(name = "category_id")
    int categoryId;
    @ColumnInfo(name = "complete_status")
    boolean isComplete = false;

    public PlanDays(int dayNumber, int categoryId, boolean isComplete) {
        this.dayNumber = dayNumber;
        this.categoryId = categoryId;
        this.isComplete = isComplete;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }


}
