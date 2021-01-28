package com.project.cancha.vista;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.project.cancha.R;
import com.project.cancha.adaptador.ListaCanchasAdaptador;
import com.project.cancha.interfaz.IComunicaFragments;
import com.project.cancha.model.Cancha;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaCanchasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaCanchasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaCanchasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaCanchasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaCanchasFragment newInstance(String param1, String param2) {
        ListaCanchasFragment fragment = new ListaCanchasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView recyclerCanchas;
    ListaCanchasAdaptador adaptador;

    Activity activity;
    IComunicaFragments comunicaFragments;
    ArrayList<Cancha> canchas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_canchas, container, false);
        recyclerCanchas = view.findViewById(R.id.recyclerCanchas);
        recyclerCanchas.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        adaptador = new ListaCanchasAdaptador(listacanchas());
        recyclerCanchas.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Mandar id del recicler seleccionado
                comunicaFragments.mostrarTurnos(canchas.get(recyclerCanchas.getChildAdapterPosition(v)).getId());
            }
        });

        return view;
    }

    private ArrayList<Cancha> listacanchas() {
        canchas = new ArrayList<>();
        for (int i = 0; i < 6 ; i++) {
            String nombre = "CANCHA "+i;
            Cancha cancha = new Cancha(i,nombre);
            canchas.add(cancha);
        }
        return canchas;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            activity = (Activity) context;
            comunicaFragments = (IComunicaFragments) activity;
        }
    }
}
