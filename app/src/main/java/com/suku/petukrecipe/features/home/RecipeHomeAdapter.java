package com.suku.petukrecipe.features.home;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.suku.petukrecipe.R;
import com.suku.petukrecipe.models.RecipeItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SukamalD on 25-01-2018.
 */

public class RecipeHomeAdapter extends RecyclerView.Adapter<RecipeHomeAdapter.RecipeViewHolder>{

    private List<RecipeItem> recipeList;
    private ClickListener clickListener;

    public interface ClickListener {
        void onAdapterItemClick(View view, int position, Object selectedItem);
    }

    public RecipeHomeAdapter(List<RecipeItem> recipeList){
        this.recipeList = recipeList;
    }

    public RecipeHomeAdapter(List<RecipeItem> recipeList, ClickListener clickListener){
        this.recipeList = recipeList;
        this.clickListener = clickListener;
    }

    public void setItemClickListner(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void addMoreItem(){
        recipeList.add(new RecipeItem());
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
        if(position == 0 || position == recipeList.size()-1){
            holder.cardView.setVisibility(View.GONE);
            holder.llTypeSlide.setVisibility(View.VISIBLE);
            holder.tvTtype.setText(recipeItem.getRecipyName());
        }else{
            holder.cardView.setVisibility(View.VISIBLE);
            holder.llTypeSlide.setVisibility(View.GONE);

            holder.tvTitle.setText(recipeItem.getRecipyName());
            holder.tvTime.setText(String.valueOf(recipeItem.getCookingTime()));
            holder.ivImage.setImageResource(recipeItem.getRecipyImage());
        }
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
        @BindView(R.id.tv_type)
        TextView tvTtype;
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.ll_type_slide)
        LinearLayout llTypeSlide;


        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
