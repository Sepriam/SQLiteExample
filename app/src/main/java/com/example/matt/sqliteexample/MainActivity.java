package com.example.matt.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myInput;
    TextView myText;
    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInput = (EditText) findViewById(R.id.editText);
        myText = (TextView) findViewById(R.id.textView);
        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();

    }

    //add a product to the database
    public void addButtonClicked(View view)
    {
        Exercises exercises = new Exercises(myInput.getText().toString(), false);

        dbHandler.addProduct(exercises);

        printDatabase();
    }

    //delete Items
    public void deleteButtonClicked(View view)
    {
        String inputText = myInput.getText().toString();

        dbHandler.deleteExercise(inputText);

        printDatabase();
    }


    public void printDatabase()
    {
        String dbString = dbHandler.databaseToString();
        myText.setText(dbString);

        myInput.setText("");
    }
}
