package pe.edu.cibertec.movieapimvp.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public  static final String BASE_URL = "https://www.omdbapi.com/";
    private  static Retrofit retrofit = null;

    public static Retrofit getClient (){
        if (retrofit == null){
         retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
