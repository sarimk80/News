package mk.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by abbott on 08-Aug-17.
 */

public class Fragment extends android.support.v4.app.Fragment {

    ImageView imageView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment,container,false);

        imageView=(ImageView) v.findViewById(R.id.fragment_image);
        textView=(TextView) v.findViewById(R.id.news_fragment);

        imageView.setImageResource(getActivity().getIntent().getIntExtra("Image",00));
        textView.setText(getActivity().getIntent().getStringExtra("News"));




        return v;

    }
}
