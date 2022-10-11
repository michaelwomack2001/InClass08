package com.example.group4_inclass8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private final OkHttpClient client = new OkHttpClient();
    final String TAG = "contacts";
    String name, email, phone, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request
        getContactList();

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

    public void getContactList(){

        HttpUrl url = HttpUrl.parse("https://www.theappsdr.com/contacts/json").newBuilder()
                .addQueryParameter("name", name)
                .addQueryParameter("email", email)
                .addQueryParameter("phone", phone)
                .addQueryParameter("type", type)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    Log.d(TAG, "onResponse" + responseBody.string());

                }
            }
        });
    }

    public void populateList(ResponseBody response){
        for(int i = 0; i < response.contentLength(); i++){

        }
    }
}