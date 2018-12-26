package com.example.timer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    Dialog dialog;
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        public void run() {
            dialog.dismiss();
            Context context = getApplicationContext();
            Toast.makeText(context , "一定時間経過したのでdialogを閉じてやりました", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("テストでーす")
                .setMessage("一定時間経過すれば消えます")
                .setPositiveButton(android.R.string.ok, new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Context context = getApplicationContext();
                                Toast.makeText(context , "手動で閉じました", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.show();
                handler.postDelayed(r, 5000);
            }
        });
    }
}

