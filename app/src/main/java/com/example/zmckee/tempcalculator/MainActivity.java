package com.example.zmckee.tempcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void convertClicked(View view)
    {
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
        String outputString = String.format("%.1f",output);
        textOutput.setText(outputString);
    }
}
