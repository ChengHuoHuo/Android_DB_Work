package maze.chenghuohuo.dbwork;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 44223 on 2018/9/7.
 */

public class FitAdapter extends RecyclerView.Adapter<FitAdapter.ViewHolder> {
    private Context mContext;
    private List<Fit> mFitList;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.fit_item,parent,false);

        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fit fit=mFitList.get(position);
                Intent intent=new Intent(mContext,ShowActivity.class);
                intent.putExtra(ShowActivity.NAME,fit.getName());
                intent.putExtra(ShowActivity.IMAGE_ID,fit.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fit fit=mFitList.get(position);
        holder.fitNmae.setText(fit.getName());
        Glide.with(mContext).load(fit.getImageId()).into(holder.fitImage);
    }

    @Override
    public int getItemCount() {
        return mFitList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fitImage;
        TextView fitNmae;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView;
            fitImage=(ImageView)itemView.findViewById(R.id.fit_image);
            fitNmae=(TextView)itemView.findViewById(R.id.fit_name);
        }
    }

    public FitAdapter(List<Fit> fitList){
        mFitList=fitList;
    }
}
