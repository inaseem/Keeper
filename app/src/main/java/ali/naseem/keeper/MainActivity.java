package ali.naseem.keeper;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Thread thread=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(thread==null) {
            thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                    Intent intent = new Intent(MainActivity.this, TeamSelectActivity.class);
                    startActivity(intent);
                    finish();
                }
            };
            thread.start();
        }
//        new Handler(this.getMainLooper()).post(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }
}
