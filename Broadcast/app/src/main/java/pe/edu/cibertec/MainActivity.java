package pe.edu.cibertec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAction = findViewById(R.id.btAction);

        btAction.setOnClickListener(new View.OnClickListener() { //  esta es una clase anonima

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("pe.edu.cibertec.broadcast.ACTION"); // un identificador
                sendBroadcast(intent); // se envia la notificacion



            }
        });
    }
}
