package my.edu.tarc.hciprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModifiedTicketActivity extends AppCompatActivity {
    Button backtohome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modified_ticket);
        backtohome = findViewById(R.id.button28);
        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModifiedTicketActivity.this, SelectTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}
