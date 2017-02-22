package iut.paci.noelcommunity;

import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.android.util.AndroidUtil;
import org.mapsforge.map.android.view.MapView;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.reader.MapFile;
import org.mapsforge.map.rendertheme.InternalRenderTheme;

import java.io.File;

public class MapActivity extends AppCompatActivity {

    private MapView mapView;
    private TileCache tileCache;
    private TileRendererLayer tileRendererLayer;
    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidGraphicFactory.createInstance(this.getApplication());

        this.mapView = new MapView(this);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mapView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        setContentView(this.mapView);

        mapView.setClickable(true);
        mapView.getMapScaleBar().setVisible(true);
        mapView.setBuiltInZoomControls(true);
        mapView.setZoomLevelMin((byte) 10);
        mapView.setZoomLevelMax((byte) 10);

        this.tileCache = AndroidUtil.createTileCache(this, "mapcache",
                mapView.getModel().displayModel.getTileSize(), 1f,
                mapView.getModel().frameBufferModel.getOverdrawFactor());

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        this.latitude = extra.getDouble("latitude");
        this.longitude = extra.getDouble("longitude");

        System.out.println(latitude + " !======================================================================================================================== " + longitude);
    }

    @Override
    protected void onStart() {
        super.onStart();

        File file = new File(Environment.getExternalStorageDirectory(), "/maps/paris.map");

        MapDataStore mapDataStore = new MapFile(file);
        tileRendererLayer = new TileRendererLayer(tileCache, mapDataStore,
                mapView.getModel().mapViewPosition,
                AndroidGraphicFactory.INSTANCE);
        tileRendererLayer.setXmlRenderTheme(InternalRenderTheme.OSMARENDER);
        mapView.getLayerManager().getLayers().add(tileRendererLayer);

        System.out.println(latitude + " ========================================================================================================================= " + longitude);

        mapView.setCenter(new LatLong(this.latitude, this.longitude));
        mapView.setZoomLevel((byte) 19);

    }

    @Override
    protected void onDestroy() {
        mapView.destroy();
        AndroidGraphicFactory.clearResourceMemoryCache();

        super.onDestroy();
    }
}
