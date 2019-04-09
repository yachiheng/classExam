package tw.org.iii.messagedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActShared extends AppCompatActivity {

    private View.OnClickListener btnSet_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            

        }
    };

    private View.OnClickListener btnGet_click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        InitialComponent();
    }

    private void InitialComponent() {
        btnSet=findViewById(R.id.btnSet);
        btnSet.setOnClickListener(btnSet_click);
        btnGet=findViewById(R.id.btnGet);
        btnGet.setOnClickListener(btnGet_click);
        txtSet=findViewById(R.id.txtSet);
        lblGet=findViewById(R.id.lblGet);
    }

    Button btnSet;
    Button btnGet;
    EditText txtSet;
    TextView lblGet;
}
