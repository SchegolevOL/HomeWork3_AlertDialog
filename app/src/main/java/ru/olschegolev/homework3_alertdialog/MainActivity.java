package ru.olschegolev.homework3_alertdialog;

import static java.lang.String.format;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Button button;
Button buttonDate;
Button buttonTime;
TextView textView;
Calendar dateTime = Calendar.getInstance();
String date = "";
String time ="";
ArrayList<Car> cars = new ArrayList<Car>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Window");
                builder.setMessage("Launching the application window");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        textView = findViewById(R.id.current);
        buttonDate = findViewById(R.id.btn_date);
        buttonTime = findViewById(R.id.btn_time);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date = format("%02d/%02d/%04d", dayOfMonth, month, year);

                        textView.setText(date + " "+ time);
                    }
                },dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time= format("%02d:%02d", hourOfDay, minute);
                        textView.setText(date + " "+ time);
                    }
                }, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycle);
        CarAdapter adapter = new CarAdapter(this, cars);
        recyclerView.setAdapter(adapter);
        cars.add(new Car("BMV", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
        cars.add(new Car("Audi", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
        cars.add(new Car("Tayota", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
        cars.add(new Car("Subaru", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
        cars.add(new Car("Dodg", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
        cars.add(new Car("Kia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
        cars.add(new Car("Ford", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
        cars.add(new Car("Reno", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", R.drawable.ic_launcher_background));
    }
}