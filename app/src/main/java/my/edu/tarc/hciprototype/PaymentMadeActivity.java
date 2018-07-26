package my.edu.tarc.hciprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentMadeActivity extends AppCompatActivity {
    Button backToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_made);
        backToHome = findViewById(R.id.button28);
        backToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentMadeActivity.this, SelectTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}
