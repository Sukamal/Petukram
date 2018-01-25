package com.suku.petukrecipe.features.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suku.petukrecipe.R;
import com.suku.petukrecipe.features.BaseFragment;
import com.suku.petukrecipe.models.RecipeItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SukamalD on 25-01-2018.
 */

public class HomeFragment extends BaseFragment{

    @BindView(R.id.rv_indian)
    RecyclerView rvIndianRecipe;
    @BindView(R.id.rv_microwave)
    RecyclerView rvMicrowave;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,view);
        initRecyclerView();
        return view;
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvIndianRecipe.setLayoutManager(layoutManager);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvMicrowave.setLayoutManager(layoutManager1);

        setReciepe();
        setOvenReciepe();
    }

    private void setReciepe(){
        ArrayList<RecipeItem> recipes = new ArrayList<RecipeItem>();
        RecipeItem recipeItem;
        recipeItem = new RecipeItem();
        recipeItem.setRecipyName("INDIAN");
        recipes.add(recipeItem);

        for(int i=1;i<10;i++){
            recipeItem = new RecipeItem();
            recipeItem.setRecipyName("ITEM "+i);
            recipeItem.setCookingTime(25);
            recipeItem.setRecipyImage(R.drawable.indian);

            recipes.add(recipeItem);
        }

        recipeItem = new RecipeItem();
        recipeItem.setRecipyName("MORE");
        recipes.add(recipeItem);

        RecipeHomeAdapter recipeAdapter = new RecipeHomeAdapter(recipes);
        rvIndianRecipe.setAdapter(recipeAdapter);
    }

    private void setOvenReciepe(){
        ArrayList<RecipeItem> recipes = new ArrayList<RecipeItem>();
        RecipeItem recipeItem;
        recipeItem = new RecipeItem();
        recipeItem.setRecipyName("MICROWAVE OVEN RECIPE");
        recipes.add(recipeItem);

        for(int i=1;i<10;i++){
            recipeItem = new RecipeItem();
            recipeItem.setRecipyName("ITEM "+i);
            recipeItem.setCookingTime(25);
            recipeItem.setRecipyImage(R.drawable.indian);

            recipes.add(recipeItem);
        }

        recipeItem = new RecipeItem();
        recipeItem.setRecipyName("MORE");
        recipes.add(recipeItem);

        RecipeHomeAdapter recipeAdapter = new RecipeHomeAdapter(recipes);
        rvMicrowave.setAdapter(recipeAdapter);
    }


}
