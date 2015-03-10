package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity {

    Button calculate;
    TextView tip;
    CheckBox round;
    EditText amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        calculate = (Button)findViewById(R.id.btn_calculate);
        tip = (TextView) findViewById(R.id.Tip);
        round = (CheckBox) findViewById(R.id.Rounder);
        amount = (EditText) findViewById(R.id.Amount);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amount.getText() == null || amount.getText().length() == 0) {
                    tip.setText("Tip:");
                    return;
                }
                Double num = Double.parseDouble(amount.getText().toString());
                Double theTip;
                theTip = 0.12 * num;
                String tipString = "";
                if (round.isChecked()) {
                    tipString = String.format("%d", Math.round(theTip));
                } else {
                    tipString = String.format("%.2f", theTip);
                }
                tip.setText("Tip: $" + tipString);
            }
        }) ;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
