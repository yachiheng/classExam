package tw.org.iii.map104;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActMain extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private Spinner mSpnLocation;
    private static String[][] mLocations = {
            {"台北101", "25.0336110,121.5650000"},
            {"中國長城", "40.0000350,119.7672800"},
            {"紐約自由女神像", "40.6892490,-74.0445000"},
            {"巴黎鐵塔", "48.8582220,2.2945000"}	};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mSpnLocation = (Spinner) this.findViewById(R.id.spnLocation);

        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);

        for (int i = 0; i < mLocations.length; i++)
            arrAdapter.add(mLocations[i][0]);

        arrAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        mSpnLocation.setAdapter(arrAdapter);
        mSpnLocation.setOnItemSelectedListener(spnLocationOnItemSelected);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    private AdapterView.OnItemSelectedListener spnLocationOnItemSelected =
            new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView parent, View v,
                                           int position, long id) {
                    updateMapLocation();
                }

                @Override
                public void onNothingSelected(AdapterView parent) {
                }

            };

    private void updateMapLocation() {
        int iSelected = mSpnLocation.getSelectedItemPosition();
        String[] sLocation = mLocations[iSelected][1].split(",");
        double dLat = Double.parseDouble(sLocation[0]);	// 南北緯
        double dLon = Double.parseDouble(sLocation[1]);	// 東西經
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(dLat, dLon), 14));
    }
}
