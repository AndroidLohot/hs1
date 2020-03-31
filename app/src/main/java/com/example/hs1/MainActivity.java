package com.example.hs1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hs1.fragments_container.bnb_container.BNB_Andadaje;
import com.example.hs1.fragments_container.bnb_container.BNB_Bazar;
import com.example.hs1.fragments_container.bnb_container.BNB_Home;
import com.example.hs1.fragments_container.bnb_container.BNB_Par;
import com.example.hs1.fragments_container.bnb_container.BNB_SDG;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Home");

        bottomView=(BottomNavigationView)findViewById(R.id.bnb);

        bottomView.setOnNavigationItemSelectedListener(nl);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BNB_Home()).commit();


    }
    private BottomNavigationView.OnNavigationItemSelectedListener nl=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selctedFragment=null;

            switch (item.getItemId())
            {
                case R.id.bHome:
                    getSupportActionBar().setTitle("Home");
                    SelectedFragment(new BNB_Home());
                    break;
                case R.id.bBajar:
                    getSupportActionBar().setTitle("Bazar");
                    SelectedFragment(new BNB_Bazar());
                    break;
                case R.id.bSevaDeneGhene:
                    getSupportActionBar().setTitle("SDG");
                    SelectedFragment(new BNB_SDG());
                    break;
                case R.id.bAndaje:
                    getSupportActionBar().setTitle("Andaje");
                    SelectedFragment(new BNB_Andadaje());
                    break;
                case R.id.bPar:
                    getSupportActionBar().setTitle("Par");
                    SelectedFragment(new BNB_Par());
                    break;
            }

            return true;
        }
    };




    private void SelectedFragment(Fragment fragment)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment_container,fragment).commit();
    }
}
