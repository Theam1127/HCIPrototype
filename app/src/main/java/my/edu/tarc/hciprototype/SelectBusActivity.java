package my.edu.tarc.hciprototype;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectBusActivity extends AppCompatActivity {
    ImageView busButton;
    Button btn1;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_bus);
        btn1 = (Button)findViewById(R.id.btnback7);
        btn1.setPaintFlags(btn1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        busButton = findViewById(R.id.imageView);
        busButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectBusActivity.this, SelectSeat.class);
                startActivity(intent);
            }
        });
        title = findViewById(R.id.textView69);
        if(PurchaseTicketActivity.secondTicket)
            title.setText("Kepong ==> Ipoh");
        else
            title.setText("Ipoh ==> Kepong");
    }

}
