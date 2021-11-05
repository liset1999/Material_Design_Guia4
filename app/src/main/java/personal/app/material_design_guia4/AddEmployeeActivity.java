package personal.app.material_design_guia4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployeeActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText edtName, edtLastName;
    private CheckBox seleccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnAdd = (Button) findViewById(R.id.btnAdd);
        edtName = (EditText) findViewById(R.id.edtName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        seleccion = (CheckBox) findViewById(R.id.cbCondiciones);

        btnAdd.setOnClickListener(v -> {

            if(!seleccion.isChecked()){
                String s = "Estado: " + (seleccion.isChecked() ? "Terminos y condiciones aceptados" : "Acepte terminos y condiciones");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                seleccion.requestFocus();
                return;
            }
            else{
                Intent intent = new Intent(this, ListEmployeesActivity.class);
                String name = edtName.getText().toString();
                String lastname = edtLastName.getText().toString();

                Bundle extras = new Bundle();
                extras.putString("NAME",name);
                extras.putString("LASTNAME",lastname);
                intent.putExtras(extras);
                startActivity(intent);

                Toast.makeText(AddEmployeeActivity.this, "Registro añadido: " + name +" "+ lastname, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Cancel(View view) {
        edtName.setText("");
        edtLastName.setText("");
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