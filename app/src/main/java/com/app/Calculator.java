package com.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.Expression;

public class Calculator extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button dzero;
    private Button add;
    private Button sub;
    private Button multi;
    private Button div;
    private Button equal;
    private Button dot;
    private Button per;
    private Button back;
    private Button erase;
    private EditText input;
    private EditText output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setupUIViews();
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '0');
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '1');
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '2');
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '3');
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '4');
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '5');
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '6');
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '7');
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '8');
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '9');
            }
        });
        dzero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '0' + '0');
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString() + '.');
            }
        });
       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               input.setText(input.getText().toString()+'+');
           }
       });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+'-');
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+'*');
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+'/');
            }
        });

        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText('('+input.getText().toString()+'*'+'1'+'0'+'0'+')'+'/');
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneq();
                /*Operate=Equal;
                output.setText(String.valueOf(val1));*/
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().length() > 0) {
                    CharSequence number = input.getText().toString();
                    input.setText(number.subSequence(0, number.length() - 1));
                }
            }
        });
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(null);
                output.setText(null);
            }
        });
    }

    private void setupUIViews() {
        input = (EditText) findViewById(R.id.input);
        output = (EditText) findViewById(R.id.res);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        dzero = (Button) findViewById(R.id.dz);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.min);
        div = (Button) findViewById(R.id.div);
        multi = (Button) findViewById(R.id.mul);
        erase = (Button) findViewById(R.id.del);
        back = (Button) findViewById(R.id.back);
        dot = (Button) findViewById(R.id.dot);
        equal = (Button) findViewById(R.id.eql);
        per = (Button) findViewById(R.id.per);
    }

    private void oneq() {
        String txt = input.getText().toString();
        // Create an Expression (A class from exp4j library)
        Expression expression = new ExpressionBuilder(txt).build();
        try {
            // Calculate the result and display
            double result = expression.evaluate();
            output.setText(Double.toString(result));
        } catch (ArithmeticException ex) {
            // Display an error message
            input.setText("Error");
        }
    }
}