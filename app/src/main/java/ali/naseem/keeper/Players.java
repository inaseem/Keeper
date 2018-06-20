package ali.naseem.keeper;

import android.content.Context;

import java.util.ArrayList;

public class Players {
    private static final Players ourInstance = new Players();
    private ArrayList<Player> playersRCB=new ArrayList<>(),playersCSK=new ArrayList<>();

    public static Players getInstance() {
        return ourInstance;
    }

    private Players() {
    }

    public void loadPlayers(Context context){
        String str[]=context.getResources().getStringArray(R.array.team_csk);
        for(String st:str){
            playersCSK.add(new Player(st.split("#")[0],st.split("#")[1].trim()));
        }
        str=context.getResources().getStringArray(R.array.team_rcb);
        for(String st:str){
            playersRCB.add(new Player(st.split("#")[0],st.split("#")[1].trim()));
        }
    }

    public ArrayList<Player> getPlayersCSK() {
        return playersCSK;
    }

    public ArrayList<Player> getPlayersRCB() {
        return playersRCB;
    }
}
