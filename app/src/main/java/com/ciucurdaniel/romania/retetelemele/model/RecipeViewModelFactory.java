package com.ciucurdaniel.romania.retetelemele.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ciucurdaniel.romania.retetelemele.viewmodel.RecipeViewModel;

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

/*
    private Application mApplication;



    public TeamViewModelFactory(Application application) {
        super(application);
        mApplication = application;

    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new TeamViewModel(mApplication);
    }
 */