package com.project.cancha.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.cancha.R;
import com.project.cancha.model.Jugador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormacionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FormacionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FormacionFragment newInstance(String param1, String param2) {
        FormacionFragment fragment = new FormacionFragment();
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
    TextView j11,j12,j13,j14,j15,j21,j22,j23,j24,j25;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_formacion, container, false);

        j11 = vista.findViewById(R.id.j11);
        j12 = vista.findViewById(R.id.j12);
        j13 = vista.findViewById(R.id.j13);
        j14 = vista.findViewById(R.id.j14);
        j15 = vista.findViewById(R.id.j15);

        j21 = vista.findViewById(R.id.j21);
        j22 = vista.findViewById(R.id.j22);
        j23 = vista.findViewById(R.id.j23);
        j24 = vista.findViewById(R.id.j24);
        j25 = vista.findViewById(R.id.j25);

        ArrayList<Jugador> equipo1 = (ArrayList<Jugador>) getArguments().getSerializable("equipo1");
        ArrayList<Jugador> equipo2 = (ArrayList<Jugador>) getArguments().getSerializable("equipo2");

        j11.setText(equipo1.get(0).getNombre());
        j12.setText(equipo1.get(1).getNombre());
        j13.setText(equipo1.get(2).getNombre());
        j14.setText(equipo1.get(3).getNombre());
        j15.setText(equipo1.get(4).getNombre());

        j21.setText(equipo2.get(0).getNombre());
        j22.setText(equipo2.get(1).getNombre());
        j23.setText(equipo2.get(2).getNombre());
        j24.setText(equipo2.get(3).getNombre());
        j25.setText(equipo2.get(4).getNombre());

        return vista;
    }
}
