package pe.edu.cibertec.geoquiz.ui.main;

import pe.edu.cibertec.geoquiz.R;
import pe.edu.cibertec.geoquiz.data.network.model.Question;

public class MainPresenter implements MainContract.MainPresenter{

    MainContract.MainView mainView;


    // Inyección de dependencia de constructor
    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    // metodos
    private void loadQuestions() {
        Question questionPeru =
                new Question(getString(R.string.peru_question), true);

        questions.add(questionPeru);

        Question questionChile =
                new Question(getString(R.string.chile_question), false);

        questions.add(questionChile);


        Question questionColombia =
                new Question(getString(R.string.colombia_question), true);
        questions.add(questionColombia);


    }

}
