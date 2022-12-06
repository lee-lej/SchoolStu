package com.example.schoolstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.schoolstu.Modules.CustomAdapter;
import com.example.schoolstu.Modules.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    Button buttonNext;
    EditText editTextName;
    EditText editTextSurname;
    EditText editTextAge;
    EditText editTextEmail;
    List<Person> list= new ArrayList<>();


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextAge= (EditText)findViewById(R.id.editTextAge);
        editTextEmail= (EditText)findViewById(R.id.editTextEmail);
        editTextSurname= (EditText)findViewById(R.id.editTextSurname);
        button= (Button)findViewById(R.id.button);
        buttonNext= (Button)findViewById(R.id.buttonNext);
        listView= (ListView)findViewById(R.id.listView);


        final ArrayAdapter adapter= new CustomAdapter(MainActivity.this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_LONG).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Person person= new Person();
                person.setName(editTextName.getText().toString());
                person.setSurname(editTextSurname.getText().toString());
                person.setAge(editTextAge.getText().toString());
                person.setEmail(editTextEmail.getText().toString());
                list.add(person);
                adapter.notifyDataSetChanged();

            }
        });
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSchool();
            }
        });

    }

    private void goToSchool() {
        Intent goToSchool= new Intent(MainActivity.this, MainActivity2.class);

        startActivity(goToSchool);
    }
}
