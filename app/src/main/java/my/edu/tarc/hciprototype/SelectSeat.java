package my.edu.tarc.hciprototype;

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
import android.widget.TextView;
public class SelectSeat extends AppCompatActivity {
    Button s3, s4, proceed, btn1;
    TextView selectedSeats, tv15,tv12,tv17,tv14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);
        btn1 = (Button)findViewById(R.id.btnback8);
        btn1.setPaintFlags(btn1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        s3 = findViewById(R.id.button8);
        s4 = findViewById(R.id.button7);
        tv15 = findViewById(R.id.textView15);
        tv12 = findViewById(R.id.textView12);
        tv17 = findViewById(R.id.textView17);
        tv14 = findViewById(R.id.textView14);

        tv12.setVisibility(View.VISIBLE);
        tv14.setVisibility(View.VISIBLE);
        tv15.setVisibility(View.VISIBLE);
        tv17.setVisibility(View.VISIBLE);
        if(EditTicket.editTicket==true){
            tv15.setVisibility(View.GONE);
            tv12.setVisibility(View.GONE);
            tv17.setVisibility(View.GONE);
            tv14.setVisibility(View.GONE);
        }

        proceed = findViewById(R.id.button38);
        selectedSeats = findViewById(R.id.textView16);
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSeats.append("S3, ");
                s3.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedSeats.append("S4");
                s4.setBackgroundColor(Color.parseColor("#ff0099cc"));
            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(!EditTicket.editTicket) {
                    if (PurchaseTicketActivity.secondTicket) {
                        intent = new Intent(SelectSeat.this, SelectBusActivity.class);
                        PurchaseTicketActivity.secondTicket = false;
                    } else
                        intent = new Intent(SelectSeat.this, MakePayment.class);
                }
                else {
                    intent = new Intent(SelectSeat.this, EditTicketSelectedBusActivity.class);
                    EditTicket.editTicket=false;
                }
                startActivity(intent);
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
