package com.suku.petukrecipe.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.suku.petukrecipe.R;
import com.suku.petukrecipe.models.RecipeItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SukamalD on 25-01-2018.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{

    private List<RecipeItem> recipeList;
    private ClickListener clickListener;

    public interface ClickListener {
        void onAdapterItemClick(View view, int position, Object selectedItem);
    }

    public RecipeAdapter(List<RecipeItem> recipeList){
        this.recipeList = recipeList;
    }

    public RecipeAdapter(List<RecipeItem> recipeList,ClickListener clickListener){
        this.recipeList = recipeList;
        this.clickListener = clickListener;
    }

    public void setItemClickListner(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_recipe, parent, false);
        RecipeViewHolder holder = new RecipeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {

        RecipeItem recipeItem = recipeList.get(position);
        holder.tvTitle.setText(recipeItem.getRecipyName());
        holder.tvTime.setText(String.valueOf(recipeItem.getCookingTime()));
        holder.ivImage.setImageResource(recipeItem.getRecipyImage());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_recipe_title)
        TextView tvTitle;
        @BindView(R.id.tv_recipe_time)
        TextView tvTime;
        @BindView(R.id.iv_recipe_image)
        ImageView ivImage;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
