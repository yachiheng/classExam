package tw.org.iii.calcdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActMain extends Activity {

    int n1=0;
    String op="";
    private View.OnClickListener btn1_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            int t=Integer.parseInt(lblNumber.getText().toString());
            if(t==0)
                lblNumber.setText("1");
            else
                lblNumber.setText(lblNumber.getText().toString()+"1");
        }
    };
    private View.OnClickListener btn3_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            int t=Integer.parseInt(lblNumber.getText().toString());
            if(t==0)
                lblNumber.setText("3");
            else
                lblNumber.setText(lblNumber.getText().toString()+"3");
        }
    };
    private View.OnClickListener btn2_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            int t=Integer.parseInt(lblNumber.getText().toString());
            if(t==0)
                lblNumber.setText("2");
            else
                lblNumber.setText(lblNumber.getText().toString()+"2");
        }
    };
    private View.OnClickListener btnPlus_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            n1 = Integer.parseInt(lblNumber.getText().toString());
            op="+";
            lblNumber.setText("0");

        }
    };
    private View.OnClickListener btnCalc_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            int n2 = Integer.parseInt(lblNumber.getText().toString());
            if("+".equals(op))
                lblNumber.setText(String.valueOf(n1+n2));
            else if("-".equals(op))
                lblNumber.setText(String.valueOf(n1-n2));

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();
    }

    private void InitialComponent() {
        lblNumber =findViewById(R.id.lblNumber);
        btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(btn1_click);
        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(btn2_click);
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(btn3_click);
        btnPlus=findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(btnPlus_click);
        btnCalc=findViewById(R.id.btnOk);
        btnCalc.setOnClickListener(btnCalc_click);

    }
    Button btn1;
    Button btn2;
    Button btn3;
    Button btnPlus;
    Button btnCalc;
    TextView lblNumber;
}
