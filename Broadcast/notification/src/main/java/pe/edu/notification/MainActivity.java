package pe.edu.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //el otro envia la notificacion , y este lo recibe
        register();

        createNotificationChannel();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String name = "pe.edu.notification.CHANNEL";
            String description = "Descripción";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel("Canal",name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    private void register() {

        MyBroadcastReceiver broadcastReceiver = new MyBroadcastReceiver();// crear mi instancia
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("pe.edu.cibertec.broadcast.ACTION");
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");

        this.registerReceiver(broadcastReceiver,intentFilter);


    }
}
