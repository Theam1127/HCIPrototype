package my.edu.tarc.hciprototype;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewTicket extends AppCompatActivity {
    Button edit, btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ticket);
        btn1 = (Button)findViewById(R.id.btnback10);
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
    }
}
