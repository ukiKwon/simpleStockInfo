package com.uki.ssi;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    FragmentHome fragmentItem1;
    FragmentInterest fragmentItem2;
    FragmentGraph fragmentItem3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentItem1).commit();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentItem2).commit();
                    return true;
                case R.id.navigation_graph:
                    mTextMessage.setText(R.string.title_graph);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentItem3).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Fragment
        fragmentItem1 = new FragmentHome();
        fragmentItem2 = new FragmentInterest();
        fragmentItem3 = new FragmentGraph();
        //
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentItem1).commit();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
