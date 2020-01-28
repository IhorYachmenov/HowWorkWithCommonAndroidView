package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

       String message =  "Amount due " + (quantity * 5) +
               "\nThat would be $" + (quantity * 5) + " please." +
               "\nYou owe " + (quantity * 5) + " bucks, dude!" +
               "\n" + (quantity * 5) + " dollars for " + quantity + " cups of coffee. Pay up." +
               "\nTotal = $" + (quantity * 5);

       int price = calculatePrice();
       String priceMessage = "Total: $" + price;
       message = message + "\nWhoo";

       //-------------------------------------------------------------

        //Add whipped cream? true

        CheckBox toppings = (CheckBox) findViewById(R.id.toppingCheckBox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        Button orderButton = (Button) findViewById(R.id.order_button);

        boolean forLogInfo = toppings.isChecked();
        Log.v("MainActivity", "Has whipped cream " + forLogInfo);

        String name = "Jack";
        // displayMessage(createOrderSummary(name));

        /*if (orderButton.isPressed() && toppings.isChecked()) {
            displayMessage(createOrderSummary(name));
            orderSummaryTextView.setText(createOrderSummary(name));
        } else {
            //orderSummaryTextView.setText("Please select a toppings");
            orderSummaryTextView.setText(createOrderSummary(name));

        }*/
        //displayMessage(createOrderSummary(name));

        orderSummaryTextView.setText(createOrderSummary(name));

//       displayPrice(price);

    }

    private String createOrderSummary(String name) {

        CheckBox toppings = (CheckBox) findViewById(R.id.toppingCheckBox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        return "Name: " + name +
                "\nAdd whipped cream? " + toppings.isChecked() +
                "\nAdd chocolate?  " + chocolate.isChecked() +
                "\nQuantity: " + quantity +
                "\nTotal: $" + calculatePrice() +
                "\nThank you!";
        }

    private int calculatePrice() {
        return quantity * 5;
    }

    public void increment(View view) {
       // int quantity = 3;
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void dicrement(View view) {
      //  int quantity = 2;
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void displayQuantity(int string) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + string);

    }

    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
