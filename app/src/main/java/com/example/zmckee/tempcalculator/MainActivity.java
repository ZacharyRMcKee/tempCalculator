package com.example.zmckee.tempcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<String> calculations;
    static int calcNumber;
    ArrayAdapter<String> adapter;
    TextView unit1;
    TextView unit2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        calculations = new LinkedList<>();
        calcNumber = 0;
        ListView calcDisplay = findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, calculations);
        calcDisplay.setAdapter(adapter);
    }
    public void rad1Handler(View view)
    {
        unit1 =  findViewById(R.id.unit1);
        unit2 =  findViewById(R.id.unit2);
        unit1.setText("F");
        unit2.setText("C");
    }
    public void rad2Handler(View view)
    {
        unit1 =  findViewById(R.id.unit1);
        unit2 =  findViewById(R.id.unit2);
        unit1.setText("C");
        unit2.setText("F");
    }
    public void convertClicked(View view)
    {
        unit1 =  findViewById(R.id.unit1);
        unit2 =  findViewById(R.id.unit2);
        EditText input = findViewById(R.id.input);
        RadioButton radFtoC = findViewById(R.id.FtoC);
        RadioButton radCtoF = findViewById(R.id.CtoF);
        TextView textOutput = findViewById(R.id.output);



        double output;
        double inputValue = Double.parseDouble(input.getText().toString());
        boolean convertFtoC = radFtoC.isChecked();
        boolean convertCtoF = radCtoF.isChecked();

        if(convertFtoC)
        {
            output = (inputValue - 32.0) * (5.0/9.0);
        }
        else if (convertCtoF)
        {
            output = (inputValue*9.0/5.0) + 32.0;
        }
        else
        {
            output = 0xDEADBEEF;
        }



        adapter.notifyDataSetChanged();
        String outputString = String.format("%.1f",output);

        calcNumber++;
        calculations.add(0,Integer.toString(calcNumber) + ": " +
                Double.toString(inputValue) + " " + unit1.getText().toString() + " -> " +
                outputString + " " + unit2.getText().toString());

        textOutput.setText(outputString);
    }
}
