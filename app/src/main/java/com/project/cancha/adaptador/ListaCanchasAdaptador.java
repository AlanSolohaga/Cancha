package com.project.cancha.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.cancha.R;
import com.project.cancha.model.Cancha;
import java.util.ArrayList;

public class ListaCanchasAdaptador extends RecyclerView.Adapter<ListaCanchasAdaptador.ViewHolderCanchas>
        implements View.OnClickListener{

    View.OnClickListener listener;
    ArrayList<Cancha> canchas;

    public ListaCanchasAdaptador(ArrayList<Cancha> canchas) {
        this.canchas = canchas;
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
    public ViewHolderCanchas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_canchas,null,false);

        view.setOnClickListener(this);

        return new ViewHolderCanchas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCanchas holder, int position) {
        holder.nombreCancha.setText(canchas.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        if(canchas!=null){
            return canchas.size();
        }else{
            return 0;
        }

    }

    public class ViewHolderCanchas extends RecyclerView.ViewHolder {
        TextView nombreCancha;
        public ViewHolderCanchas(@NonNull View itemView) {
            super(itemView);
            nombreCancha = itemView.findViewById(R.id.nombreCancha);
        }
    }
}
