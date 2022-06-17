package org.team_rocket_unc.electronica_digital_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Map;

import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.CalculatorMenuFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ColorCodeResistorsToolFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.LogicFunctionsMenuFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh.KarnaughToolFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_5_datasheets.DatasheetsToolFragment;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private Map<Integer, Fragment> fragmentGetter;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        fragmentGetter = new HashMap<Integer, Fragment>() {{
            put(R.id.start, new MainFragment());
            put(R.id.calculators, new CalculatorMenuFragment());
            put(R.id.resistorColorCode, new InstructionsFragment(getString(R.string.u2_p1_color_title),
                    getString(R.string.u2_p1_color_instructions),
                    new ColorCodeResistorsToolFragment()));
            put(R.id.logicFunctions, new LogicFunctionsMenuFragment());
            put(R.id.karnaugh, new InstructionsFragment(getString(R.string.u4_p1_karnaugh_title),
                    getString(R.string.u4_p1_karnaugh_instructions),
                    new KarnaughToolFragment()));
            put(R.id.datasheets, new InstructionsFragment(getString(R.string.u5_p1_datasheets_title),
                    getString(R.string.u5_p1_datasheets_instructions),
                    new DatasheetsToolFragment()));
        }};

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer, toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MainFragment()).commit();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmentGetter.get(item.getItemId()))
                .addToBackStack(null)
                .commit();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
        else {
            getFragmentManager().popBackStack();
        }
    }

}