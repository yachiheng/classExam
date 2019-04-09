package tw.org.iii.customersystemapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ActList extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        String[] customers=getIntent().getExtras().getStringArray(
                CDictionary.BK_CUSTOMER_ITEMS_LIST);

        ListAdapter adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                customers);

        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bund  = new Bundle();
        bund.putInt(CDictionary.BK_SELECTED_INDEX,position);
        Intent intent = new Intent();
        intent.putExtras(bund);
        setResult(0,intent);
        finish();
    }
}
