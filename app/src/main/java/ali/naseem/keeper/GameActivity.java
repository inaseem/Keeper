package ali.naseem.keeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class GameActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private String RCB_PLAYERS=null,CSK_PLAYERS=null;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent=getIntent();
        RCB_PLAYERS=intent.getStringExtra(Constants.PLAYERS_RCB);
        CSK_PLAYERS=intent.getStringExtra(Constants.PLAYERS_CSK);
        drawer=(DrawerLayout)findViewById(R.id.drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        NavigationView navigationView2 = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView2.setNavigationItemSelectedListener(this);
        String rcb[]=RCB_PLAYERS.split(",");
        String csk[]=CSK_PLAYERS.split(",");
        for(int i = 0;i<rcb.length;++i){
            navigationView.getMenu().getItem(i).setTitle(rcb[i]);
            navigationView2.getMenu().getItem(i).setTitle(csk[i]);
        }
        Toast.makeText(this, RCB_PLAYERS, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.player1:

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        toss();
    }

    public void toss(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
// ...Irrelevant code for customizing the buttons and title
        AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater inflater = this.getLayoutInflater();
        alertDialog.setContentView(inflater.inflate(R.layout.toss_layout, null));
        ImageView tossImageView=alertDialog.findViewById(R.id.tossImageView);
//        Glide.with(this)
//                .load(R.drawable.coin)
//                .asGif()
//                .into(tossImageView);
        alertDialog.show();
    }
}
