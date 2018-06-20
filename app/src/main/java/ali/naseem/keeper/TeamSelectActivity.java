package ali.naseem.keeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class TeamSelectActivity extends AppCompatActivity {

    private LinearLayout teamRCB,teamCSK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);
        teamRCB=findViewById(R.id.teamRCB);
        teamCSK=findViewById(R.id.teamCSK);
        Players.getInstance().loadPlayers(this);
        ///////////////////////////////////////////////////////
        RecyclerView recyclerViewCSK = findViewById(R.id.recyclerViewCSK);
        LinearLayoutManager linearLayoutManagerCSK=new LinearLayoutManager(this);
        linearLayoutManagerCSK.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewCSK.setLayoutManager(linearLayoutManagerCSK);
        recyclerViewCSK.setItemAnimator(new DefaultItemAnimator());
        TeamAdapter adapterCSK = new TeamAdapter(this, Players.getInstance().getPlayersCSK(), Constants.TYPE_CSK);
        adapterCSK.setTeamLayout(teamCSK);
        recyclerViewCSK.setAdapter(adapterCSK);
        ////////////////////////////////////////////////////
        RecyclerView recyclerViewRCB = findViewById(R.id.recyclerViewRCB);
        LinearLayoutManager linearLayoutManagerRCB=new LinearLayoutManager(this);
        linearLayoutManagerRCB.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewRCB.setLayoutManager(linearLayoutManagerRCB);
        recyclerViewRCB.setItemAnimator(new DefaultItemAnimator());
        TeamAdapter adapterRCB = new TeamAdapter(this, Players.getInstance().getPlayersRCB(), Constants.TYPE_RCB);
        adapterRCB.setTeamLayout(teamRCB);
        recyclerViewRCB.setAdapter(adapterRCB);
        ////////////////////////////////////////////////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.team_select,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_play:
                if(teamCSK.getChildCount()+teamRCB.getChildCount()==22){
                    StringBuilder sbCSK=new StringBuilder();
                    StringBuilder sbRCB=new StringBuilder();
                    for(int i =0;i<teamCSK.getChildCount();++i){
                        sbCSK.append(",").append(((TextView)teamCSK.getChildAt(i)).getText().toString());
                        sbRCB.append(",").append(((TextView)teamRCB.getChildAt(i)).getText().toString());
                    }
                    Intent intent=new Intent(this,GameActivity.class);
                    intent.putExtra(Constants.PLAYERS_CSK,sbCSK.toString().substring(1));
                    intent.putExtra(Constants.PLAYERS_RCB,sbRCB.toString().substring(1));
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(this, "Please Choose Playing Eleven For Both The Teams", Toast.LENGTH_SHORT).show();
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
