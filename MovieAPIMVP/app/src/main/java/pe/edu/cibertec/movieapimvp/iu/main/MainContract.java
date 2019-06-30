package pe.edu.cibertec.movieapimvp.iu.main;

import pe.edu.cibertec.movieapimvp.data.network.model.Movie;

public interface MainContract {

    interface MainView {
        void showMovie(Movie movie);
    }

    interface MainPresenter{
        void  searchMovie(String title);
    }
}
