package com.example.schoolstu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.schoolstu.Modules.School;
import com.example.schoolstu.Modules.SchoolCustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listViewS;
    Button buttonAddEd;
    Button buttonSave;
    EditText editTextSchool;
    EditText editTextYearofstudy;
    EditText editTextDegree;
    EditText editTextGroup;
    List<School> listS = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextSchool = (EditText) findViewById(R.id.editTextSchool);
        editTextYearofstudy = (EditText) findViewById(R.id.editTextYear);
        editTextDegree = (EditText) findViewById(R.id.editTextDegree);
        editTextGroup = (EditText) findViewById(R.id.editTextGroup);
        buttonAddEd = (Button) findViewById(R.id.buttonEd);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        listViewS = (ListView) findViewById(R.id.listViewS);

        final ArrayAdapter adapterS = new SchoolCustomAdapter(MainActivity2.this, listS);
        listViewS.setAdapter(adapterS);
        listViewS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        buttonAddEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                School  school = new School();
                school.setSchoolName(editTextSchool.getText().toString());
                school.setYearOfStudies(editTextYearofstudy.getText().toString());
                school.setDegree(editTextDegree.getText().toString());
                school.setGroup(editTextGroup.getText().toString());
                listS.add(school);
                adapterS.notifyDataSetChanged();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveMethod();
            }
        });
    }

    private void SaveMethod() {
        goToSavedData(editTextSchool,editTextYearofstudy,editTextDegree,editTextGroup);
    }

    private void goToSavedData(EditText editTextSchool, EditText editTextYearofstudy, EditText editTextDegree, EditText editTextGroup) {
        Intent goToSavedData = new Intent(MainActivity2.this, SavedDataActivity.class);
        goToSavedData.putExtra("School", this.editTextSchool.getText().toString());
        goToSavedData.putExtra("Year", this.editTextYearofstudy.getText().toString());
        goToSavedData.putExtra("Degree", this.editTextDegree.getText().toString());
        goToSavedData.putExtra("Group", this.editTextGroup.getText().toString());
        startActivity(goToSavedData);
    }
}