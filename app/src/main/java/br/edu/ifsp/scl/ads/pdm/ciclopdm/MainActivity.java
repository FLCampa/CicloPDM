package br.edu.ifsp.scl.ads.pdm.ciclopdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.edu.ifsp.scl.ads.pdm.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Constante de filtro do LogCat
    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";

    //Constante de dados de instancia
    private final String TELEFONE = "TELEFONE";

    private ActivityMainBinding activityMainBinding;

    //Views dinamicas
    private TextView telefoneTv;
    private EditText telefoneEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //Views dinamicas
        telefoneTv = new TextView(this);
        //telefoneTv.setText(getString(R.string.telefone));
        telefoneTv.setText(R.string.telefone);
        telefoneEt = new EditText(this);
        telefoneEt.setInputType(InputType.TYPE_CLASS_PHONE);

        //Adicinando views dinamicas ao layout
        activityMainBinding.linearLayout.addView(telefoneTv);
        activityMainBinding.linearLayout.addView(telefoneEt);

        Log.v(CICLO_PDM_TAG, getString(R.string.onCreateMsg));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { //na prox exec vai pro onCreate
        super.onSaveInstanceState(outState);
        //Salvando dados de instancia (dinamico)
        outState.putString(TELEFONE, telefoneEt.getText().toString()); //chave pode ser definida no strings
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        telefoneEt.setText(savedInstanceState.getString(TELEFONE, "")); //(se existe, se n existe)
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.v(CICLO_PDM_TAG, "onStart: Iniciando ciclo Visível");
        Log.v(CICLO_PDM_TAG, getString(R.string.onStartMsg));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(CICLO_PDM_TAG, getString(R.string.onResumeMsg));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(CICLO_PDM_TAG, getString(R.string.onPauseMsg));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CICLO_PDM_TAG, getString(R.string.onStopMsg));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(CICLO_PDM_TAG, getString(R.string.onDestroyMsg));
    }

    //Opcional
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(CICLO_PDM_TAG, getString(R.string.onRestartMsg));
    }

}