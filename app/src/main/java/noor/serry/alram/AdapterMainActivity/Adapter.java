package noor.serry.alram.AdapterMainActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import noor.serry.alram.R;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    Context context;
    public Adapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from (context).inflate (R.layout.holder_main,parent,false);
        return new viewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }
    protected class viewHolder extends RecyclerView.ViewHolder{
        Switch aSwitch;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super (itemView);
            textView = itemView.findViewById (R.id.detiles);
            aSwitch  = itemView.findViewById (R.id.remove);
        }
    }
}
