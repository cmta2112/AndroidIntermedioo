package pe.edu.cibertec.dependencyinyection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Base
        AppPoolWatcher appPoolWatcher= new AppPoolWatcher();
        appPoolWatcher.notify("Ocurrió el evento");
        */

        //INYECCION DE CONTRUCTOR
        /*
        EmailSender action = new EmailSender();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher(action);

        appPoolWatcher.notify("Ocurrio el evento");
        */

        //INYECCION DE METODO
        /*
        SmsSender action = new SmsSender();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();
        appPoolWatcher.notify(action, "Ocurrio el evento");
        */

        //INYECCION DE PROPIEDAD
        EventLogWriter action = new EventLogWriter();
        AppPoolWatcher appPoolWatcher = new AppPoolWatcher();

        appPoolWatcher.setAction(action);
        appPoolWatcher.notify("Ocurrio el evento");



    }
}
