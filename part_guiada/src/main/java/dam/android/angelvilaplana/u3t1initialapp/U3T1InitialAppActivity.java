package dam.android.angelvilaplana.u3t1initialapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class U3T1InitialAppActivity extends AppCompatActivity implements OnClickListener {

    private int count;

    private TextView tvDisplay;
    private Button buttonIncrease, buttonDecrease, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3_t1_initial_app);

        setUI();
    }

    private void setUI() {
        tvDisplay = findViewById(R.id.tvDisplay);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonReset = findViewById(R.id.buttonReset);

        buttonIncrease.setOnClickListener(this);
        buttonDecrease.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonIncrease:
                count++;
                break;
            case R.id.buttonDecrease:
                count--;
                break;
            case R.id.buttonReset:
                count = 0;
                break;
        }

        tvDisplay.setText(getString(R.string.number_of_elements) + ": " + count);
    }
}