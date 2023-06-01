package sg.edu.rp.c346.id22017723.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText tv;
    Button btnAdd;
    Button btnClear;
    ListView list;

    ArrayList<String> stuff = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.editTextStuff);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnClear = findViewById(R.id.buttonClearItem);
        list = findViewById(R.id.listView);

        ArrayAdapter toDo = new ArrayAdapter(this, android.R.layout.simple_list_item_1,stuff);
        list.setAdapter(toDo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = tv.getText().toString();
                stuff.add(colour);
                toDo.notifyDataSetChanged();
                tv.getText().clear();
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