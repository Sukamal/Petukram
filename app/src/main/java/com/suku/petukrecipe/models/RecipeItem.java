package com.suku.petukrecipe.models;

/**
 * Created by SukamalD on 25-01-2018.
 */

public class RecipeItem {

    private String recipyName;
    private int recipyImage;
    private int cookingTime;

    public String getRecipyName() {
        return recipyName;
    }

    public void setRecipyName(String recipyName) {
        this.recipyName = recipyName;
    }

    public int getRecipyImage() {
        return recipyImage;
    }

    public void setRecipyImage(int recipyImage) {
        this.recipyImage = recipyImage;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
}
