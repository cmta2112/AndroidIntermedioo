package pe.edu.cibertec.jobs;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity
public class Job {

    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String title;

    @SerializedName("company")
    @ColumnInfo(name = "company")
    private String company;


    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;


    @SerializedName("company_logo")
    @ColumnInfo(name = "company_logo")
    private String logo;

    //contructores

    public Job() {
    }

    public Job(String title, String company, String description, String logo) {
        this.title = title;
        this.company = company;
        this.description = description;
        this.logo = logo;
    }

    //getter y setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
