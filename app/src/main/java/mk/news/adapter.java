package mk.news;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by abbott on 05-Aug-17.
 */

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {


    private List<list_view> list_views;
    private Context context;

    public adapter(List<list_view> list_views, Context context) {
        this.list_views = list_views;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

       final list_view list_views1=list_views.get(position);


        holder.new_news.setText(list_views1.getnews());
        holder.Descripyion.setText(list_views1.getDescription());

        Picasso.with(context).load(list_views1.getImage()).into(holder.imageView);
        holder.Author.setText(list_views1.getNews_Author());


      //  Log.d("MainActivity",String.valueOf(list_views1.getFull_Description()));


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"click Position"+position,Toast.LENGTH_LONG).show();



                Intent intent=new Intent(view.getContext(),Fragment_1.class);

                intent.putExtra("Image",list_views1.getImage());
                intent.putExtra("News",list_views1.getnews());
                intent.putExtra("newDescription",list_views1.getFull_Description());

                view.getContext().startActivity(intent);

               /* Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list_views1.getFull_Description()));
                view.getContext().startActivity(intent);*/


            }
        });



    }

    @Override
    public int getItemCount() {
        return list_views.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView new_news;
        public TextView Descripyion;
        public ImageView imageView;
        public TextView Author;
        public LinearLayout linearLayout;



        public ViewHolder(View itemView) {
            super(itemView);

            new_news=(TextView) itemView.findViewById(R.id.HedLine);
            Descripyion=(TextView) itemView.findViewById(R.id.description);
            imageView=(ImageView) itemView.findViewById(R.id.imageview);
            Author=(TextView) itemView.findViewById(R.id.author);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}
