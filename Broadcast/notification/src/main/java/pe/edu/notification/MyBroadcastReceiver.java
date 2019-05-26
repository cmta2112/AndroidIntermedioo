package pe.edu.notification;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import java.util.Random;

public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // este metodo pide  un contexto y un intent

        String action = intent.getAction();
        Intent newIntent = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1,newIntent,0); // es pending porque esta pendiente , esta esperando ... se pone un numero cualquiera como identificador

        if (action == "pe.edu.cibertec.broadcast.ACTION") {  //asi se llama la action
            Toast.makeText(context, "Acción ocurrio", Toast.LENGTH_SHORT).show();


            NotificationCompat.Builder notification = new NotificationCompat
                    .Builder(context, "Canal")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notificación Nueva")
                    .setContentText("Esta es una nueva notificación")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent) // redireccionarte al otro activity (app)
                    .setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(0,notification.build()); // este id es el que encola las nuevas notificaciones

        }

            if (action.equals("android.intent.action.AIRPLANE_MODE")){
                NotificationCompat.Builder notification = new NotificationCompat
                        .Builder(context, "Canal")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notificación modo avión")
                        .setContentText("Cambio modo avion")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent) // redireccionarte al otro activity (app)
                        .setAutoCancel(true);

                Random random = new Random();
                int unique_id=random.nextInt(999);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
                managerCompat.notify(0,notification.build());

            }
    }
}