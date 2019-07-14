package pe.edu.cibertec.favouritemovies;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MovieDao {

  @Query("select Title,Year,Plot from Movie")
    List<Movie> getAll();


  @Insert(onConflict = OnConflictStrategy.IGNORE)
 void insert(Movie ... movie);


  @Delete
    void delete(Movie... movies);
}
