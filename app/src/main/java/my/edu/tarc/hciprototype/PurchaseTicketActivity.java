package my.edu.tarc.hciprototype;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    TextView dateSelectTV, dateSelect2TV;
    String date, date2;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_ticket);

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
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
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
                datePickerDialog.show();
            }
        });

        dateSelect2TV = (TextView)findViewById(R.id.dateSelect2TV);
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
                datePickerDialog.show();
            }
        });
    }
}
