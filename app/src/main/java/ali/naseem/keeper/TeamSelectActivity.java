package ali.naseem.keeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class TeamSelectActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCSK,recyclerViewRCB;
    private TeamAdapter adapterCSK,adapterRCB;
    private ArrayList<Player> playersRCB=new ArrayList<>(),playersCSK=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);
        recyclerViewCSK=findViewById(R.id.recyclerViewCSK);
        LinearLayoutManager linearLayoutManagerCSK=new LinearLayoutManager(this);
        linearLayoutManagerCSK.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewCSK.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        recyclerViewCSK.setLayoutManager(linearLayoutManagerCSK);
        recyclerViewCSK.setItemAnimator(new DefaultItemAnimator());
        ////////////////////////////////////////////////////
        recyclerViewRCB=findViewById(R.id.recyclerViewRCB);
        LinearLayoutManager linearLayoutManagerRCB=new LinearLayoutManager(this);
        linearLayoutManagerRCB.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewRCB.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        recyclerViewRCB.setLayoutManager(linearLayoutManagerRCB);
        recyclerViewRCB.setItemAnimator(new DefaultItemAnimator());
        String str[]=getResources().getStringArray(R.array.team_csk);
        for(String st:str){
            playersCSK.add(new Player(st.split("#")[0],st.split("#")[1].trim()));
        }
        adapterCSK=new TeamAdapter(this,playersCSK,Constants.TYPE_CSK);
        recyclerViewCSK.setAdapter(adapterCSK);
        str=getResources().getStringArray(R.array.team_rcb);
        for(String st:str){
            playersRCB.add(new Player(st.split("#")[0],st.split("#")[1].trim()));
        }
        adapterRCB=new TeamAdapter(this,playersRCB,Constants.TYPE_RCB);
        recyclerViewRCB.setAdapter(adapterRCB);
    }
}
