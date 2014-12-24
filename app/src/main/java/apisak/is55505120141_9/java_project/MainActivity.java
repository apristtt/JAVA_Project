package apisak.is55505120141_9.java_project;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.cengalabs.flatui.FlatUI;
import com.cengalabs.flatui.views.FlatButton;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity implements OnMapReadyCallback {
    private final LatLng LOCATION_BURNABY = new LatLng(13.714123, 100.537749);
    private final LatLng LOCATION_SURREY = new LatLng(13.716317, 100.538264);

    private final LatLng LOCATION_BP_LAWN = new LatLng(13.716303, 100.538257);
    private final LatLng LOCATION_BP_BUILDING7 = new LatLng(13.716720, 100.538063);
    private final LatLng LOCATION_BP_BUILDING4 = new LatLng(13.717124, 100.537857);
    private final LatLng LOCATION_BP_FOOTBALL = new LatLng(13.717486, 100.537674);
    private final LatLng LOCATION_BP_TENNIS = new LatLng(13.717750, 100.537527);
    private final LatLng LOCATION_BP_CANTEEN = new LatLng(13.717440, 100.537369);
    private final LatLng LOCATION_BP_BUILDING5 = new LatLng(13.717518, 100.537886);
    private final LatLng LOCATION_BP_MEDICALROOM = new LatLng(13.717645, 100.537827);
    private final LatLng LOCATION_BP_BUILDING2 = new LatLng(13.717802, 100.537194);
    private final LatLng LOCATION_BP_UTKSEVENELEVEN = new LatLng(13.717833, 100.537315);
    private final LatLng LOCATION_BP_BUILDING1 = new LatLng(13.717565, 100.536704);
    private final LatLng LOCATION_BP_BUILDING9 = new LatLng(13.717338, 100.536250);

    private GoogleMap map;
//    private MapFragment mapFragment;

    private Spinner choose;
    private Button btnSearch;
    public ArrayList<String> VenueList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFlatUI();
        setMap();
        initWidget();
        addListITEM();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPos = choose.getSelectedItemPosition();

                if (itemPos == 0) {
                    Toast.makeText(getApplicationContext(),"Please choose venue.", Toast.LENGTH_LONG).show();
                } else if (itemPos == 1) {
                    setMarkerAndMoveCamera("Building 1", "Building 1 of Borpitpimuk Mahamek Campus", LOCATION_BP_BUILDING1);
                } else if (itemPos == 2) {
                    setMarkerAndMoveCamera("Building 2", "Building 2 of Borpitpimuk Mahamek Campus", LOCATION_BP_BUILDING2);
                } else if (itemPos == 3) {
                    setMarkerAndMoveCamera("Building 4", "Building 4 of Borpitpimuk Mahamek Campus", LOCATION_BP_BUILDING4);
                } else if (itemPos == 4) {
                    setMarkerAndMoveCamera("Building 5", "Building 5 of Borpitpimuk Mahamek Campus", LOCATION_BP_BUILDING5);
                } else if (itemPos == 5) {
                    setMarkerAndMoveCamera("Building 7", "Building 7 of Borpitpimuk Mahamek Campus", LOCATION_BP_BUILDING7);
                } else if (itemPos == 6) {
                    setMarkerAndMoveCamera("Building 9", "Building 9 of Borpitpimuk Mahamek Campus", LOCATION_BP_BUILDING9);
                } else if (itemPos == 7) {
                    setMarkerAndMoveCamera("Lawn", "Lawn of Borpitpimuk Mahamek Campus", LOCATION_BP_LAWN);
                } else if (itemPos == 8) {
                    setMarkerAndMoveCamera("Football", "Football of Borpitpimuk Mahamek Campus", LOCATION_BP_FOOTBALL);
                } else if (itemPos == 9) {
                    setMarkerAndMoveCamera("Tennis", "Tennis of Borpitpimuk Mahamek Campus", LOCATION_BP_TENNIS);
                } else if (itemPos == 10) {
                    setMarkerAndMoveCamera("Canteen", "Canteen of Borpitpimuk Mahamek Campus", LOCATION_BP_CANTEEN);
                } else if (itemPos == 11) {
                    setMarkerAndMoveCamera("Medical Room", "Mediacal Room of Borpitpimuk Mahamek Campus", LOCATION_BP_MEDICALROOM);
                } else if (itemPos == 12) {
                    setMarkerAndMoveCamera("UTK by 7-11", "UTK by 7-11 of Borpitpimuk Mahamek Campus", LOCATION_BP_UTKSEVENELEVEN);
                }

            }
        });

    }

    public void setMarkerAndMoveCamera(String title, String snippet, LatLng position){
        map.clear();
        map.addMarker(new MarkerOptions()
                .title(title)
                .snippet(snippet)
                .position(position));

        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(position, 18);
        map.animateCamera(update);

    }

    private void setFlatUI(){
        FlatUI.initDefaultValues(this);
        FlatUI.setDefaultTheme(FlatUI.GRASS);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(FlatUI.getActionBarDrawable(this, FlatUI.GRASS, false));

    }

    private void setMap(){
        map = ((MapFragment) getFragmentManager(). findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);
    }

    private void addListITEM() {
        ArrayList<String> VenueList = new ArrayList<String>();
        VenueList.add("Choose...");
        VenueList.add("1st Building");
        VenueList.add("2nd Building");
        VenueList.add("4th Building");
        VenueList.add("5th Building");
        VenueList.add("7th Building");
        VenueList.add("9th Building");
        VenueList.add("Lawn");
        VenueList.add("Football");
        VenueList.add("Tennis");
        VenueList.add("Canteen");
        VenueList.add("Medical Room");
        VenueList.add("UTK by 7-11");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, VenueList);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choose.setAdapter(myAdapter);
    }

    private void initWidget() {
        choose = (Spinner) findViewById(R.id.spinnerPickLocation);
        btnSearch = (Button) findViewById(R.id.btnSearch);
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

    public void onClick_UTK(View view){
        LatLng utk = new LatLng(13.7141162, 100.5384555);

        map.addMarker(new MarkerOptions()
                .title("UTK")
                .snippet("University")
                .position(utk));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(utk, 18));

        CameraUpdate utkUpdate = CameraUpdateFactory.newLatLng(utk);
        map.animateCamera(utkUpdate);
    }

    public void onClick_myLocation(View view){
        map.setMyLocationEnabled(true);
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

        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

}
