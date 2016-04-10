package com.amrutpatil.makeanote;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Amrut on 4/1/16.
 */
public class MakeANoteAppWidgetConfigure extends BaseGoogleDriveActivity{

    static final String TAG = MakeANoteAppWidgetConfigure.class.getCanonicalName();
    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
    ImageView mAppWidgetNote;
    ImageView mAppWidgetListNote;
    TextView mTextView;

    public MakeANoteAppWidgetConfigure() {
        super();
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Set the result to CANCELED.  This will cause the widget host to cancel
        // out of the widget placement if they press the back button.
        setResult(RESULT_CANCELED);
        // Set the view layout resource to use.
        setContentView(R.layout.makeanote_appwidget);

        //Find the ImageView
        mAppWidgetNote = (ImageView) findViewById(R.id.action_note_widget);
        mAppWidgetListNote = (ImageView) findViewById(R.id.action_list_note_widget);

        // Bind the action.
        findViewById(R.id.action_note_widget).setOnClickListener(mOnClickNoteListener);
        findViewById(R.id.action_list_note_widget).setOnClickListener(mOnClickListNoteListener);
        // Find the widget id from the intent.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        // If they gave us an intent without the widget id, just bail.
        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
        }
    }

    View.OnClickListener mOnClickNoteListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.v(TAG, "Note in App Widget configure invoked");
            final Context context = MakeANoteAppWidgetConfigure.this;
            //When camera icon is clicked, launch camera
            Intent intent = new Intent(MakeANoteAppWidgetConfigure.this, NoteDetailActivity.class);
            startActivity(intent);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            //Make sure we pass back the original appWidgetId
            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            setResult(RESULT_OK, resultValue);
            finish();
        }
    };

    View.OnClickListener mOnClickListNoteListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.v(TAG, "List Note in App Widget configure invoked");
            final Context context = MakeANoteAppWidgetConfigure.this;
            //When camera icon is clicked, launch camera
            Intent intent = new Intent(MakeANoteAppWidgetConfigure.this, NoteDetailActivity.class);
            startActivity(intent);
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            //Make sure we pass back the original appWidgetId
            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            setResult(RESULT_OK, resultValue);
            finish();
        }
    };



    @Override
    public void onConnectionSuspended(int i) {

    }
}
