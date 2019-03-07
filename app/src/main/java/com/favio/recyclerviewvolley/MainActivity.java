package com.favio.recyclerviewvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.favio.recyclerviewvolley.adaptadores.AdaptadorPersona;
import com.favio.recyclerviewvolley.modelos.Persona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_listaPersonas;
    AdaptadorPersona adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_listaPersonas=(RecyclerView) findViewById(R.id.rv_listaPersonas);
    }

    public void onClick(View v){

        JsonArrayRequest peticion=new JsonArrayRequest(
                Request.Method.GET,
                "http://nuevo.rnrsiilge-org.mx/lista",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //for (int i=0; i<response.length(); i++) {
                        try {
                            //personas.add(new List<Persona>(response.getJSONObejct(i)));

                            Gson gson = new Gson();

                            Type listType=new TypeToken<List<Persona>>(){}.getType();
                            List<Persona> personas=gson.fromJson(response.toString(), listType);

                            adaptador=new AdaptadorPersona(personas);

                            rv_listaPersonas.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            rv_listaPersonas.setAdapter(adaptador);


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //}
                        Log.d("valor", response.toString());
                        //txtv_nombre.setText(personas.get(4).getNombre());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        VolleyS.getInstance(this).getRequestQueue().add(peticion);

    }
}
