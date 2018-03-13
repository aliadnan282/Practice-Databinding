package com.workout.sixpacksabs.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.workout.sixpacksabs.R;
import com.workout.sixpacksabs.view.adapter.CategoryAdapter;
import com.workout.sixpacksabs.data.entity.Category;
import com.workout.sixpacksabs.databinding.ActivityMainBinding;
import com.workout.sixpacksabs.viewmodel.CategoryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    CategoryAdapter categoryAdapter;
    CategoryViewModel categoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.rvCategory.setLayoutManager(new LinearLayoutManager(this));
        categoryAdapter = new CategoryAdapter(this);
        activityMainBinding.rvCategory.setAdapter(categoryAdapter);

        // Get a new or existing ViewModel from the ViewModelProvider.
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        categoryViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                categoryAdapter.setCategories(categories);
            }
        });
    }

}
