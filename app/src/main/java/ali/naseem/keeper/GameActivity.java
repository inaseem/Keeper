package ali.naseem.keeper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private String RCB_PLAYERS=null,CSK_PLAYERS=null;
    private DrawerLayout drawer;
    private int sel=-1;
    private NavigationView navigationView, navigationView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent=getIntent();
        RCB_PLAYERS=intent.getStringExtra(Constants.PLAYERS_RCB);
        CSK_PLAYERS=intent.getStringExtra(Constants.PLAYERS_CSK);
        drawer=(DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView2 = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView2.setNavigationItemSelectedListener(this);
        String rcb[]=RCB_PLAYERS.split(",");
        String csk[]=CSK_PLAYERS.split(",");
        for(int i = 0;i<rcb.length;++i){
            navigationView.getMenu().getItem(i).setTitle(rcb[i]);
            navigationView2.getMenu().getItem(i).setTitle(csk[i]);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.player1:

        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(drawer.isDrawerOpen(GravityCompat.END)){
            drawer.closeDrawer(GravityCompat.END);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(drawer.isDrawerOpen(GravityCompat.END)){
            drawer.closeDrawer(GravityCompat.END);
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
        dialogBuilder.setTitle("Which team to bat first?");
        dialogBuilder.setSingleChoiceItems(new CharSequence[]{getResources().getString(R.string.rcb),getResources().getString(R.string.csk)},sel,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int selected) {
                sel=selected;
            }
        });
        dialogBuilder.setPositiveButton("START MATCH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int buttonId) {
                if (sel!=-1){
                    TextView textView1=((TextView)navigationView.getHeaderView(0).findViewById(R.id.teamName));
                    TextView textView2=((TextView)navigationView2.getHeaderView(0).findViewById(R.id.teamName));
                    switch (sel){
                        case 0:
                            textView1.setText(textView1.getText().toString().concat("(Batting)"));
                            textView2.setText(textView2.getText().toString().concat("(Fielding)"));
                            break;
                        case 1: ;
                            textView1.setText(textView1.getText().toString().concat("(Fielding)"));
                            textView2.setText(textView2.getText().toString().concat("(Batting)"));
                    }
                }
            }
        });
        dialogBuilder.setCancelable(false);
        dialogBuilder.create().show();
    }
}
