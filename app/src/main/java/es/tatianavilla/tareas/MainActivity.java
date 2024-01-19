package es.tatianavilla.tareas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mas ){
            final EditText taskEditText = new EditText(this);
            AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle("Nueva tarea")
            .setMessage("¿Que quieres hacer a continuación?")
            .setView(taskEditText)
            .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // añadir tarea a base de datos
                }
            })
            .setNegativeButton("Cancelar", null)
            .create();
            dialog.show();

            return true;
        } else if (item.getItemId() == R.id.logout ) {
            // Cerramos la sesion, volvemos a la actividad de login
            startActivity(new Intent(MainActivity.this,Login.class));
            return true;
        } else return super.onOptionsItemSelected(item);

    }
}