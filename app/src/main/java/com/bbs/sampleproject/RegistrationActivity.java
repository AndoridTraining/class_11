package com.bbs.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bbs.sampleproject.database.AppDao;
import com.bbs.sampleproject.database.AppDatabase;
import com.bbs.sampleproject.database.AppEntity;

public class RegistrationActivity extends AppCompatActivity {

    EditText name_et, password_et, phone_et, email_et, organization_et, position_et;
    Button reg_bt;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initVariables();

        reg_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegistrationActivity.this, "Saving...", Toast.LENGTH_SHORT).show();
                saveAtRoomDB();
            }
        });
    }

    private void saveAtRoomDB(){
        AppDao appDao = db.appDao();
        AppEntity appEntity = new AppEntity(
                name_et.getText().toString().trim(),
                password_et.getText().toString().trim(),
                phone_et.getText().toString().trim());

        AsyncTask.execute(()->
                appDao.insertAll(appEntity)
                );
    }

    private void initVariables() {
        name_et = findViewById(R.id.name_et);
        password_et = findViewById(R.id.password_et);
        phone_et = findViewById(R.id.phone_et);
        email_et = findViewById(R.id.email_et);
        organization_et = findViewById(R.id.organization_et);
        position_et = findViewById(R.id.position_et);
        reg_bt = findViewById(R.id.reg_bt);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "appDatabase")
                .fallbackToDestructiveMigration()
                .build();
    }
}