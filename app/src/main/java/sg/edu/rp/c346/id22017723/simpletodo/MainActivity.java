package sg.edu.rp.c346.id22017723.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText tv;
    Button btnAdd;
    Button btnDelete;
    Button btnClear;
    ListView list;
    Spinner spinner;
    ArrayList<String> stuff = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.editTextStuff);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnDelete = findViewById(R.id.buttonDeleteItem);
        btnClear = findViewById(R.id.buttonClearItem);
        list = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter toDo = new ArrayAdapter(this, android.R.layout.simple_list_item_1,stuff);
        list.setAdapter(toDo);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    tv.setHint(getString(R.string.hint1));
                    btnDelete.setEnabled(false);
                    btnAdd.setEnabled(true);

                    btnAdd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String task = tv.getText().toString();
                            stuff.add(task);
                            toDo.notifyDataSetChanged();
                            tv.getText().clear();
                        }
                    });
                }else if(position==1) {
                    tv.setHint(getString(R.string.hint2));
                    btnAdd.setEnabled(false);
                    btnDelete.setEnabled(true);

                    btnDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (!toDo.isEmpty()) {

                                if (!tv.getText().toString().isEmpty()) {
                                    int position = Integer.parseInt(tv.getText().toString());
                                    stuff.remove(position);
                                    toDo.notifyDataSetChanged();
                                } else if (position < 0 || position >= stuff.size()){
                                    Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                            }

                            tv.getText().clear();
                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDo.clear();
            }
        });
    }

}