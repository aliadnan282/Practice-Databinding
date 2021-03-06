package com.workout.sixpacksabs.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.workout.sixpacksabs.R;
import com.workout.sixpacksabs.data.entity.Category;
import com.workout.sixpacksabs.databinding.ActivityMainBinding;
import com.workout.sixpacksabs.view.adapter.CategoryAdapter;
import com.workout.sixpacksabs.viewmodel.CategoryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
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
/*     Firebase DB getting data

 FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("plan_categories");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    Category category = dataSnapshot1.getValue(Category.class);
                    Log.d(TAG, "onDataChange: id="+category.getId());
                }
                long post = dataSnapshot.getChildrenCount();
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                Toast.makeText(MainActivity.this, ""+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                // ...
            }
        };
        myRef.addValueEventListener(postListener);
 */