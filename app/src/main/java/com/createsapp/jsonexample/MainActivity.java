package com.createsapp.jsonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String JSON_STRING = "{\"employee\":{\"name\":\"Hetvi\",\"salary\":\"20000\"}}";

    String name, salary;

    //Widget
    TextView employeeName, employeeSalary;
    Button uploadBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init widget
        employeeName = findViewById(R.id.name);
        employeeSalary = findViewById(R.id.salary);
        uploadBtn = findViewById(R.id.uploadBtn);

        try {
            //get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            //fetch JSONObject named and employee
            JSONObject employee = obj.getJSONObject("employee");
            //get employee name and salary
            name = employee.getString("name");
            salary = employee.getString("salary");

            //set employee name and salary in TextView's
            employeeName.setText(name);
            employeeSalary.setText(salary);

        } catch (JSONException e){
            e.printStackTrace();
        }

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uploadName = employeeName.getText().toString();
                String uploadSalary = employeeSalary.getText().toString();

                Toast.makeText(MainActivity.this, "Name: "+uploadName+" Salary "+uploadSalary, Toast.LENGTH_LONG).show();
            }
        });
    }
}