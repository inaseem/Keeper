package ali.naseem.keeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private String RCB_PLAYERS=null,CSK_PLAYERS=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent=getIntent();
        RCB_PLAYERS=intent.getStringExtra(Constants.PLAYERS_RCB);
        CSK_PLAYERS=intent.getStringExtra(Constants.PLAYERS_CSK);
        Toast.makeText(this, RCB_PLAYERS, Toast.LENGTH_SHORT).show();
    }
}
