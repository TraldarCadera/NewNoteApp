package com.example.newnoteapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new NoteListFragment(), "NoteListFragment")
                .addToBackStack(null)
                .commit();
        Toolbar toolbar = findViewById(R.id.toolbar_main);

        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_new_note) {

                if (getResources().getBoolean(R.bool.isLandscape)) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_right, new NoteCreationFragment(), "NoteCreationFragment")
                            .addToBackStack(null)
                            .commit();

                    Toast.makeText(MainActivity.this, "New note", Toast.LENGTH_SHORT).show();
                    return true;

                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, new NoteCreationFragment(), "NoteCreationFragment")
                            .addToBackStack(null)
                            .commit();

                    Toast.makeText(MainActivity.this, "New note", Toast.LENGTH_SHORT).show();
                    return true;
                }
            }


            if (item.getItemId() == R.id.action_setting) {
                Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;

        });

    }
}