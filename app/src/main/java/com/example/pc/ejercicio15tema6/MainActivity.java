package com.example.pc.ejercicio15tema6;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    CheckBox box1, box2;
    SharedPreferences.Editor editor;
    EditText edit1, edit2, edit3;
    RadioButton radio1, radio2, radio3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        box1 = findViewById(R.id.checkBox);
        box2 = findViewById(R.id.checkBox2);
        edit1 = findViewById(R.id.editText);
        edit2 = findViewById(R.id.editText2);
        edit3 = findViewById(R.id.editText3);
        radio1 = findViewById(R.id.radioButton);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);
        prefs = getSharedPreferences("forma_abono", Context.MODE_PRIVATE);
        box1.setChecked(true);
        radio1.setChecked(true);
    }
    public void boton1(View view)
    {
        String clave="";
        editor = prefs.edit();
        editor.putBoolean("checkbox1", box1.isChecked());
        editor.putBoolean("checkbox2", box2.isChecked());
        editor.putString("nombre", edit1.getText().toString());
        editor.putString("apellidos", edit2.getText().toString());
        editor.putInt("importe", Integer.parseInt(edit3.getText().toString()));
        /*switch (view.getId())
        {
            case R.id.radioButton: clave="Contado"; break;
            case R.id.radioButton2: clave="Tarjeta"; break;
            case R.id.radioButton3: clave="Otro"; break;
        }
        editor.putBoolean(clave, ((RadioButton)view).isChecked());
        */
        editor.putBoolean("radio1", radio1.isChecked());
        editor.putBoolean("radio2", radio2.isChecked());
        editor.putBoolean("radio3", radio3.isChecked());
        editor.commit();
    }
    public void boton2(View view)
    {
        Boolean checkbox1 = prefs.getBoolean("checkbox1", true);
        Boolean checkbox2 = prefs.getBoolean("checkbox2", false);
        String cadena1 = prefs.getString("nombre", "Sin nombre");
        String cadena2 = prefs.getString("apellidos", "Sin apellidos");
        int cadena3 = prefs.getInt("importe", 0);
        Boolean r1 = prefs.getBoolean("radio1", true);
        Boolean r2 = prefs.getBoolean("radio2", false);
        Boolean r3 = prefs.getBoolean("radio3", false);
       // Boolean radio = prefs.getBoolean("clave", true);
        box1.setChecked(checkbox1);
        box2.setChecked(checkbox2);
        edit1.setText(cadena1);
        edit2.setText(cadena2);
        edit3.setText("" +cadena3);
        radio1.setChecked(r1);
        radio2.setChecked(r2);
        radio3.setChecked(r3);
       /* if(radio1.getText() == "Contado")
        {
            radio1.setChecked(true);
        }
        else if(radio2.getText() == "Tarjeta")
        {
            radio2.setChecked(true);
        }
        else
        {
            radio3.setChecked(true);
        }
        */
    }
    public void boton3(View view)
    {
    box1.setChecked(true);
    box2.setChecked(false);
    edit1.setText("sin nombre");
    edit2.setText("sin apellidos");
    edit3.setText("0");
    radio2.setChecked(false);
    radio3.setChecked(false);
    radio1.setChecked(true);
    }
}
