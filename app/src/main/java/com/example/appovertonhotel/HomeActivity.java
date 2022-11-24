package com.example.appovertonhotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toolbar;

import com.example.appovertonhotel.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    //private Toolbar toolbar;

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment( new HospedajeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.hospedaje:
                    replaceFragment( new HospedajeFragment());
                    break;
                case R.id.calendario:
                    replaceFragment(new CalendarFragment());
                    break;
                case R.id.promocion:
                    replaceFragment(new PromoFragment());
                    break;
                case R.id.favorito:
                    replaceFragment(new FavoritoFragment());
                    break;
            }
            return true;
        });

        /*toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);*/
    }

    /**private void setSupportActionBar(Toolbar toolbar) {
    }*/

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}