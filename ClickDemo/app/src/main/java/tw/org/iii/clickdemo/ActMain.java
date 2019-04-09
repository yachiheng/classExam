package tw.org.iii.clickdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ActMain extends Activity {


    private View.OnClickListener btn_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            double a=Double.parseDouble(txtA.getText().toString());
            double b=Double.parseDouble(txtB.getText().toString());
            double c=Double.parseDouble(txtC.getText().toString());
            double r=b*b-4*a*c;
            r=Math.sqrt(r);

            DecimalFormat formater=new DecimalFormat("0.00");

            lblResult.setText("解答：x= "+
                    formater.format((-b+r)/(2*a))+
                    " 或  "+
                    formater.format((-b-r)/(2*a)));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();
    }

    private void InitialComponent() {
        btn= findViewById(R.id.btnOk);
        btn.setOnClickListener(btn_click);
        txtA=findViewById(R.id.txtA);
        txtB=findViewById(R.id.txtB);
        txtC=findViewById(R.id.txtC);
        lblResult = findViewById(R.id.lblResult);
    }
    Button btn;
    EditText txtA;
    EditText txtB;
    EditText txtC;
    TextView lblResult;
}