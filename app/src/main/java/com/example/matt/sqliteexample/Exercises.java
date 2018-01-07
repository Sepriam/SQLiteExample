package com.example.matt.sqliteexample;


import java.util.PriorityQueue;

public class Exercises {

    private String ExerciseName;
    private boolean IsSelected;

    public Exercises()
    {
        //default constructor if we want an empty exercise object to update later
    }

    //constructor for passing an exercise and is selected option
    public Exercises(String _exerciseName, Boolean _selected)
    {
        //assigning the constructor params to the object's variables for this object
        this.ExerciseName = _exerciseName;
        this.IsSelected = _selected;

    }


    public String getExerciseName() {
        return ExerciseName;
    }

    public void setExerciseName(String exerciseName) {
        ExerciseName = exerciseName;
    }

    public boolean isSelected() {
        return IsSelected;
    }

    public void setSelected(boolean selected) {
        IsSelected = selected;
    }
}
