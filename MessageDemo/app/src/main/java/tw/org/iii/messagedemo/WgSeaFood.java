package tw.org.iii.messagedemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WgSeaFood extends AppWidgetProvider {


    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        for (int i = 0; i < appWidgetIds.length; i++) {

            RemoteViews views = new RemoteViews(
                    context.getPackageName(),
                    R.layout.actmain);

            Intent intent = new Intent(context, ActMain.class);


            views.setOnClickPendingIntent(R.id.img,
                    PendingIntent.getActivity(context, 0, intent, 0));

            appWidgetManager.updateAppWidget(appWidgetIds, views);
        }

    }




}

