package sg.edu.rp.c346.simpletodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button add_btn;
    Button clear_btn;
    ListView lvDisplay;
    ArrayList<String> todoList;
    ArrayAdapter listDisplay;
    Spinner taskSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.userInput);
        add_btn=findViewById(R.id.btn_add);
        clear_btn=findViewById(R.id.btn_clear);
        lvDisplay=findViewById(R.id.listView);
        taskSpinner=findViewById(R.id.spinner);

        todoList = new ArrayList<String>();
        listDisplay=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1, todoList);
        lvDisplay.setAdapter(listDisplay);

        taskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = input.getText().toString();
                todoList.add(getInput);
                listDisplay.notifyDataSetChanged();
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todoList.removeAll(todoList);
                listDisplay.notifyDataSetChanged();
            }
        });




    }
}
