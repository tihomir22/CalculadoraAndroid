package com.example.sportak.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String numIzquierda="";
    String numDerecha="";
    String resultado;
    String signo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    public void leerNumero(View view) {
        Button btn= (Button) view;
        EditText panel=findViewById(R.id.editText);
        panel.setText(panel.getText()+""+btn.getText());
        if(this.numIzquierda!=""){
            this.numDerecha=this.numDerecha+btn.getText();
            Log.d("Mensaje","El valor de la parte derecha es "+this.numDerecha);
        }

    }

    public void leerSigno(View view) {
        Button btn= (Button) view;
        EditText panel=findViewById(R.id.editText);
        numIzquierda=panel.getText().toString();
        panel.setText(panel.getText()+""+btn.getText());
        signo=btn.getText().toString();


        Log.d("Mensaje","El valor de la parte izqueirda es "+this.numIzquierda);
    }

    public void calcular(View view) {
        EditText panel=findViewById(R.id.editText);
        panel.setText("");
        Double resultado=0.0;
        Double izquierda=Double.parseDouble(this.numIzquierda);
        Double derecha=Double.parseDouble(this.numDerecha);
        switch (this.signo){
            case "*":
                     resultado=izquierda*derecha;
                break;
            case "/":
                resultado=izquierda/derecha;
                break;

            case "+":
                resultado=izquierda+derecha;
                break;

            case "-":
                resultado=izquierda-derecha;
                break;
        }
        panel.setText(resultado+"");
        this.numIzquierda=""+resultado;



    }

    public void borrarTodo(View view) {
        this.numIzquierda="";
        this.numDerecha="";
        this.signo="";
        EditText panel=findViewById(R.id.editText);
        panel.setText("");
    }
}
