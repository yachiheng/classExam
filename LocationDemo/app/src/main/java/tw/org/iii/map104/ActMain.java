package tw.org.iii.map104;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ActMain extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);

        TextView lblLocation=findViewById(R.id.lblLocation);

        //getSystemService:取得各類系統服務
        //LocationManager:取得位置服務管理器
        LocationManager manager=(LocationManager)getSystemService(LOCATION_SERVICE);

        //二次確認:Android 6.X,API 23以後
        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},0);
        }

        if(manager.isProviderEnabled(LocationManager.GPS_PROVIDER)||
                manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
        //getLastKnownLocation:使用LocationManager的getLastKnownLocation方法取得目前裝置的位置
            //Location物件即是向系統取得目前位置
            Location location=manager.getLastKnownLocation("network");
            if(location!=null){
                StringBuffer message=new StringBuffer(); //抓訊息
                message.append("位置：緯度:");
                message.append(Double.toString(location.getLongitude()));
                message.append(",經度：");
                message.append(Double.toString(location.getLatitude()));
                message.append(",高度：");
                message.append(Double.toString(location.getAltitude()));
                message.append(",精準度：");
                message.append(Double.toString(location.getAccuracy()));
                lblLocation.setText(message);
            }
            else
                lblLocation.setText("定位不到目前位置");
        }else
          lblLocation.setText("沒有打開定位功能");


    }

}
