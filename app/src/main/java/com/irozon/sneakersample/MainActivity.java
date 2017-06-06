package com.irozon.sneakersample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.irozon.sneaker.Sneaker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btShowError;
    Button btShowSuccess;
    Button btShowWarning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShowError = (Button) findViewById(R.id.btShowError);
        btShowSuccess = (Button) findViewById(R.id.btShowSuccess);
        btShowWarning = (Button) findViewById(R.id.btShowWarning);

        btShowError.setOnClickListener(this);
        btShowSuccess.setOnClickListener(this);
        btShowWarning.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.btShowError:
                Sneaker.with(this)
                        .setTitle("Error!!")
                        .setMessage("This is the error message")
                        .autoHide(false)
                        .setCancelButtonShow(true)
                        .setCancelButtonContent("nonnon")
                        .setOnCancelClickListener(new Sneaker.OnCancelClickListener() {
                            @Override
                            public void onCancelClick(View view) {
                                Log.d("TAG", "已经取消操作！");
                                // do what you needed
                            }
                        })
                        .setTypeface(Typeface.createFromAsset(this.getAssets(), "font/" + "Slabo27px-Regular.ttf"))
                        .sneakError();
                break;
            case R.id.btShowSuccess:
                Sneaker.with(this)
                        .setTitle("Success!!")
                        .setMessage("This is the success message")
                        .setCancelButtonShow(false)
                        .sneakSuccess();
                break;
            case R.id.btShowWarning:
                Sneaker.with(this)
                        .setTitle("Warning!!")
                        .setMessage("This is the warning message")
                        .setCancelButtonShow(false)
                        .sneakWarning();
                break;
        }
    }
}