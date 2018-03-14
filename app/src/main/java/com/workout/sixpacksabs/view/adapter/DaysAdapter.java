package com.workout.sixpacksabs.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.workout.sixpacksabs.R;
import com.workout.sixpacksabs.data.entity.PlanDays;
import com.workout.sixpacksabs.databinding.CardVhDaysBinding;
import com.workout.sixpacksabs.view.activity.ExerciseListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdnanAli on 3/8/2018.
 */

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.VHCategory> {
    private static final String TAG = DaysAdapter.class.getSimpleName();
    LayoutInflater inflater;
    private List<PlanDays> categoryList = new ArrayList<>();
    Context context;

    public DaysAdapter(Context context) {
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public VHCategory onCreateViewHolder(ViewGroup parent, int viewType) {
        CardVhDaysBinding cardVhCategory = DataBindingUtil.inflate(inflater, R.layout.card_vh_days, parent, false);
        return new VHCategory(cardVhCategory);
    }


    @Override
    public void onBindViewHolder(VHCategory holder, int position) {
        PlanDays category = categoryList.get(position);
        holder.bind(category);

    }

    public void onPlanDaysClicked(View view, PlanDays categoryModel) {
        Log.d(TAG, "onCategoryClicked: ");
        context.startActivity(new Intent(context, ExerciseListActivity.class));
        Toast.makeText(view.getContext(), "" + categoryModel.getDayNumber(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setPlanDays(List<PlanDays> categories) {
        Log.d(TAG, "setCategories: size" + categories.size());
        categoryList = categories;
        notifyDataSetChanged();
    }

    class VHCategory extends RecyclerView.ViewHolder {
        CardVhDaysBinding mBinding;

        VHCategory(CardVhDaysBinding cardVhDaysBinding) {
            super(cardVhDaysBinding.getRoot());
            mBinding = cardVhDaysBinding;
        }

        void bind(PlanDays planDays) {
            mBinding.setPlanDays(planDays);
            mBinding.setAdapter(DaysAdapter.this);
            mBinding.executePendingBindings();

        }
    }
}
