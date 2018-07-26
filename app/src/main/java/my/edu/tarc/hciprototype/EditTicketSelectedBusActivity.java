package my.edu.tarc.hciprototype;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditTicketSelectedBusActivity extends AppCompatActivity {
    Button done, btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ticket_selected_bus);
        btn1 = (Button)findViewById(R.id.btnback5);
        btn1.setPaintFlags(btn1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        done = findViewById(R.id.button36);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditTicketSelectedBusActivity.this, ModifiedTicketActivity.class);
                startActivity(intent);
            }
        });
    }
}
