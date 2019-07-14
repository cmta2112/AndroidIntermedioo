package pe.edu.cibertec.favouritemovies;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity
    class Movie {

    @NonNull
    @PrimaryKey
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Plot")
    private String plot;



   /* //contructores


    public Movie(String title, String year, String plot, String poster) {
        this.title = title;
        this.year = year;
        this.plot = plot;

    }

    public Movie() {

    }
*/
    //getter y setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
