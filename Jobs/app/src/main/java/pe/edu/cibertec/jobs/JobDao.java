package pe.edu.cibertec.jobs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface JobDao {

    @Query("select title, company, description,company_logo from job")
    List<Job> getAll();
}
