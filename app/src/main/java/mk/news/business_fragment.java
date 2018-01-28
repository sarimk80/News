package mk.news;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abbott on 04-Aug-17.
 */

public class business_fragment extends Fragment {

    private RecyclerView recyclerView;

    private SwipeRefreshLayout swipeRefreshLayout;

    private List<list_view> list_views;

    private static final String URL_data="https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=3209e0394c0b402cb60f1b67e490dc0a";

    private static final String ESPN_URL="https://newsapi.org/v1/articles?source=espn&sortBy=top&apiKey=3209e0394c0b402cb60f1b67e490dc0a";

    private static final String TALK_SPORT_URL="https://newsapi.org/v1/articles?source=talksport&sortBy=top&apiKey=3209e0394c0b402cb60f1b67e490dc0a";

    private static final String SPORTS_BIBLE_URL="https://newsapi.org/v1/articles?source=the-sport-bible&sortBy=top&apiKey=3209e0394c0b402cb60f1b67e490dc0a";

    public int i=0;

    private RecyclerView.Adapter adapter1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.business,container,false);

        recyclerView=(RecyclerView) view.findViewById(R.id.recycleView3);

        swipeRefreshLayout=(SwipeRefreshLayout) view.findViewById(R.id.Swip_3);

        recyclerView.hasFixedSize();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        list_views = new ArrayList<>();


        loadRecycleView();


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Refresh();
            }
        });


        return view;
    }

    private void Refresh() {

        Intent i=new Intent(getContext(),MainActivity.class);
        getContext().startActivity(i);

    }

    private void loadRecycleView() {

       final ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        /*
        BBC Sprots api
         */


        StringRequest stringRequest = new StringRequest(Request.Method.GET,

                URL_data,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
                        //Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();

                        try {

                           // Log.e("MainActivity", "In Try");
                            JSONObject jsonObject = new JSONObject(response);

                            //Log.e("MainActivity", "In JSONObject");

                            JSONArray jsonArray = jsonObject.getJSONArray("articles");

                            //Log.e("MainActivity", "In JSONArray");

                            for (i = 0; i <= 3; i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                list_view listView = new list_view(
                                        o.getString("title"),
                                        o.getString("description"),
                                        o.getString("urlToImage"),
                                        o.getString("author"),
                                        o.getString("url")

                                );
                                //Log.e("MainActivity", "Data is fetched");
                                //Log.e("MainActivity", String.valueOf(jsonArray.length()));

                                list_views.add(listView);


                                //Log.e("MainActivity", "setting the adapter");
                                adapter1 = new adapter(list_views, getActivity());
                                recyclerView.setAdapter(adapter1);
                                //Log.e("MainActivity", "recycle View adapter is set");
                                adapter1.notifyDataSetChanged();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                             Toast.makeText(getContext(),"Sorry Something Went wrong", Toast.LENGTH_LONG).show();
                        }

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                 Toast.makeText(getContext(),"No Internet Connection",Toast.LENGTH_LONG).show();

            }
        }
        );


        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);




        /*
        ESPN_URL
         */

        StringRequest stringRequest1 = new StringRequest(Request.Method.GET,

                ESPN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
                        //Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();

                        try {

                           // Log.e("MainActivity", "In Try");
                            JSONObject jsonObject = new JSONObject(response);

                            //Log.e("MainActivity", "In JSONObject");

                            JSONArray jsonArray = jsonObject.getJSONArray("articles");

                            //Log.e("MainActivity", "In JSONArray");

                            for (i = 0; i <= 3; i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                list_view listView = new list_view(
                                        o.getString("title"),
                                        o.getString("description"),
                                        o.getString("urlToImage"),
                                        o.getString("author"),
                                        o.getString("url")

                                );
                               // Log.e("MainActivity", "Data is fetched");
                                //Log.e("MainActivity", String.valueOf(jsonArray.length()));

                                list_views.add(listView);


                                //Log.e("MainActivity", "setting the adapter");
                                adapter1 = new adapter(list_views, getActivity());
                                recyclerView.setAdapter(adapter1);
                                //Log.e("MainActivity", "recycle View adapter is set");
                                adapter1.notifyDataSetChanged();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();


            }
        }
        );


        RequestQueue requestQueue1 = Volley.newRequestQueue(getActivity());
        requestQueue1.add(stringRequest1);


        /*
        Talk_sports_url

         */


        StringRequest stringRequest2 = new StringRequest(Request.Method.GET,

                TALK_SPORT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
                        //Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();

                        try {

                            //Log.e("MainActivity", "In Try");
                            JSONObject jsonObject = new JSONObject(response);

                            //Log.e("MainActivity", "In JSONObject");

                            JSONArray jsonArray = jsonObject.getJSONArray("articles");

                            //Log.e("MainActivity", "In JSONArray");

                            for (i = 0; i <= 4; i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                list_view listView = new list_view(
                                        o.getString("title"),
                                        o.getString("description"),
                                        o.getString("urlToImage"),
                                        o.getString("author"),
                                        o.getString("url")

                                );
                                //Log.e("MainActivity", "Data is fetched");
                                //Log.e("MainActivity", String.valueOf(jsonArray.length()));

                                list_views.add(listView);


                                //Log.e("MainActivity", "setting the adapter");
                                adapter1 = new adapter(list_views, getActivity());
                                recyclerView.setAdapter(adapter1);
                                //Log.e("MainActivity", "recycle View adapter is set");
                                adapter1.notifyDataSetChanged();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();


            }
        }
        );


        RequestQueue requestQueue2 = Volley.newRequestQueue(getActivity());
        requestQueue2.add(stringRequest2);

        /*
        Sports_bible_url
         */


        StringRequest stringRequest3 = new StringRequest(Request.Method.GET,

                SPORTS_BIBLE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressDialog.dismiss();
                        //Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();

                        try {

                            Log.e("MainActivity", "In Try");
                            JSONObject jsonObject = new JSONObject(response);

                            //Log.e("MainActivity", "In JSONObject");

                            JSONArray jsonArray = jsonObject.getJSONArray("articles");

                            //Log.e("MainActivity", "In JSONArray");

                            for (i = 0; i <= 3; i++) {
                                JSONObject o = jsonArray.getJSONObject(i);
                                list_view listView = new list_view(
                                        o.getString("title"),
                                        o.getString("description"),
                                        o.getString("urlToImage"),
                                        o.getString("author"),
                                        o.getString("url")

                                );
                                //Log.e("MainActivity", "Data is fetched");
                                //Log.e("MainActivity", String.valueOf(jsonArray.length()));

                                list_views.add(listView);


                                //Log.e("MainActivity", "setting the adapter");
                                adapter1 = new adapter(list_views, getActivity());
                                recyclerView.setAdapter(adapter1);
                                //Log.e("MainActivity", "recycle View adapter is set");
                                adapter1.notifyDataSetChanged();

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();


            }
        }
        );


        RequestQueue requestQueue3 = Volley.newRequestQueue(getActivity());
        requestQueue3.add(stringRequest3);






    }
}
