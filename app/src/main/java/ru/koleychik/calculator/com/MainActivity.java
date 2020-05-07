package ru.koleychik.calculator.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.MathContext;


public class MainActivity extends AppCompatActivity {

    TextView text;
    ImageView btndivide;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnplus, btnpmines, btnpoint, btnmutliply, btnqually, btnclear, btnpower;
    String string_str;

    BigDecimal decimal1, decimal2, decimal3;
    StringBuilder string = new StringBuilder(), numb_string = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        btndivide = findViewById(R.id.buttondivide);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.buttonzero);
        btnplus = findViewById(R.id.buttonplus);
        btnpmines = findViewById(R.id.buttonmines);
        btnpoint = findViewById(R.id.buttonpoint);
        btnmutliply = findViewById(R.id.buttonmultiply);
        btnqually = findViewById(R.id.buttonqually);
        btnclear = findViewById(R.id.buttonclear);
        btnpower = findViewById(R.id.buttonpower);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        Draw_str("1");
                        available_buttons();
                        break;

                    case R.id.button2:
                        Draw_str("2");
                        available_buttons();
                        break;

                    case R.id.button3:
                        Draw_str("3");
                        available_buttons();
                        break;

                    case R.id.button4:
                        Draw_str("4");
                        available_buttons();
                        break;

                    case R.id.button5:
                        Draw_str("5");
                        available_buttons();
                        break;

                    case R.id.button6:
                        Draw_str("6");
                        available_buttons();
                        break;

                    case R.id.button7:
                        Draw_str("7");
                        available_buttons();
                        break;

                    case R.id.button8:
                        Draw_str("8");
                        available_buttons();
                        break;

                    case R.id.button9:
                        Draw_str("9");
                        available_buttons();
                        break;

                    case R.id.buttonzero:
                        Draw_str("0");
                        available_buttons();
                        break;

                    case R.id.buttonpoint:
                        Draw_str(".");
                        btnpoint.setEnabled(false);
                        break;

                    case R.id.buttonclear:
                        clear();
                        break;


                    case R.id.buttonpower:
                        res();
                        string.append(" ^ ");
                        numb_string = new StringBuilder();
                        inaccessible_buttons();
                        text.setText(string);
                        break;


                    case R.id.buttonplus:
                        res();
                        string.append(" + ");
                        numb_string = new StringBuilder();
                        inaccessible_buttons();
                        text.setText(string);
                        break;

                    case R.id.buttonmines:
                        res();
                        string.append(" - ");
                        numb_string = new StringBuilder();
                        inaccessible_buttons();
                        text.setText(string);
                        break;

                    case R.id.buttonmultiply:
                        res();
                        string.append(" * ");
                        numb_string = new StringBuilder();
                        inaccessible_buttons();
                        text.setText(string);
                        break;

                    case R.id.buttondivide:
                        res();
                        string.append(" / ");
                        numb_string = new StringBuilder();
                        inaccessible_buttons();
                        text.setText(string);
                        break;

                    case R.id.buttonqually:
                        res();
                        if (search_point(string)) {
                            btnpoint.setEnabled(false);
                        } else {
                            btnpoint.setEnabled(true);
                        }
                        text.setText(string);
                        break;
                }
            }
        };

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        btn0.setOnClickListener(onClickListener);
        btnpmines.setOnClickListener(onClickListener);
        btnplus.setOnClickListener(onClickListener);
        btndivide.setOnClickListener(onClickListener);
        btnmutliply.setOnClickListener(onClickListener);
        btnpoint.setOnClickListener(onClickListener);
        btnqually.setOnClickListener(onClickListener);
        btnclear.setOnClickListener(onClickListener);
        btnpower.setOnClickListener(onClickListener);
    }

    private void Draw_str(String str_num) {
        check_string();
        numb_string.append(str_num);
        string.append(str_num);
        text.setText(string);
    }

    private void res() {

        if (check(string) == 0) {
            try {
                decimal1 = new BigDecimal(numb_string.toString());
            }
            catch (Exception e){
                Toast toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                toast.show();
                clear();
            }
        }
        else if (check(string) == 1) {
            decimal2 = new BigDecimal(numb_string.toString());
            decimal3 = decimal1.add(decimal2);
            try{
                decimal1 = decimal3;
                string = new StringBuilder(String.valueOf(decimal3));
                numb_string = new StringBuilder(String.valueOf(decimal3));
            }
            catch (Exception e){
                Toast toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                toast.show();
                clear();
            }
        }
        else if (check(string) == 2) {
            decimal2 = new BigDecimal(numb_string.toString());
            decimal3 = decimal1.subtract(decimal2);
            try{
                decimal1 = decimal3;
                string = new StringBuilder(String.valueOf(decimal3));
                numb_string = new StringBuilder(String.valueOf(decimal3));
            }
            catch (Exception e) {
                Toast toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                toast.show();
                clear();
            }
        }
        else if (check(string) == 3) {
            decimal2 = new BigDecimal(numb_string.toString());
            decimal3 = decimal1.multiply(decimal2);
            try{
                decimal1 = decimal3;
                string = new StringBuilder(String.valueOf(decimal3));
                numb_string = new StringBuilder(String.valueOf(decimal3));
            }
            catch (Exception e){
                Toast toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                toast.show();
                clear();
            }
        }
        else if (check(string) == 4) {
            decimal2 = new BigDecimal(numb_string.toString());
            int number = decimal2.intValue();
            if (number == 0){
                Toast toast = Toast.makeText(MainActivity.this, "На ноль делить нельзя", Toast.LENGTH_LONG);
                toast.show();
                clear();
                return;
            }
            decimal3 = decimal1.divide(decimal2, MathContext.DECIMAL32);
            try{
                decimal1 = decimal3;
                string = new StringBuilder(String.valueOf(decimal3));
                numb_string = new StringBuilder(String.valueOf(decimal3));
            }
            catch (Exception e) {
                Toast toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                toast.show();
                clear();
            }
        }
        else if (check(string) == 5) {
            decimal2 = new BigDecimal(numb_string.toString());
            double decimal1_dbl = decimal1.doubleValue(), decimal2_dbl = decimal2.doubleValue();
            double decimal3_dbl = Math.pow(decimal1_dbl, decimal2_dbl);
            try {
                decimal3 = new BigDecimal(decimal3_dbl);
                decimal1 = decimal3;
                string = new StringBuilder(String.valueOf(decimal3));
                numb_string = new StringBuilder(String.valueOf(decimal3));
            }
            catch (Exception e){
                Toast toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                toast.show();
                clear();
            }

        }
    }


    private int check(StringBuilder string) {
        cant_choose_signs();

        string_str = string.toString();
        char[] array = string_str.toCharArray();

        if (array[0] == '-' & array.length == 1){
            return 6;
        }
        else if (array[0] == '-') {
            array[0] = ' ';
        }
        for (char i : array) {
            switch (i) {
                case '+':
                    return 1;
                case '-':
                    return 2;
                case '*':
                    return 3;
                case '/':
                    return 4;
                case '^':
                    return 5;
            }
        }
        return 0;
    }

    private void inaccessible_buttons() {
        btnmutliply.setEnabled(false);
        btnplus.setEnabled(false);
        btnpmines.setEnabled(false);
        btnplus.setEnabled(false);
        btnpoint.setEnabled(true);
        btnqually.setEnabled(false);
    }

    private void available_buttons() {
        btnmutliply.setEnabled(true);
        btnplus.setEnabled(true);
        btnpmines.setEnabled(true);
        btnplus.setEnabled(true);
        btnqually.setEnabled(true);
    }

    private boolean search_point(StringBuilder string) {
        string_str = string.toString();
        char[] array = string_str.toCharArray();
        for (char i : array) {
            switch (i) {
                case '.':
                    return true;
            }
        }
        return false;
    }

    private void clear(){
        numb_string = new StringBuilder();
        string = new StringBuilder();
        text.setText(string);
    }

    private void cant_choose_signs(){
        if (!check_first_numd()){
            string.append("0");
            numb_string.append("0");
        }
    }

    private boolean check_first_numd() {
        String numb_str = string.toString();
        if (numb_str == "") {
            return false;
        }
        return true;
    }

    private void check_string(){
        if (string.length() == 32){
            View.OnClickListener second_onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.button1:
                            Toast toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button2:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button3:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button4:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button5:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button6:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button7:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button8:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.button9:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();
                        case R.id.buttonzero:
                            toast = Toast.makeText(MainActivity.this, "Число слишком большое", Toast.LENGTH_LONG);
                            toast.show();
                            clear();

                    }
                }
            };
            btn0.setOnClickListener(second_onClickListener);
            btn1.setOnClickListener(second_onClickListener);
            btn2.setOnClickListener(second_onClickListener);
            btn3.setOnClickListener(second_onClickListener);
            btn4.setOnClickListener(second_onClickListener);
            btn5.setOnClickListener(second_onClickListener);
            btn6.setOnClickListener(second_onClickListener);
            btn7.setOnClickListener(second_onClickListener);
            btn8.setOnClickListener(second_onClickListener);
            btn9.setOnClickListener(second_onClickListener);
        }
    }


}
