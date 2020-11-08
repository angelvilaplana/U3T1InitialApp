package dam.android.angelvilaplana.u3t1initialapp;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sound = MediaPlayer.create(getApplicationContext(), R.raw.nokia_guitar);
                    sound.start();
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent("dam.android.u3t1initialapp.STARTINGPOINT"));
                }
            }
        };

        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.release();
        sound = null;
        finish();
    }
}