package dam.android.angelvilaplana.u3t1initialapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Main Application
 * Increase or decrease the counter
 */
public class U3T1InitialAppActivity extends AppCompatActivity implements OnClickListener {

    // Counter
    private int count;

    // TextView show the counter
    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3_t1_initial_app);

        // Build the UI
        setUI();
    }

    private void setUI() {
        tvDisplay = findViewById(R.id.tvDisplay);
        Button buttonIncrease1 = findViewById(R.id.buttonIncrease1);
        Button buttonIncrease2 = findViewById(R.id.buttonIncrease2);
        Button buttonDecrease1 = findViewById(R.id.buttonDecrease1);
        Button buttonDecrease2 = findViewById(R.id.buttonDecrease2);
        Button buttonReset = findViewById(R.id.buttonReset);

        buttonIncrease1.setOnClickListener(this);
        buttonIncrease2.setOnClickListener(this);
        buttonDecrease1.setOnClickListener(this);
        buttonDecrease2.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Check which button was clicked
        switch (view.getId()) {
            case R.id.buttonIncrease1:
                count++;
                break;
            case R.id.buttonIncrease2:
                count += 2;
                break;
            case R.id.buttonDecrease1:
                count--;
                break;
            case R.id.buttonDecrease2:
                count -= 2;
                break;
            case R.id.buttonReset:
                count = 0;
                break;
        }

        // Show counter in the TextView
        tvDisplay.setText(getString(R.string.number_of_elements) + ": " + count);
    }

    /**
     * Recover data
     * @param savedInstanceState where the data is retrieved
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        tvDisplay.setText(savedInstanceState.getString("tvDisplay"));
    }

    /**
     * Save data
     * @param outState Where save the data
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("count", count);
        outState.putString("tvDisplay", tvDisplay.getText().toString());
        super.onSaveInstanceState(outState);
    }

}