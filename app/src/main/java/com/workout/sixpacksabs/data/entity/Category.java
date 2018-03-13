package com.workout.sixpacksabs.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by AdnanAli on 3/12/2018.
 */
@Entity(tableName = "category")
public class Category {
    @PrimaryKey
    int id;
    @ColumnInfo(name = "category_type")
    @SerializedName("type")
    String categoryType;
    @ColumnInfo(name = "category_name")
    @SerializedName("title")
    String categoryName;
    @ColumnInfo(name = "category_image")
    @SerializedName("image")
    String categoryImage;
    @ColumnInfo(name = "is_local")
    boolean isLocal = true;

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }
}
