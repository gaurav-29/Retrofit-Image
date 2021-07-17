package com.example.retrofitimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recCategory;
    APIInterface apiInterface;
    Context ctx = this;
    ArrayList<TestModel.Category> CategoryList = new ArrayList<>();
    CategoryAdapter mAdapter;


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

                ArrayList<TestModel.Category> CategoryList = res.data.get(0).Category;

//                for(int i=0; i<CategoryList.size();i++)
//                    tvCatId.append(" Id:"+CategoryList.get(i).CatId+ "\n Name :"+CategoryList.get(i).CategoryName+
//                            "\n Icon :"+CategoryList.get(i).Icon + "\n\n\n");

                mAdapter = new CategoryAdapter(CategoryList, ctx);
                recCategory.setLayoutManager(new GridLayoutManager(ctx,1));
                recCategory.setItemAnimator(new DefaultItemAnimator());
                recCategory.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<TestModel> call, Throwable t) {

                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
    public void init()
    {
        recCategory = findViewById(R.id.recCategory);
    }
}
