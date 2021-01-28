package com.project.cancha.vista;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.cancha.R;
import com.project.cancha.adaptador.ListaJugadoresAdaptador;
import com.project.cancha.interfaz.IComunicaFragments;
import com.project.cancha.interfaz.IEquiposVista;
import com.project.cancha.interfaz.IPresentEquipos;
import com.project.cancha.model.Equipo;
import com.project.cancha.model.Jugador;
import com.project.cancha.model.NivelJugador;
import com.project.cancha.present.PresentEquipos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EquiposFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EquiposFragment extends Fragment implements IEquiposVista {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    IPresentEquipos presentador;

    public EquiposFragment() {
        // Required empty public constructor
        presentador = new PresentEquipos(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EquiposFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EquiposFragment newInstance(String param1, String param2) {
        EquiposFragment fragment = new EquiposFragment();
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
    EditText nombre;
    Button btnAgregar,btnAleatorio,btnCalidad;
    RecyclerView recyclerJugadores;
    Spinner spinner;
    ArrayList<Jugador> jugadores;
    ListaJugadoresAdaptador adaptador;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_equipos, container, false);
        declaracionDeVariables(vista);

        jugadores = new ArrayList<>();
        adaptador = new ListaJugadoresAdaptador(jugadores);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jugadores.remove(recyclerJugadores.getChildAdapterPosition(v));
                adaptador.notifyItemRemoved(recyclerJugadores.getChildAdapterPosition(v));
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jugadores.size()<10){
                    Jugador jugador = new Jugador(nombre.getText().toString(),(NivelJugador) spinner.getSelectedItem());
                    jugadores.add(jugador);
                    recyclerJugadores.setAdapter(adaptador);
                    nombre.setText("");
                }else{
                    Toast.makeText(getContext(), "NO PUEDE AGREGAR MÁS DE 10 JUGADORES", Toast.LENGTH_LONG).show();
                    nombre.setText("");
                }

            }
        });

        btnAleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formaAleatoria();
            }
        });

        btnCalidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formaCalidad();
            }
        });

        return vista;
    }

    private void declaracionDeVariables(View vista) {
        nombre = vista.findViewById(R.id.nombre);
        btnAleatorio = vista.findViewById(R.id.btnAleatorio);
        btnCalidad = vista.findViewById(R.id.btnCalidad);
        btnAgregar = vista.findViewById(R.id.btnAgregar);

        recyclerJugadores = vista.findViewById(R.id.recyclerJugadores);
        recyclerJugadores.setLayoutManager(new GridLayoutManager(vista.getContext(),1));


        spinner = vista.findViewById(R.id.spinner);
        List<NivelJugador> calidad = Arrays.asList(NivelJugador.EXCELENTE,NivelJugador.BUENO,NivelJugador.MALO);
        ArrayAdapter<NivelJugador> adapterSpinner = new ArrayAdapter<NivelJugador>(vista.getContext(),
                android.R.layout.simple_spinner_item,calidad);
        spinner.setAdapter(adapterSpinner);
    }

    private void formaAleatoria() {
        boolean[] repetido = {false,false,false,false,false,
                false,false,false,false,false};
        Random random = new Random();
        int[] pos = {0,1,2,3,4,5,6,7,8,9};
        int contador = 0;
        ArrayList<Jugador> equipo1 = new ArrayList<>();
        ArrayList<Jugador> equipo2 = new ArrayList<>();

        while(contador!=10){
            int valor = random.nextInt(pos.length);

            if(repetido[valor] == false && contador%2==0){
                repetido[valor] =true;
                equipo2.add(jugadores.get(valor));
                contador++;
            }else{
                if(repetido[valor] == false && contador%2!=0){
                    repetido[valor] =true;
                    equipo1.add(jugadores.get(valor));
                    contador++;
                }
            }
        }
        comunicaFragments.llevarEquipos(equipo1,equipo2);
    }

    private void formaCalidad() {
        //ORDENO DEL PEOR AL MEJOR
        Collections.sort(jugadores);

        ArrayList<Jugador> equipo1 = new ArrayList<>();
        ArrayList<Jugador> equipo2 = new ArrayList<>();
        int contador = 0;
        while(contador<10){
            if(contador%2==0){
                equipo2.add(jugadores.get(contador));
                contador++;
            }else{
                if(contador%2!=0){
                    equipo1.add(jugadores.get(contador));
                    contador++;
                }
            }
        }

        comunicaFragments.llevarEquipos(equipo1,equipo2);
    }

    Activity activity;
    IComunicaFragments comunicaFragments;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            activity = (Activity) context;
            comunicaFragments = (IComunicaFragments) activity;
        }
    }
}
