package com.example.user.guardianangel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainFunctionMenu extends AppCompatActivity {

    private View.OnClickListener btnMedicineNotice_click=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainFunctionMenu.this,A2.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_function_menu);
        InitialComponent();
    }

    private void InitialComponent() {
        btnMedicineNotice=findViewById(R.id.btnMedicineNotice);
        btnMedicineNotice.setOnClickListener(btnMedicineNotice_click);
        btnTakecare=findViewById(R.id.btnTakecare);
        btnGPS=findViewById(R.id.btnGPS);
        btnUnusualRecord=findViewById(R.id.btnUnusualRecord);
        btnEmergencyContact=findViewById(R.id.btnEmergencyContact);
        btnOtherConfig=findViewById(R.id.btnOtherConfig);

    }
    Button btnMedicineNotice;
    Button btnTakecare;
    Button btnGPS;
    Button btnUnusualRecord;
    Button btnEmergencyContact;
    Button btnOtherConfig;
}
