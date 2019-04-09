package tw.org.iii.customersystemapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActMain extends Activity {
    CCustomerFactory factory = new CCustomerFactory();

    private View.OnClickListener btnFirst_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            factory.MoveToFirst();
            CCustomer data=factory.GetCurrent();
            DisplayCustomerInfo(data);

        }
    };

    private void DisplayCustomerInfo(CCustomer p) {
        txtId.setText(p.getId());
        txtName.setText(p.getName());
        txtPhone.setText(p.getPhone());
        txtEmail.setText(p.getEmail());
        txtAddress.setText(p.getAddress());
    }

    private View.OnClickListener btnPrevious_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener btnNext_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener btnLast_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CDictionary.ACTID_ACTLIST)
        {
            if(data==null ||data.getExtras()==null)
                return;
            int index=data.getExtras().getInt(CDictionary.BK_SELECTED_INDEX);
            factory.MoveTo(index);
            DisplayCustomerInfo(factory.GetCurrent());
        }
    }

    private View.OnClickListener btnList_click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            String[] customers=new String[factory.GetAll().length];
            int count=0;
            for(CCustomer c : factory.GetAll()){
                customers[count]=c.getName();
                count++;
            }
            Bundle bund = new Bundle();
            bund.putStringArray(CDictionary.BK_CUSTOMER_ITEMS_LIST,customers);
            Intent intent=new Intent(ActMain.this,ActList.class);
            intent.putExtras(bund);
            startActivityForResult(intent,CDictionary.ACTID_ACTLIST);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();
    }

    private void InitialComponent() {

        txtId=(EditText)findViewById(R.id.txtId);
        txtName=(EditText)findViewById(R.id.txtName);
        txtPhone=(EditText)findViewById(R.id.txtPhone);
        txtEmail=(EditText)findViewById(R.id.txtEmail);
        txtAddress=(EditText)findViewById(R.id.txtAddress);
        btnFirst=(Button)findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(btnFirst_click);
        btnPrevious=(Button)findViewById(R.id.btnPrevious);
        btnPrevious.setOnClickListener(btnPrevious_click);
        btnNext=(Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(btnNext_click);
        btnLast=(Button)findViewById(R.id.btnLast);
        btnLast.setOnClickListener(btnLast_click);
        btnList=(Button)findViewById(R.id.btnList);
        btnList.setOnClickListener(btnList_click);


    }


    EditText txtId;
    EditText txtName;
    EditText txtPhone;
    EditText txtEmail;
    EditText txtAddress;
    Button btnFirst;
    Button btnPrevious;
    Button btnNext;
    Button btnLast;
    Button btnList;
}
