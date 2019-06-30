package pe.edu.cibertec.movieapimvp.iu.main;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pe.edu.cibertec.movieapimvp.R;
import pe.edu.cibertec.movieapimvp.data.network.model.Movie;

public class MainActivity extends AppCompatActivity implements  MainContract.MainView{

    // este de aqui es mi vista

    TextInputEditText etMovie;
    Button btSearch;
    TextView tvTitle, tvYear, tvPlot;
    ImageView ivPoster;

    MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializando la vista
        initView();

        // metodo para todos los botones
        setListeners();

        //cnfigurar el MVP
        configureMvp();
    }

    private void configureMvp() {
        this.presenter = new MainPresenter(this); // inyeccion de dependencia por constructor
    }

    private void setListeners() {
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.presenter.searchMovie(etMovie.getText().toString());

            }
        });
    }

    private void initView() {
        etMovie = findViewById(R.id.etMovie);
        btSearch = findViewById(R.id.btSearch);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvPlot = findViewById(R.id.tvPlot);

        ivPoster = findViewById(R.id.ivPoster);
    }

    @Override
    public void showMovie(Movie movie) {
        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYear());
        tvPlot.setText(movie.getPlot());

        Glide.with(MainActivity.this)
                .load(movie.getPoster())
                .into(ivPoster);
    }
}