package com.workout.sixpacksabs.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.workout.sixpacksabs.R;
import com.workout.sixpacksabs.databinding.ActivityExerciseListBinding;
import com.workout.sixpacksabs.dragable.OnStartDragListener;
import com.workout.sixpacksabs.dragable.SimpleItemTouchHelperCallback;
import com.workout.sixpacksabs.view.adapter.ExerciseListAdapter;
import com.workout.sixpacksabs.viewmodel.ExerciseListViewModel;

public class ExerciseListActivity extends AppCompatActivity implements OnStartDragListener {

    private static final String TAG = ExerciseListActivity.class.getSimpleName();
    ActivityExerciseListBinding activityExerciseListBinding;
    ExerciseListAdapter exerciseListAdapter;
    ExerciseListViewModel exerciseListViewModel;
    ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityExerciseListBinding = DataBindingUtil.setContentView(this, R.layout.activity_exercise_list);
        activityExerciseListBinding.rvCategory.setLayoutManager(new LinearLayoutManager(this));
        exerciseListAdapter = new ExerciseListAdapter(this, this);
        activityExerciseListBinding.rvCategory.setAdapter(exerciseListAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(exerciseListAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(activityExerciseListBinding.rvCategory);

        // Get a new or existing ViewModel from the ViewModelProvider.
        exerciseListViewModel = ViewModelProviders.of(this).get(ExerciseListViewModel.class);
        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        exerciseListViewModel.getAllPlanDays().observe(this, planDays -> exerciseListAdapter.setExerciseList(planDays));
        activityExerciseListBinding.btnStart.setOnClickListener(v -> {
            startActivity(new Intent(this, WarmUpActivity.class));
        });

    }

    /**
     * Called when a view is requesting a start of a drag.
     *
     * @param viewHolder The holder of the view to drag.
     */
    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
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