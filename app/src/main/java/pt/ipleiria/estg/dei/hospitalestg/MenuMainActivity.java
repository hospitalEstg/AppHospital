package pt.ipleiria.estg.dei.hospitalestg;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import pt.ipleiria.estg.dei.hospitalestg.modelo.Consulta;


public class MenuMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
   private NavigationView navigationView;
    private DrawerLayout drawer;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawer.addDrawerListener(toggle);
       navigationView.setNavigationItemSelectedListener(this);


        carregarCabeçalho();
        fragmentManager = getSupportFragmentManager();

        carregarFragmentoInicial();
    }

    private void carregarFragmentoInicial(){
        Fragment fragment = new ConsultasFragment();
        setTitle(navigationView.getMenu().getItem(0).getTitle());
        navigationView.setCheckedItem(R.id.nav_Homepage);
        fragmentManager.beginTransaction().replace(R.id.contentFragment, fragment).commit();

    }

    private void carregarCabeçalho() {
       View hView = navigationView.getHeaderView(0);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch(menuItem.getItemId()) {
            case R.id.nav_Consulta:
                fragment = new ConsultasFragment();
                setTitle(menuItem.getTitle());
                Toast.makeText(getApplicationContext(),"hora", Toast.LENGTH_SHORT).show();
                break;
            default:
                fragment= new ConsultasFragment();

        }

        if (fragment != null) {
            fragmentManager.beginTransaction().replace(R.id.contentFragment, fragment).commit();
        }
        drawer.closeDrawer(GravityCompat.START); //FECHAR AO CLICAR NUM ITEM NO MENU

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
