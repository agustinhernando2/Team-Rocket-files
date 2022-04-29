package teamrocket.org.electronicadigital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Map;

import teamrocket.org.electronicadigital.H1Calculators.CalculatorMenuFragment;
import teamrocket.org.electronicadigital.H2ColorCodeResistors.ColorCodeResistorsToolFragment;
import teamrocket.org.electronicadigital.H3LogicFunctions.LogicFunctionsMenuFragment;
import teamrocket.org.electronicadigital.H4Karnaugh.KarnaughToolFragment;
import teamrocket.org.electronicadigital.H5Datasheets.DatasheetsToolFragment;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private static final Map<Integer, Fragment> FRAGMENT_GETTER;

    static {
        FRAGMENT_GETTER = new HashMap() {{
            put(R.id.start, new MainFragment());
            put(R.id.calculators, new CalculatorMenuFragment());
            put(R.id.resistorColorCode, new InstructionsFragment("Código de colores de resistencias",
                    "En esta herramienta usted podrá ingresar las bandas de colores de una resistencia para conocer su valoro bien ingresar un valor para conocer las bandas correctas",
                    new ColorCodeResistorsToolFragment()));
            put(R.id.logicFunctions, new LogicFunctionsMenuFragment());
            put(R.id.karnaugh, new InstructionsFragment("Mapas de Karnaugh",
                    "Esta herramienta le permitirá reducir funciones lógicas al igual que lo haría\n" +
                            "con un mapa de Karnaugh. Para poder implementarlo computacionalmente se emplearán los algorítmos de Quine-McCliskey y Petrick.\\n\n" +
                            "El usuario podrá optar por resolver su simplificación por cualquiera de estos algorítmos",
                    new KarnaughToolFragment()));
            put(R.id.datasheets, new InstructionsFragment("Datasheets",
                    "En esta sección usted encontrará acceso a las DataSheet de los chips más utilizados en la materia Electrónica digital 1",
                    new DatasheetsToolFragment()));
        }};
    }

    private DrawerLayout drawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MainFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, FRAGMENT_GETTER.get(item.getItemId())).commit();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if(fragment instanceof MainFragment){
                super.onBackPressed();
                return;
            } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MainFragment()).commit();
            }
        }
    }

}