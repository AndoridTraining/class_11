package com.bbs.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;

import com.bbs.sampleproject.adapter.ViewAllUserInfo;
import com.bbs.sampleproject.database.AppDatabase;
import com.bbs.sampleproject.database.AppEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ViewAllUserListActivity extends AppCompatActivity {

    AppDatabase db;
    List<AppEntity> userList;
    RecyclerView user_list_view;
    ViewAllUserInfo adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_user_list);

        user_list_view = findViewById(R.id.user_list_view);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "appDatabase")
                .fallbackToDestructiveMigration()
                .build();

        try {
            readData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void readData() throws
            ExecutionException, InterruptedException{
        userList = getAllUser();
        //adding all user information into the recycler list view
        adapter = new ViewAllUserInfo(this, userList);
        user_list_view.setAdapter(adapter);
        user_list_view.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<AppEntity> getAllUser() throws
            ExecutionException, InterruptedException{
        return new GetUserAsyncTask().execute().get();
    }

    private class GetUserAsyncTask extends AsyncTask<Void, Void,List<AppEntity>>{

        @Override
        protected List<AppEntity> doInBackground(Void... voids) {
            return db.appDao().getAll();
        }
    }
}