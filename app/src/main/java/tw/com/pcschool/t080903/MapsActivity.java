package tw.com.pcschool.t080903;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng taipei = new LatLng(25.0621, 121.4979);
        LatLng taipei1 = new LatLng(25.0444,121.5168);

        MarkerOptions options1 = new MarkerOptions().position(taipei).icon(BitmapDescriptorFactory.fromResource(R.drawable.f3));
        options1.title("巨匠電腦三重分校");
        options1.snippet("這是巨匠電腦三重分校的位置");

        mMap.addMarker(options1);
        MarkerOptions options2 = new MarkerOptions().position(taipei1).icon(BitmapDescriptorFactory.fromResource(R.drawable.f3));
        options2.title("巨匠電腦台北認證中心");
        options2.snippet("也是總公司的位置");
        mMap.addMarker(options2);

        // mMap.addMarker(new MarkerOptions().position(taipei).title("Marker in 三重巨匠"));

        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        // CameraPosition cameraPos = new CameraPosition.Builder().target(taipei)
        //        .zoom(17.0f).build();
        /*
        CameraPosition cameraPos = new CameraPosition.Builder().target(taipei)
                .zoom(17.0f).bearing(300).tilt(67).build();
                */
        CameraPosition cameraPos = new CameraPosition.Builder().target(taipei)
                .zoom(13.0f).build();
        CameraUpdate cameraUpt = CameraUpdateFactory
                .newCameraPosition(cameraPos);
        // mMap.moveCamera(cameraUpt);
        mMap.animateCamera(cameraUpt, 6000, null);

    }
}
