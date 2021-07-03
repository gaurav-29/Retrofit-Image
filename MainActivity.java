package com.example.retrofitimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

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

                TestModel res = response.body();

                List<TestModel.Data> Datalist = res.data;

                String catid, catname, icon;
                for (int i=0;i<Datalist.size();i++)
                {
                    catid = Datalist.get(i).Category.get(i);
                }


//                String catid = response.body().data.get(0).Category.get(0).CatId;
//                String catname = response.body().data.get(0).Category.get(0).CategoryName;
//                String icon = response.body().data.get(0).Category.get(0).Icon;
//
//                tvCatId.setText(catid);
//                tvCatName.setText(catname);
//
//                Glide.with(ctx).load(icon).into(ivCategory);
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
