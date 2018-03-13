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
import com.workout.sixpacksabs.data.entity.Category;
import com.workout.sixpacksabs.databinding.CardVhCategoryBinding;
import com.workout.sixpacksabs.view.activity.DaysActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdnanAli on 3/8/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.VHCategory> {
    private static final String TAG = CategoryAdapter.class.getSimpleName();
    LayoutInflater inflater;
    Context context;
    private List<Category> categoryList = new ArrayList<>();

    public CategoryAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public VHCategory onCreateViewHolder(ViewGroup parent, int viewType) {
        CardVhCategoryBinding cardVhCategory = DataBindingUtil.inflate(inflater, R.layout.card_vh_category, parent, false);
        return new VHCategory(cardVhCategory);
    }


    @Override
    public void onBindViewHolder(VHCategory holder, int position) {
        Category category = categoryList.get(position);
        holder.bind(category);

    }

    public void onCategoryClicked(View view, Category categoryModel) {
        Log.d(TAG, "onCategoryClicked: ");
        context.startActivity(new Intent(context, DaysActivity.class));
        //Toast.makeText(view.getContext(), "" + categoryModel.getCategoryName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setCategories(List<Category> categories) {
        Log.d(TAG, "setCategories: size" + categories.size());
        categoryList = categories;
        notifyDataSetChanged();
    }

    class VHCategory extends RecyclerView.ViewHolder {
        CardVhCategoryBinding mBinding;

        VHCategory(CardVhCategoryBinding cardVhCategory) {
            super(cardVhCategory.getRoot());
            mBinding = cardVhCategory;
        }

        void bind(Category categoryModel) {
            mBinding.setCategory(categoryModel);
            mBinding.setAdapter(CategoryAdapter.this);
            mBinding.executePendingBindings();

        }
    }
}
