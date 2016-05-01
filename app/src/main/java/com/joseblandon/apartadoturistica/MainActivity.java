package com.joseblandon.apartadoturistica;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] opciones;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private ActionBarDrawerToggle drawerToggle;


    private CharSequence tituloSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new InicioFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
//indicamos que se va comenzar una transaccion para colocar dentro del contenedor de frame el Fragment
// que nosotros queremos. y usamos el metodo commit para actualizar el estado

        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();

        opciones= new String[] {"Inicio","Hoteles","Sitios Turisticos","Bares","Información Demografica"};
        drawerLayout= (DrawerLayout) findViewById(R.id.contenedorPrincipal);
        listView = (ListView) findViewById(R.id.menuIzq);

        listView.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(), android.R.layout.simple_list_item_1, opciones));
        final ActionBar ab = getSupportActionBar();
        if (ab !=null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new InicioFragment();
                        break;
                    case 1:
                        fragment = new HotelesFragment();
                        break;
                    case 2:
                        fragment = new SitiosFragment();
                        break;
                    case 3:
                        fragment = new BaresFragment();
                        break;
                    case 4:
                        fragment = new InfoFragment();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
//indicamos que se va comenzar una transaccion para colocar dentro del contenedor de frame el Fragment
// que nosotros queremos. y usamos el metodo commit para actualizar el estado

                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                listView.setItemChecked(position, true);
                tituloSec = opciones[position];
                ab.setTitle(tituloSec);
                drawerLayout.closeDrawer(listView);
            }
            });

            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                                                     R.drawable.ic_menu_white_24dp,R.string.abierto,R.string.cerrado);

            drawerLayout.setDrawerListener(drawerToggle);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case android.R.id.home:
                    drawerLayout.openDrawer(GravityCompat.START);
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

        public void mapsOasis (View v){
            Intent i=new Intent(this,OasisActivity.class);
            startActivity(i);
        }
        public void mapsEncuentros (View v){
            Intent i=new Intent(this,EncuentrosMaps.class);
            startActivity(i);
        }
        public void mapsZungo (View v){
            Intent i=new Intent(this,ZungoMaps.class);
            startActivity(i);
        }
        public void mapsPampa (View v){
            Intent i=new Intent(this,PampaMaps.class);
            startActivity(i);
        }

        public void mapsBarbacoa (View v){
            Intent i=new Intent(this,BarbacoaMaps.class);
            startActivity(i);
        }
        public void mapsKiwi (View v){
            Intent i=new Intent(this,KiwiMaps.class);
            startActivity(i);
        }
        public void mapsDigmaran (View v){
            Intent i=new Intent(this,DigmaranMaps.class);
            startActivity(i);
        }
        public void mapsEstaciones (View v){
            Intent i=new Intent(this,EstacionesMaps.class);
            startActivity(i);
        }

        public void mapsWilliam (View v){
            Intent i=new Intent(this,WilliamMaps.class);
            startActivity(i);
        }
        public void mapsApartado (View v){
            Intent i=new Intent(this,ApartadoMaps.class);
            startActivity(i);
        }

    }

