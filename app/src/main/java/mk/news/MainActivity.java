package mk.news;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    private mk.news.sectionPageAdapter sectionPageAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=(ViewPager) findViewById(R.id.container);
        SetupViewPage(viewPager);

        TabLayout tabLayout=(TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



    }

    private void SetupViewPage(ViewPager viewPager){
        mk.news.sectionPageAdapter adapter=new sectionPageAdapter(getSupportFragmentManager());
        adapter.AddFragments(new first_Fragment(),"Breaking News");
        adapter.AddFragments(new second_Fragment(),"Business");
        adapter.AddFragments(new third_Fragment(),"Technology");
        adapter.AddFragments(new business_fragment(),"Sports");
        adapter.AddFragments(new science(),"Science/Entertainment");


       // Log.e("ViewPage", String.valueOf(viewPager.getCurrentItem()));


        viewPager.setAdapter(adapter);



    }




}
