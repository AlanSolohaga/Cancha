package com.project.cancha.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.cancha.R;
import com.project.cancha.model.Turno;

import java.util.ArrayList;

public class ListaTurnosAdaptador extends RecyclerView.Adapter<ListaTurnosAdaptador.ViewHolderTurnos>
        implements View.OnClickListener {

    View.OnClickListener listener;
    ArrayList<Turno> turnos;

    public ListaTurnosAdaptador(ArrayList<Turno> turnos) {
        this.turnos = turnos;
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
    public ViewHolderTurnos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_turnos,null,false);
        view.setOnClickListener(this);
        return new ViewHolderTurnos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaTurnosAdaptador.ViewHolderTurnos holder, int position) {
        holder.turno.setText(turnos.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        if(turnos !=null){
            return turnos.size();
        }else{
            return 0;
        }
    }

    public class ViewHolderTurnos extends RecyclerView.ViewHolder {
        TextView turno;
        public ViewHolderTurnos(@NonNull View itemView) {
            super(itemView);
            turno = itemView.findViewById(R.id.txtTurno);
        }
    }
}
