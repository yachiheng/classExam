package tw.org.iii.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActMain extends Activity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==3){
            if(data==null){
                lblTitle.setText("沒有設定管理員");
                return;
            }
            if(data.getExtras()==null){
                lblTitle.setText("沒有設定包裹");
                return;
            }
            String result=data.getExtras().getString("KK");
            lblTitle.setText("你的選擇是:"+result);
        }
    }

    private View.OnClickListener btnNew_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(ActMain.this,A2.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnSend_click=new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            Bundle bund = new Bundle();
            bund.putString("KK","Marco");
            Intent intent = new Intent(ActMain.this,A3.class);
            intent.putExtras(bund);
            startActivity(intent);


        }
    };
    private View.OnClickListener btnReceive_click=new View.OnClickListener(){

        @Override
        public void onClick(View v) {


            Intent intent = new Intent(ActMain.this,A4.class);
            startActivityForResult(intent,3);


        }
    };
    private View.OnClickListener btnList_click=new View.OnClickListener(){

        @Override
        public void onClick(View v) {


            Intent intent = new Intent(ActMain.this,A5.class);
            startActivity(intent);


        }
    };
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ACT_DEMO","onStart() 事件被觸發");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ACT_DEMO","onRestart() 事件被觸發");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ACT_DEMO","onResume() 事件被觸發");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ACT_DEMO","onPause() 事件被觸發");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ACT_DEMO","onStop() 事件被觸發");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ACT_DEMO","onDestroy() 事件被觸發");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        Log.i("ACT_DEMO","onCreate() 事件被觸發");
        InitialComponent();
    }

    private void InitialComponent() {
        lblTitle=findViewById(R.id.lblTitle);
        btnNew=findViewById(R.id.btnNew);
        btnNew.setOnClickListener(btnNew_click);
        btnSend=findViewById(R.id.btnSend);
        btnSend.setOnClickListener(btnSend_click);
        btnReceive=findViewById(R.id.btnReceive);
        btnReceive.setOnClickListener(btnReceive_click);
        btnList=findViewById(R.id.btnList);
        btnList.setOnClickListener(btnList_click);

    }
    TextView lblTitle;
    Button btnNew;
    Button btnSend;
    Button btnReceive;
    Button btnList;
}
