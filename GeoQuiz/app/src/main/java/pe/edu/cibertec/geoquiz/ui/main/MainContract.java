package pe.edu.cibertec.geoquiz.ui.main;

import pe.edu.cibertec.geoquiz.data.network.model.Question;

public class MainContract {

    interface MainView {
        void showActualQuestion(Question question);
    }

    interface MainPresenter{
        void  searchMovie(String title);
    }
}
