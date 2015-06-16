package com.example.zhhan.activitylifecycle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private MyService myService;
    private TextView mTextView;
    private Button startServiceButton;
    private Button stopServiceButton;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
//        Button button = (Button)this.findViewById(R.id.startservice);
//        button.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent = new Intent(MainActivity.this, NewActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("name", "zhhan");
//                bundle.putInt("age", 30);
//                intent.putExtras(bundle);
//                startActivityForResult(intent, 1);
//
//            }
//        });
    }

    private void setupViews() {
        mContext = MainActivity.this;
        mTextView = (TextView)findViewById(R.id.textView);

        startServiceButton = (Button)findViewById(R.id.startservice);
        stopServiceButton = (Button)findViewById(R.id.stopservice);

        startServiceButton.setOnClickListener(this);
        stopServiceButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        String result = data.getStringExtra("result");

//        TextView textView = (TextView)this.findViewById(R.id.textView);
//        textView.

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v==startServiceButton){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MyService.class);
            mContext.startService(intent);
        }else if(v==stopServiceButton){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MyService.class);
            mContext.stopService(intent);
        }

    }
}
