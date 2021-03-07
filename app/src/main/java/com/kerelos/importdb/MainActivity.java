package com.kerelos.importdb;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

//  After databaase helper  That’s it.
//Now you can create a new instance of this DataBaseHelper class and call the createDataBase() and openDataBase() methods.
// Remember to change the “YOUR_PACKAGE” to your application package namespace (i.e: com.examplename.myapp) in the DB_PATH string.


public class MainActivity extends AppCompatActivity {

    Button btnDate , btntest;
    Calendar calendar;
    private DatePickerDialog dpd;
SimpleDateFormat dateFormat ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = findViewById( R.id.btnDate);
        btntest = findViewById(R.id.btntest);

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Todo test

            }
        });


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateMethod( btnDate );
            }
        });

    }

    // For the date
    private void dateMethod (final Button btn){

        calendar = java.util.Calendar.getInstance() ;

        // the day, month and year of birth.
        int day = calendar.get(java.util.Calendar.DAY_OF_MONTH);

        int month = calendar.get(java.util.Calendar.MONTH);
        int year = calendar.get(java.util.Calendar.YEAR);
        // Add month column

        dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {

                String nd = "" + mdayOfMonth;
                String nm = "" ;
                if ( mdayOfMonth < 10 ){
                        nd = "0"+ mdayOfMonth;
                }


                if ( (mmonth + 1) < 10){
                    nm = "0"+ ( mmonth +1 ) ;
                }else {
                    nm = ""+ ( mmonth + 1) ;
                }
                Log.d("testValue" , String.valueOf( mmonth ));

                // for button text
                btn.setText( ( myear + "-" +  nm + "-" + nd));

            }
        },year,month,day );
        dpd.show();

    }
    // End of getting thr date


}
