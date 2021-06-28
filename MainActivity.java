package com.example.retrofitimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView ivCategory;
    TextView tvCatId, tvCatName, tvIcon, tvError;
    APIInterface apiInterface;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<TestModel> call = apiInterface.getCategory();

        call.enqueue(new Callback<TestModel>() {
            @Override
            public void onResponse(Call<TestModel> call, Response<TestModel> response) {

                Log.d("BHAV", response.body().toString());



            }

            @Override
            public void onFailure(Call<TestModel> call, Throwable t) {

                tvError.setText(t.getMessage());
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
    public void init()
    {
        ivCategory = findViewById(R.id.ivCategory);
        tvCatId = findViewById(R.id.tvCatId);
        tvCatName = findViewById(R.id.tvCatName);
        tvIcon = findViewById(R.id.tvIcon);
        tvError = findViewById(R.id.tvError);
    }
}
