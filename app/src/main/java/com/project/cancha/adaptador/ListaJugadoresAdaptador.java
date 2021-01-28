package com.project.cancha.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.cancha.R;
import com.project.cancha.model.Jugador;
import com.project.cancha.model.NivelJugador;
import java.util.ArrayList;

public class ListaJugadoresAdaptador extends RecyclerView.Adapter<ListaJugadoresAdaptador.ViewHolderEquipos>
        implements View.OnClickListener {

    View.OnClickListener listener;
    ArrayList<Jugador> jugadores;

    public ListaJugadoresAdaptador(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public ListaJugadoresAdaptador.ViewHolderEquipos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_jugador,null,false);
        v.setOnClickListener(this);

        return new ViewHolderEquipos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaJugadoresAdaptador.ViewHolderEquipos holder, int position) {
        holder.etiNombre.setText(jugadores.get(position).getNombre());
        if(jugadores.get(position).getNivelJugador()== NivelJugador.MALO){
            holder.image1.setImageResource(R.drawable.pelota);
            //holder.image2.setImageResource(R.drawable.pelotaroja);
            //holder.image3.setImageResource(R.drawable.pelotaroja);
        }

        if(jugadores.get(position).getNivelJugador()== NivelJugador.BUENO){
            holder.image1.setImageResource(R.drawable.pelota);
            holder.image2.setImageResource(R.drawable.pelota);
            //holder.image3.setImageResource(R.drawable.pelotaroja);
        }

        if(jugadores.get(position).getNivelJugador()== NivelJugador.EXCELENTE){
            holder.image1.setImageResource(R.drawable.pelota);
            holder.image2.setImageResource(R.drawable.pelota);
            holder.image3.setImageResource(R.drawable.pelota);
        }
    }

    @Override
    public int getItemCount() {
        if(jugadores!=null){
            return jugadores.size();
        }else{
            return 0;
        }
    }

    public class ViewHolderEquipos extends RecyclerView.ViewHolder {
        TextView etiNombre;
        ImageView image1,image2,image3;
        public ViewHolderEquipos(@NonNull View itemView) {
            super(itemView);
            etiNombre = itemView.findViewById(R.id.ediNombre);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
        }
    }
}
