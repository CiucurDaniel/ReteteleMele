package com.ciucurdaniel.romania.retetelemele.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ciucurdaniel.romania.retetelemele.R;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {

    private OnItemClickListener listener; //used for tap recipe name to see full recipe
    private List<Recipe> recipes = new ArrayList<>();

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);
        return new RecipeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        Recipe currentRecipe = recipes.get(position);
        holder.textViewRecipeName.setText(currentRecipe.getName());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    class RecipeHolder extends RecyclerView.ViewHolder{
        private TextView textViewRecipeName;

        public RecipeHolder(View itemView) {
            super(itemView);
            textViewRecipeName = itemView.findViewById(R.id.text_view_recipe_name_AD);

            //we click on out itemView which is the recipe name
            //and we get the adapter position of the clicked item
            //and we get on item click
            //which we implement in other activity
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(recipes.get(position));
                    }
                }
            });
        }
    }

    //use this to edit contact on tap
    public interface OnItemClickListener{
        void onItemClick(Recipe recipe);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
