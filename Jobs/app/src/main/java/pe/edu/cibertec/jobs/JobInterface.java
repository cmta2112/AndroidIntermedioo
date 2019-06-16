package pe.edu.cibertec.jobs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JobInterface {

    @GET("positions.json?")
    Call<List<Job>> searchJobs(@Query("description") String description);

   // @GET("?")
   // Call<Job> searchMovie(@Query("description") String apikey, @Query("android") String name);

}
