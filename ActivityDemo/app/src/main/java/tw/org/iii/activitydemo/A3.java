package tw.org.iii.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class A3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3);

        Intent intent = getIntent();
        Bundle bund = intent.getExtras();
        String data=bund.getString("KK");

        TextView lblSet=findViewById(R.id.lblSet);
        lblSet.setText("Hello, "+data);
    }
}
