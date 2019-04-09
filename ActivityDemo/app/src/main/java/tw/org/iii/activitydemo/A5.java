package tw.org.iii.activitydemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class A5 extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] users={"Marco","Tom","Jason","Selina","Mark","July",
                "Mark","Tomy","Jessie","Sandy","Mary","Julia",
                "Mary","Bill","Jacky","Wang","Matt"};


        ListAdapter adapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                users);

        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


        Log.i("LIST_DEMO",String.valueOf(position));
    }
}
