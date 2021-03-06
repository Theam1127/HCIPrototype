package my.edu.tarc.hciprototype;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class PurchaseTicketActivity extends AppCompatActivity {

    int day_calendar1 = 0;
    int month_calendar1 = 0;
    int year_calendar1 = 0;
    int day_calendar2 = 0;
    int month_calendar2 = 0;
    int year_calendar2 = 0;
    CheckBox checkbox;
    TextView dateSelectTV, dateSelect2TV, tv2,tv3,tv4,tv6;
    Spinner spinner5, spinner6, spinner8;
    Button proceed, btn1;
    String date, date2;
    DatePickerDialog datePickerDialog;
    java.sql.Date boardDate;
    static boolean secondTicket;
    static String trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_ticket);
        btn1 = (Button)findViewById(R.id.btnback6);
        btn1.setPaintFlags(btn1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        checkbox = findViewById(R.id.checkBox);
        proceed = findViewById(R.id.proceedButton);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv6 = findViewById(R.id.textView6);
        spinner5 = findViewById(R.id.spinner5);
        spinner6 = findViewById(R.id.spinner6);
        spinner8 = findViewById(R.id.spinner8);
        secondTicket = false;

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PurchaseTicketActivity.this, SelectBusActivity.class);
                startActivity(intent);
            }
        });

        dateSelect2TV = (TextView)findViewById(R.id.dateSelect2TV);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    tv4.setVisibility(View.VISIBLE);
                    tv6.setVisibility(View.VISIBLE);
                    spinner5.setVisibility(View.VISIBLE);
                    spinner6.setVisibility(View.VISIBLE);
                    spinner8.setVisibility(View.VISIBLE);
                    dateSelect2TV.setVisibility(View.VISIBLE);
                }
                else{
                    tv2.setVisibility(View.GONE);
                    tv3.setVisibility(View.GONE);
                    tv4.setVisibility(View.GONE);
                    tv6.setVisibility(View.GONE);
                    spinner5.setVisibility(View.GONE);
                    spinner6.setVisibility(View.GONE);
                    spinner8.setVisibility(View.GONE);
                    dateSelect2TV.setVisibility(View.GONE);
                }
                secondTicket ^= true;
            }
        });

        dateSelectTV = (TextView)findViewById(R.id.dateSelectTV);
        dateSelectTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                if(day_calendar1 == 0 && month_calendar1 == 0 && year_calendar1 == 0) {
                    day_calendar1 = calendar.get(Calendar.DAY_OF_MONTH);
                    month_calendar1 = calendar.get(Calendar.MONTH);
                    year_calendar1 = calendar.get(Calendar.YEAR);
                }

                datePickerDialog = new DatePickerDialog(PurchaseTicketActivity.this, new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {


                        day_calendar1 = day;
                        month_calendar1 = month;
                        year_calendar1 = year;

                        int month1 = month + 1;


                        date = day + "/" + month1 + "/" + year;
                        dateSelectTV.setText(date);
                        dateSelectTV.setTextColor(Color.BLACK);
                    }
                }, year_calendar1, month_calendar1, day_calendar1);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();

            }
        });


        dateSelect2TV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                if(day_calendar2 == 0 && month_calendar2 == 0 && year_calendar2 == 0) {
                    day_calendar2 = calendar.get(Calendar.DAY_OF_MONTH);
                    month_calendar2 = calendar.get(Calendar.MONTH);
                    year_calendar2 = calendar.get(Calendar.YEAR);
                }
                DatePickerDialog datePickerDialog = new DatePickerDialog(PurchaseTicketActivity.this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        day_calendar2 = day;
                        month_calendar2 = month;
                        year_calendar2 = year;

                        int month1 = month + 1;

                        date = day + "/" + month1 + "/" + year;
                        dateSelect2TV.setText(date);
                        dateSelect2TV.setTextColor(Color.BLACK);
                    }
                }, year_calendar2, month_calendar2, day_calendar2);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.home_button){
            Intent intent = new Intent(this, SelectTaskActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
