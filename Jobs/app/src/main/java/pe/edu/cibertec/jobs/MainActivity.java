package pe.edu.cibertec.jobs;


import android.app.Activity;
import android.arch.persistence.room.Database;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText etJob;
    Button btSearch;
    TextView tvTitle, tvCompany, tvDecription;
    ImageView ivLogo;
    List<Job> items;
    JobAdapter jobadapter;
    RecyclerView rvJobs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etJob = findViewById(R.id.etJob);
        btSearch = findViewById(R.id.btSearch);
       /* tvTitle = findViewById(R.id.tvTitle);
        tvCompany = findViewById(R.id.tvCompany);
        tvDecription = findViewById(R.id.tvDescription);
        ivLogo = findViewById(R.id.ivLogo);*/
        rvJobs = findViewById(R.id.rvJobs);

        btSearch.setOnClickListener(this);
    }


    @Override
    public void onClick(final View v) {

        String input = etJob.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                // retrofit es un servicio web  para llamar http , manejo de hilos
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JobInterface jobInterface = retrofit.create(JobInterface.class);

        Call<List<Job>> searchMethod = jobInterface.searchJobs(etJob.getText().toString());
        searchMethod.enqueue(new Callback<List<Job>>() {
            @Override
            public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                //pbLoad.setVisibility(View.GONE);

                if (response.isSuccessful()) {

                    items = response.body();
                    jobadapter = new JobAdapter(items);

                    rvJobs.setAdapter(jobadapter);
                    rvJobs.setLayoutManager(new LinearLayoutManager(v.getContext()));
                }
            }

            @Override
            public void onFailure(Call<List<Job>> call, Throwable t) {
                Log.e("Error",t.toString());

            }
        });

    }
}


