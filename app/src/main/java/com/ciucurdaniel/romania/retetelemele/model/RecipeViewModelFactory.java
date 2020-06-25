package com.ciucurdaniel.romania.retetelemele.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ciucurdaniel.romania.retetelemele.viewmodel.RecipeViewModel;

/*
Factory class for creating ViewModels
because normal creation does not work anymore
no more  ViewModelProviders.of()
 */
public class RecipeViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private Application mApplication;


    public RecipeViewModelFactory(@NonNull Application application) {
        super(application);
        mApplication = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new RecipeViewModel(mApplication);
    }
}
