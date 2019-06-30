package pe.edu.cibertec.movieapimvp.iu.main;

import pe.edu.cibertec.movieapimvp.data.network.ApiClient;
import pe.edu.cibertec.movieapimvp.data.network.ApiInterface;
import pe.edu.cibertec.movieapimvp.data.network.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements MainContract.MainPresenter{

    // amarre la vista con el presentador
    MainContract.MainView mainView;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void searchMovie(String name) {
        String apikey = "6fc43ba7";

        ApiInterface movieInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Movie> methodSearch = movieInterface.searchMovie(apikey, name);

        methodSearch.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    MainPresenter.this.mainView.showMovie(movie);
                }


            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });

    }
}
