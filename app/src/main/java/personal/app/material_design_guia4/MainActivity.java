package personal.app.material_design_guia4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import static personal.app.material_design_guia4.ListEmployeesActivity.lstEmployees;

public class MainActivity extends AppCompatActivity {

    private Button btnAddEmployee, btnLstEmployees;
    private Button btnMostrarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddEmployee = (Button) findViewById(R.id.btnAddEmployee);
        btnLstEmployees = (Button) findViewById(R.id.btnLstEmployees);
        btnMostrarDatos = (Button) findViewById(R.id.btnMostrarDatos);

        btnAddEmployee.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddEmployeeActivity.class));
        });

        btnLstEmployees.setOnClickListener(v -> {
            if(lstEmployees == null){
                Toast.makeText(this,"Lista vacia.", Toast.LENGTH_SHORT).show();
            }
            else
            {
                startActivity(new Intent(MainActivity.this, AddEmployeeActivity.class));
            }
        });

        btnMostrarDatos.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MostrarDatosActivity.class));
        });

    }
}