package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {


        CheckBox toppings = (CheckBox) findViewById(R.id.toppingCheckBox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);


        //-------------------------------------------------------------

        //Add whipped cream? true

        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        EditText nameOfClient = (EditText) findViewById(R.id.name_of_client);

        boolean forLogInfo = toppings.isChecked();
        Log.v("MainActivity", "Has whipped cream " + forLogInfo);

        String nameInfo = nameOfClient.getText().toString();
        Log.v("MainActivity", "name " + nameInfo);

        String name = "Jack";



        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + nameOfClient.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(name));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        orderSummaryTextView.setText(createOrderSummary(name));

    }

    private String createOrderSummary(String name) {

        CheckBox toppings = (CheckBox) findViewById(R.id.toppingCheckBox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        EditText nameOfClient = (EditText) findViewById(R.id.name_of_client);

        return "Name: " + nameOfClient.getText().toString() +
                "\nAdd whipped cream? " + toppings.isChecked() +
                "\nAdd chocolate?  " + chocolate.isChecked() +
                "\nQuantity: " + quantity +
                "\nTotal: $" + calculatePrice(toppings.isChecked(), chocolate.isChecked()) +
                "\nThank you!";
    }


    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        int basePrice = 5;

        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }
        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    public void increment(View view) {

        if (quantity == 100 && quantity >= 100) {

//            Context context = getApplicationContext();
//            CharSequence text = "You can`t take more than 100 cup of coffee ";
//            int duration = Toast.LENGTH_SHORT;
//
//            Toast.makeText(context, text, duration).show();
            Toast toast = Toast.makeText(this, "You can`t take mote than 100 cup of coffee", Toast.LENGTH_SHORT);

            TextView toastColor = (TextView) toast.getView().findViewById(android.R.id.message);
            toastColor.setTextColor(Color.RED);
            toast.show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void dicrement(View view) {

        if (quantity < 2 && quantity == 1) {

//            Context context = getApplicationContext();
//            CharSequence text = "You can`t take less than 1 cup of coffee ";
//            int duration = Toast.LENGTH_SHORT;
//
//            Toast.makeText(context, text, duration).show();

            Toast toast = Toast.makeText(this, "You can`t take less than 1 cup of coffee", Toast.LENGTH_SHORT);

            TextView toastColor = (TextView) toast.getView().findViewById(android.R.id.message);
            toastColor.setBackgroundColor((Color.parseColor("#000000")));
            toastColor.setTextColor(Color.RED);
            toast.show();
            return;
        }

        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    private void displayQuantity(int string) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + string);
    }

}
