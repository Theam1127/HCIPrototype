package my.edu.tarc.hciprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SelectTaskActivity extends AppCompatActivity {
    Button purchaseTicket, modifyTicket, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_task);
        purchaseTicket = findViewById(R.id.purchaseticketButton);
        modifyTicket = findViewById(R.id.modifyticketButton);
        logout = findViewById(R.id.logoutButton);
        purchaseTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTaskActivity.this,PurchaseTicketActivity.class);
                startActivity(intent);
            }
        });

        modifyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTaskActivity.this, ViewModifyTicket.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTaskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
