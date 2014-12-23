package apisak.is55505120141_9.java_project;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private final LatLng LOCATION_BURNABY = new LatLng(13.714123, 100.537749);
    private final LatLng LOCATION_SURREY = new LatLng(13.716317, 100.538264);

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.map_layout);

        map = ((MapFragment) getFragmentManager(). findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);

//        MapFragment mMapFragment = MapFragment.newInstance();
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.map, mMapFragment);
//        fragmentTransaction.commit();

//        MapFragment mapFragment = ((MapFragment) getFragmentManager()
//                .findFragmentById(R.id.map)).getMap();
//        mapFragment.getMapAsync(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void onClick_City(View view){
        CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_BURNABY);
        map.animateCamera(update);
    }

    public void onClick_Surrey(View view){
        Context context = getApplicationContext();
        CharSequence text = "Hello Surrey";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void onClick_Burnaby(View view){

    }

    public void onClick_myLocation(View view){


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng bangkok = new LatLng(13.727896, 100.524123);

//        map.setMyLocationEnabled(true);
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(bangkok, 13));

        map.addMarker(new MarkerOptions()
            .title("Bangkok")
            .snippet("Thailand's popular")
            .position(bangkok));

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
