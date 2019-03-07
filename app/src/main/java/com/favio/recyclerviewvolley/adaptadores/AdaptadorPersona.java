package com.favio.recyclerviewvolley.adaptadores;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.favio.recyclerviewvolley.R;
import com.favio.recyclerviewvolley.modelos.Persona;

import java.util.List;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.ViewHolder> {

    List<Persona> listaPersonas;

    public AdaptadorPersona(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @NonNull
    @Override
    public AdaptadorPersona.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersona.ViewHolder holder, final int position) {

        holder.tv_nombre.setText(listaPersonas.get(position).getNombre());
        holder.tv_apellido.setText(listaPersonas.get(position).getApellido());
        holder.tv_edad.setText(listaPersonas.get(position).getEdad().toString());
        holder.tv_telefono.setText(listaPersonas.get(position).getTelefono());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itt = new Intent(Intent.ACTION_CALL);
                itt.setData(Uri.parse("tel: " + listaPersonas.get(position).getTelefono()));
                if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                v.getContext().startActivity(itt);

                //Toast.makeText(v.getContext(), listaPersonas.get(position).getTelefono(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nombre, tv_apellido, tv_edad, tv_telefono;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            tv_apellido = (TextView) itemView.findViewById(R.id.tv_apellido);
            tv_edad = (TextView) itemView.findViewById(R.id.tv_edad);
            tv_telefono = (TextView) itemView.findViewById(R.id.tv_telefono);
        }
    }
}
