package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText input= findViewById(R.id.textView5);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        TextView amount_percent= (TextView)findViewById(R.id.textView2);
        TextView tips_amount = (TextView) findViewById(R.id.textView7);
        TextView total_amount = (TextView) findViewById(R.id.textView8);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                amount_percent.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(!input.getText().toString().equals("")&&!amount_percent.getText().toString().equals("TIPS")){
                float temp1 = Float.parseFloat(input.getText().toString());
                float temp2 = Float.parseFloat(amount_percent.getText().toString());
                float temp3 = temp2/100;
                tips_amount.setText(String.valueOf(temp1*temp3));
                total_amount.setText(String.valueOf(temp1*(1+temp3)));
            }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        input.addTextChangedListener(textWatcher);
        amount_percent.addTextChangedListener((textWatcher));
    }

}