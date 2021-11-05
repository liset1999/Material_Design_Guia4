package personal.app.material_design_guia4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import personal.app.material_design_guia4.adapters.EmployeesAdapter;
import personal.app.material_design_guia4.model.EmployeeModel;

public class ListEmployeesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EmployeesAdapter employeesAdapter;
    public static List<EmployeeModel> lstEmployees;
    LinearLayoutManager linearLayoutManager;
    String name, lastname;
    TextView tvNumber;
    FloatingActionButton btnNuevo;
    boolean b = true;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employees);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if(lstEmployees == null){
            lstEmployees = new ArrayList<EmployeeModel>();
            tvNumber = (TextView) findViewById(R.id.tvNumber);
            btnNuevo=(FloatingActionButton)findViewById(R.id.btnNuevo);
            name = getIntent().getExtras().getString("NAME");
            lastname = getIntent().getExtras().getString("LASTNAME");
            lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, name, lastname));
            setRecyclerView(lstEmployees);
            i = lstEmployees.size();
            tvNumber.setText("Cantidad de encuestados: " + i);
            b = false;
        }
        try {
            name = getIntent().getExtras().getString("NAME");
        }catch(Exception exception){
            b = false;
        }
        if(!lstEmployees.isEmpty() && b == true){
            tvNumber = (TextView) findViewById(R.id.tvNumber);
            btnNuevo=(FloatingActionButton)findViewById(R.id.btnNuevo);
            name = getIntent().getExtras().getString("NAME");
            lastname = getIntent().getExtras().getString("LASTNAME");
            lstEmployees.add(new EmployeeModel(R.drawable.android_kotlin, name, lastname));
            setRecyclerView(lstEmployees);
            i = lstEmployees.size();
            tvNumber.setText("Cantidad de encuestados: " + i);
        }else {
            tvNumber = (TextView) findViewById(R.id.tvNumber);
            setRecyclerView(lstEmployees);
            i = lstEmployees.size();
            tvNumber.setText("Cantidad de encuestados: " + i);

        }
    }

    private void setRecyclerView(List<EmployeeModel> lstEmployees) {
        recyclerView = (RecyclerView) findViewById(R.id.rvEmployees);
        linearLayoutManager = new LinearLayoutManager(ListEmployeesActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        employeesAdapter = new EmployeesAdapter(lstEmployees);
        recyclerView.setAdapter(employeesAdapter);
        employeesAdapter.notifyDataSetChanged();
    }

    public void agregarnuevo(View view){
        Intent intent =new Intent(this,AddEmployeeActivity.class);
        intent.putExtra("estado",0);
        startActivity(intent);
    }

    public void Menu(View view){
        Intent intent = new Intent(ListEmployeesActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Toast.makeText(ListEmployeesActivity.this, "SE destruyó", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}