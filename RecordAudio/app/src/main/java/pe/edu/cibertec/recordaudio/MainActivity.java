package pe.edu.cibertec.recordaudio;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Button btRecord, btPlay;

    MediaRecorder recorder = null;
    MediaPlayer player = null ;

    String fileName = null;

    boolean recording = false;
    boolean playing = false;

    boolean permissionGranted = false;


    static final int REQUEST_RECORD_AUDIO = 1;
    static final String LOG_TAG = "AudioRecorder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRecord = findViewById(R.id.btRecord);
        btPlay = findViewById(R.id.btPlay);
        //btPlay.setEnabled(false);

        fileName = getExternalCacheDir().getAbsolutePath();
        fileName = fileName + "/audiorecorder.3gp";
        checkPermissionRecord();

        btRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aqui se valida si se tiene permiso o no --> el metodo esta mas abajo
               // checkPermissionRecord();

                if (!recording){
                    startRecording();
                    btRecord.setText("Detener");

                }else {
                    stopRecording();
                    btRecord.setText("Grabar");
                }

                // esto es para cambiar el estado del recording
                recording = !recording;


            }
        });

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!playing){
                     startPlaying();
                     btPlay.setText("Detener");
                }else {
                    stopPlaying();
                    btPlay.setText("Play");
                }
                playing = !playing;


            }
        });


    }

    private void stopPlaying() {
        player.stop();
        player.release();
        player = null;

    }

    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;


    }

    private void startPlaying() {

        player = new MediaPlayer();

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlaying();
                btPlay.setText("Play");
                playing = !playing;

            }
        });

        try {
            player.setDataSource(fileName);
            player.prepare();
            player.start();

        } catch (IOException e) {

            Log.e(LOG_TAG, e.toString());

        }

    }

    // este metodo sirve para saber si se ha dado permiso o no

    private void checkPermissionRecord() {

        // ESTA ES LA SOLICITUD FORMAL
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, REQUEST_RECORD_AUDIO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        // SE COMPARA SI EL QUE ESTA PIDIENDO EL PERMISO ES QUIEN DEBE PEDIR EL PERMISO
        if (requestCode == REQUEST_RECORD_AUDIO) {
            permissionGranted = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;

            // --- se ve si se tiene una respuesta ----------- se ve si le dio permiso -----
            //if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
              // ya no va aqui -->    startRecording();

            }
        if (!permissionGranted){
            finish();
        }
        }
    //}

    private  void startRecording (){
        // generar una instancia para grabar
        recorder = new MediaRecorder();

        /// Indicar que la fuente del medio es el microfono
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        // Indicar el formato del audio
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        //Indicar el archivo donde se grabará el audio
        recorder.setOutputFile(fileName);

        // Encodear/COMPRIMIR EL AUDIO
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        //
        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, e.toString());
           // e.printStackTrace();
        }

        recorder.start();
        //btRecord.setText("Grabando...");
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (recorder != null){
            recorder.release();
            recorder = null;

        }
        if (player != null){
            player.release();
            player = null;
        }
    }
}
