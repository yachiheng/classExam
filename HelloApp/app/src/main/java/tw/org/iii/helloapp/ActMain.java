package tw.org.iii.helloapp;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActMain extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);
        InitialComponent();
    }


    @Override
    public void onClick(View v) {

        lblLotto.setText((new CLottoGen()).GetLottos());
    }


    private void InitialComponent() {
        lblLotto = findViewById(R.id.lblHello);
        btn=findViewById(R.id.btnOk);
        btn.setOnClickListener(this);
    }
    Button btn;
    TextView lblLotto;
}
