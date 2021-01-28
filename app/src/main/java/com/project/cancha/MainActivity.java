package com.project.cancha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.project.cancha.adaptador.ListaCanchasAdaptador;
import com.project.cancha.interfaz.IComunicaFragments;
import com.project.cancha.model.Equipo;
import com.project.cancha.model.Jugador;
import com.project.cancha.vista.ContactoFragment;
import com.project.cancha.vista.EquiposFragment;
import com.project.cancha.vista.FormacionFragment;
import com.project.cancha.vista.ListaCanchasFragment;
import com.project.cancha.vista.MenuFragment;
import com.project.cancha.vista.TurnosFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IComunicaFragments {
    FragmentTransaction fragmentTransaction;
    ListaCanchasFragment listaCanchasFragment;
    MenuFragment menu;
    EquiposFragment equiposFragment;
    ContactoFragment contactoFragment;
    TurnosFragment turnosFragment;
    FormacionFragment formacionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** INSTANCIO EL FRAGMENT MENU Y LO ASIGNO AL CONTENEDOR DEL MAIN PRINCIPAL**/
        menu = new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,menu).commit();
    }

    @Override
    public void mostrarFragment(int id) {
        switch (id){
            case 1:
                listaCanchasFragment = new ListaCanchasFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, listaCanchasFragment);
                break;
            case 2:
                equiposFragment = new EquiposFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, equiposFragment);

                break;
            case 3:
                contactoFragment = new ContactoFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, contactoFragment);
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void mostrarTurnos(int id) {
        Bundle objEnviado = new Bundle();
        objEnviado.putInt("id",id);
        turnosFragment = new TurnosFragment();
        turnosFragment.setArguments(objEnviado);
        fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, turnosFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void llevarEquipos(ArrayList<Jugador> equipo1, ArrayList<Jugador> equipo2) {
        Bundle objEnviado = new Bundle();
        //objEnviado.putParcelableArrayList("equipo1", (ArrayList<? extends Parcelable>) equipo1);
        //objEnviado.putParcelableArrayList("equipo2", (ArrayList<? extends Parcelable>) equipo2);
        objEnviado.putSerializable("equipo1",equipo1);
        objEnviado.putSerializable("equipo2",equipo2);

        /*
        formacionFragment = new FormacionFragment();
        formacionFragment.setArguments(objEnviado);
        fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, formacionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
         */

        formacionFragment = new FormacionFragment();
        formacionFragment.setArguments(objEnviado);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(equiposFragment).add(R.id.contenedor,formacionFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
