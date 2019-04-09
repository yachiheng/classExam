package tw.org.iii.messagedemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ActMain extends Activity {

    private View.OnClickListener btnShared_click =new View.OnClickListener(){
        public void onClick(View v) {
            startActivity(new Intent(ActMain.this,ActShared.class));


        }
    };


    private View.OnClickListener btnFile_click =new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener btnSqlite_click =new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();
    }

    private void InitialComponent() {
        lblTitle=findViewById(R.id.lblTitle);
        btnShared =findViewById(R.id.btnBShared);
        btnShared.setOnClickListener(btnShared_click);
        btnFile =findViewById(R.id.btnFile);
        btnFile.setOnClickListener(btnFile_click);
        btnSqlite =findViewById(R.id.btnSqlite);
        btnSqlite.setOnClickListener(btnSqlite_click);

        registerForContextMenu(lblTitle);
    }
    TextView lblTitle;
    Button btnShared;
    Button btnFile;
    Button btnSqlite;

}
