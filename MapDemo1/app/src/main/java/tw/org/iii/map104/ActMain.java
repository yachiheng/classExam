package tw.org.iii.map104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActMain extends AppCompatActivity {

     OnMapReadyCallback map_ready=new OnMapReadyCallback(){
         @Override
         public void onMapReady(GoogleMap googleMap) {
             LatLng gps=new LatLng(22.628881, 120.294568);
             googleMap.addMarker(new MarkerOptions().position(gps).title("資策會").snippet("捷運舊市議會站2號出口左轉"));
             googleMap.moveCamera( CameraUpdateFactory.newLatLngZoom(gps, 15) );
             googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

         }
     };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);

        ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMapAsync(map_ready);
    }
}
