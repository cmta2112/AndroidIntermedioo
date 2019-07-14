package pe.edu.cibertec.favouritemovies;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    TextInputEditText etMovie;
    Button btSearch;
    TextView tvTitle, tvYear, tvPlot;
    ImageButton btFavorite;
    RecyclerView rvJobs;
    //JobAdapter adapter;
    ProgressBar pbLoad;
    List<Movie> items;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etMovie = view.findViewById(R.id.etMovie);
        btSearch = view.findViewById(R.id.btSearch);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvYear = view.findViewById(R.id.tvYear);
        tvPlot = view.findViewById(R.id.tvPlot);
        btFavorite = view.findViewById(R.id.btFavorite);

        //rvJobs = view.findViewById(R.id.rvJobs);
        //pbLoad = view.findViewById(R.id.pbLoad);

      //  pbLoad.setVisibility(View.GONE);

        btSearch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = etMovie.getText().toString();
                String apikey = "6fc43ba7";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.omdbapi.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                MovieInterface movieInterface = retrofit.create(MovieInterface.class);
                Call<Movie> methodSearch = movieInterface.searchMovie(apikey,name);

                methodSearch.enqueue(new Callback<Movie>() {


                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        if (response.isSuccessful()) {
                            Movie movie = response.body();

                            tvTitle.setText(movie.getTitle());
                            tvYear.setText(movie.getYear());
                            tvPlot.setText(movie.getPlot());
                        }
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {

                        Log.e("Error",t.toString());
                      //  pbLoad.setVisibility(View.GONE);
                    }
                });

                }
        });

btFavorite.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Movie movie = new Movie();
        movie.setTitle(tvTitle.getText().toString());
        movie.setYear(tvYear.getText().toString());
      //  movie.setPlot(tvPlot.getText().toString());

        //new taskaddmovie.executemovie();
       // AppDatabase.getInstance(v.getContext()).movieDao().insert(items.add(movie))
        AppDatabase.getInstance(v.getContext()).movieDao().insert(items.add(movie));
    }
});
    }
}