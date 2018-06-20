package ali.naseem.keeper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private ArrayList<Player> players;
    private Context context;
    private int type;

    public TeamAdapter(Context context, ArrayList<Player> players, int type) {
        this.players = players;
        this.context = context;
        this.type = type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (type) {
            case Constants.TYPE_CSK:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.player_csk, parent, false));
            case Constants.TYPE_RCB:
                return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.player_rcb, parent, false));
        }
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.player_csk, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.playerName.setText(players.get(position).getName());
        Glide.with(context)
                .load(players.get(position).getImage())
                .asBitmap()
                .placeholder(R.drawable.player)
                .into(holder.playerImage);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView playerName;
        public CircleImageView playerImage;
        public ViewHolder(View itemView) {
            super(itemView);
            playerImage=itemView.findViewById(R.id.playerImage);
            playerName=itemView.findViewById(R.id.playerName);
        }
    }
}
