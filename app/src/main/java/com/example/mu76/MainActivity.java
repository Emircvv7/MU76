package com.example.mu76;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, sum;
    private String operation;
    private Boolean isOperationClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void oneNumberClick(View view) {
        String number = ((MaterialButton) view).getText().toString();
        if (number.equals("AC")){
            textView.setText("0");
            first = 0;
            second = 0;
            operation = null;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        isOperationClick = false;
    }

    public void oneOperationClick(View view) {
        String currentOperation = ((MaterialButton) view).getText().toString();
        if (operation != null && !isOperationClick) {
            second = Integer.valueOf(textView.getText().toString());
            calculateResult();
            operation = currentOperation;
        } else {
            first = Integer.valueOf(textView.getText().toString());
            operation = currentOperation;
        }

        isOperationClick = true;
    }

    private void calculateResult() {
        if (operation != null) {
            switch (operation) {
                case "+":
                    sum = first + second;
                    break;
                case "-":
                    sum = first - second;
                    break;
                case "x":
                    sum = first * second;
                    break;
                case "÷":
                    if (second != 0) {
                        sum = first / second;
                    } else {

                    }
                    break;
            }
            textView.setText(sum.toString());
            first = sum;
        }
    }
}
