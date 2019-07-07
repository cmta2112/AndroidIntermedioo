package pe.edu.cibertec.geoquiz.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.edu.cibertec.geoquiz.R;
import pe.edu.cibertec.geoquiz.data.network.model.Question;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    // se tiene la vista

    Button btYes, btNo, btNext, btPrevious;
    TextView tvQuestion;
    int actualPosition;

    ArrayList<Question> questions;
    MainContract.MainPresenter presenter;


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



        // aplicacion de metodos

        actualPosition = 0;

        questions = new ArrayList<>();
        loadQuestions();

        showActualQuestion();

            }



    private void configureMvp() {
        this.presenter = new MainPresenter(this);
    }


    private void setListeners() {
        btYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verifyResponse(true);

            }
        });

        btNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyResponse(false);

            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualPosition += 1;

                if (actualPosition == questions.size()) {
                    actualPosition = 0;
                }

                showActualQuestion();
            }
        });

    }


    private void initView() {


        btYes = findViewById(R.id.btYes);
        btNo = findViewById(R.id.btNo);
        btNext = findViewById(R.id.btNext);
        btPrevious = findViewById(R.id.btPrevious);


        tvQuestion = findViewById(R.id.tvQuestion);

    }

    private void verifyResponse(boolean option) {
        Question actualQuestion = questions.get(actualPosition);
        if (option == actualQuestion.isResponse()){
            Toast.makeText(MainActivity.this,
                    getString(R.string.answer_correct)
                    , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this,
                    getString(R.string.answer_incorrect)
                    , Toast.LENGTH_SHORT).show();
        }
    }

    // para que se muestre las preguntas en vista
    private void showActualQuestion() {
        tvQuestion.setText(questions.get(actualPosition).getName());

    }


}
