package com.joaopires.compressao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected TextView t;
    protected EditText introduzida;
    protected Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b = (Button)findViewById(R.id.botaoOk);
        t = (TextView)findViewById(R.id.textView);
        introduzida = (EditText)findViewById(R.id.string_introduzida);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aComprimir = introduzida.getText().toString();
                if (aComprimir.equals(""))
                {
                    Snackbar.make(view, "A compressão de zero é zero!", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
                else {
                    Compressao c = new Compressao(aComprimir);
                    t.setText("Original: " + aComprimir + "\n\n" + "Comprimida: " + c.comprimir());

                    Snackbar.make(view, "String Comprimida com sucesso!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String aComprimir = introduzida.getText().toString();
                if (aComprimir.equals(""))
                {
                    Snackbar.make(view, "Introduza a string que quer comprimir.", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }
                else {
                    Compressao c = new Compressao(aComprimir);
                    t.setText("Original: " + aComprimir + "\n\n" + "Comprimida: " + c.comprimir());

                    Snackbar.make(view, "String Comprimida com sucesso!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
