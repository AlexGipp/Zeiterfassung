package de.alexgipp.zeiterfassung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText _startDateTime;
    private EditText _endDateTime;
    private Button _startCommand;
    private Button _endCommand;

    private DateFormat _dateFormatter;
    private DateFormat _timeFormatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _startDateTime = findViewById(R.id.StartDateTime);
        _endDateTime = findViewById(R.id.EndDateTime);
        _startCommand = findViewById(R.id.StartCommand);
        _endCommand = findViewById(R.id.EndCommand);

        _dateFormatter = android.text.format.DateFormat.getDateFormat(this);
        _timeFormatter = android.text.format.DateFormat.getTimeFormat(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        _startCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _startDateTime.setText(getCurrentDateTime());
            }
        });

        _endCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _endDateTime.setText(getCurrentDateTime());
            }
        });
    }

    private String getCurrentDateTime() {
        Calendar currentTime = Calendar.getInstance();
        return String.format(
                "%S %S",
                _dateFormatter.format(currentTime.getTime()),
                _timeFormatter.format(currentTime.getTime())
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        _startCommand.setOnClickListener(null);
        _endCommand.setOnClickListener(null);
    }
}