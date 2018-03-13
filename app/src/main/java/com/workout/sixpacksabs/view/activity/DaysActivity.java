package com.workout.sixpacksabs.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.workout.sixpacksabs.R;
import com.workout.sixpacksabs.data.entity.PlanDays;
import com.workout.sixpacksabs.databinding.ActivityDaysBinding;
import com.workout.sixpacksabs.view.adapter.DaysAdapter;
import com.workout.sixpacksabs.viewmodel.PlanDaysViewModel;

import java.util.List;

public class DaysActivity extends AppCompatActivity {

    private static final String TAG = DaysActivity.class.getSimpleName();
    ActivityDaysBinding activityDaysBinding;
    DaysAdapter daysAdapter;
    PlanDaysViewModel planDaysViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDaysBinding = DataBindingUtil.setContentView(this, R.layout.activity_days);
        activityDaysBinding.rvCategory.setLayoutManager(new LinearLayoutManager(this));
        daysAdapter = new DaysAdapter(this);
        activityDaysBinding.rvCategory.setAdapter(daysAdapter);

        // Get a new or existing ViewModel from the ViewModelProvider.
        planDaysViewModel = ViewModelProviders.of(this).get(PlanDaysViewModel.class);
        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        planDaysViewModel.getAllPlanDays().observe(this, new Observer<List<PlanDays>>() {
            @Override
            public void onChanged(@Nullable List<PlanDays> planDays) {
                daysAdapter.setPlanDays(planDays);
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