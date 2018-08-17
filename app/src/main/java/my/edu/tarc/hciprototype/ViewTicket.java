package my.edu.tarc.hciprototype;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ViewTicket extends AppCompatActivity {
    Button edit, btn1, btnPrint;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ticket);
        btn1 = (Button)findViewById(R.id.btnback10);
        btnPrint = (Button)findViewById(R.id.button34);
        btn1.setPaintFlags(btn1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        edit = findViewById(R.id.button35);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewTicket.this, EditTicket.class);
                startActivity(intent);
            }
        });
        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd = new ProgressDialog(ViewTicket.this);
                pd.setMessage("Downloading...");
                pd.show();

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        pd.dismiss();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 3000);

                pd.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ViewTicket.this);
                        alertDialog.setMessage("Download Complete!").setPositiveButton("Ok", null).show();
                    }
                });
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
