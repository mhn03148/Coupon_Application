package com.example.coupon_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnUse;
    private Integer count = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView amount = (TextView) findViewById(R.id.amount);
        Log.d(this.getClass().getName(), (String) amount.getText());

        amount.setText(count + " 개");

        btnUse = findViewById(R.id.usebutton);
        btnUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                if (count < 0) {
                    amount.setText("0 개");
                    showDialog();
                } else {
                    amount.setText(count + " 개");
                }
            }
        });
    }
    void showDialog() {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this)
                .setTitle("개수부족!")
                .setMessage("쿠폰의 개수가 부족해요!")
                .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }
}