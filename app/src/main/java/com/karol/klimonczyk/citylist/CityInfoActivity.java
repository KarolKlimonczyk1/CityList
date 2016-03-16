package com.karol.klimonczyk.citylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Karol on 3/15/2016.
 */
public class CityInfoActivity extends Activity {

    GoogleGeoCodeResponse googleGeoCodeResponse;
    TextView city;
    TextView admLvl3;
    TextView admLvl2;
    TextView admLvl1;
    TextView country;
    final int RESULT_NUMBER=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_info_activity);

        Intent i = getIntent();
        googleGeoCodeResponse = (GoogleGeoCodeResponse)i.getSerializableExtra("googleGeo");

        city=(TextView)findViewById(R.id.cityInfo);
        admLvl3=(TextView)findViewById(R.id.admLvl3Info);
        admLvl2=(TextView)findViewById(R.id.admLvl2Info);
        admLvl1=(TextView)findViewById(R.id.admLvl1Info);
        country=(TextView)findViewById(R.id.country);


        city.setText(googleGeoCodeResponse.getResults()[RESULT_NUMBER].getAddress_components()[0].getLong_name());
        admLvl3.setText(googleGeoCodeResponse.getResults()[RESULT_NUMBER].getAddress_components()[1].getLong_name());
        admLvl2.setText(googleGeoCodeResponse.getResults()[RESULT_NUMBER].getAddress_components()[2].getLong_name());
        admLvl1.setText(googleGeoCodeResponse.getResults()[RESULT_NUMBER].getAddress_components()[3].getLong_name());
        country.setText(googleGeoCodeResponse.getResults()[RESULT_NUMBER].getAddress_components()[4].getLong_name());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backToList:
                onBackPressed();
        }
        return true;
    }
}
