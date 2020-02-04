package ie.ui.pizzaconfigurator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "ie.ui.pizzaconfigurator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner pizzaText = findViewById(R.id.spinner);
        Spinner extraCheeseText = findViewById(R.id.spinner2);
        Spinner extraBaconText = findViewById(R.id.spinner3);
        Spinner cheesyCrustText = findViewById(R.id.spinner4);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Margherita");
        arrayList.add("Pepperoni");
        arrayList.add("Vegetarian");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("No Extra Cheese");
        arrayList2.add("Extra Cheese");

        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("No Extra Bacon");
        arrayList3.add("Extra Bacon");

        ArrayList<String> arrayList4 = new ArrayList<>();
        arrayList4.add("No Cheesy Crust");
        arrayList4.add("Cheesy Crust");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList4);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        pizzaText.setAdapter(arrayAdapter);
        extraCheeseText.setAdapter(arrayAdapter2);
        extraBaconText.setAdapter(arrayAdapter3);
        cheesyCrustText.setAdapter(arrayAdapter4);

    }

    public void submitMessage(View view){
        Intent intent = new Intent(this, DisplayOrder.class);
        Spinner pizzaText = findViewById(R.id.spinner);
        Spinner extraCheeseText = findViewById(R.id.spinner2);
        Spinner extraBaconText = findViewById(R.id.spinner3);
        Spinner cheesyCrustText = findViewById(R.id.spinner4);
        String message = pizzaText.getSelectedItem().toString();
        message += "\n";
        message += extraCheeseText.getSelectedItem().toString();
        message += "\n";
        message += extraBaconText.getSelectedItem().toString();
        message += "\n";
        message += cheesyCrustText.getSelectedItem().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
