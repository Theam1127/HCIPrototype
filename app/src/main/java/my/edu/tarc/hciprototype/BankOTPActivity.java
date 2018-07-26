package my.edu.tarc.hciprototype;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BankOTPActivity extends AppCompatActivity {
    Button confirm, btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_otp);
        btn1 = (Button)findViewById(R.id.btnback3);
        btn1.setPaintFlags(btn1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        confirm = findViewById(R.id.button26);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BankOTPActivity.this, PaymentMadeActivity.class);
                startActivity(intent);
            }
        });
    }
}
