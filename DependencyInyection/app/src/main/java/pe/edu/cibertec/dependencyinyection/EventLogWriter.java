package pe.edu.cibertec.dependencyinyection;

import android.util.Log;

class EventLogWriter implements INotificationAction {


    @Override
    public void write(String message) {

        Log.d("MainActivity",message);


    }
}
