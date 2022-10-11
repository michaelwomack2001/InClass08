package com.example.group4_inclass8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragmentContainerView, new contactListFragment());
        ft.commit();
    }

    public void setFragment(AppCompatActivity activity, Fragment fragment){
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
    }

    public void switchFragment(View view){
        Fragment newFragment = null;

        switch (view.getId()){
            case R.id.cancel:
            case R.id.addBtn:
            case R.id.delBtn:
                newFragment = new viewContactFragment();
            default:
                break;
        }
        setFragment(this, newFragment);
    }
}