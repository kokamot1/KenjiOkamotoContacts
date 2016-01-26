package edu.westga.cs6242.kenjiokamotocontacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setResultsVisible(false);
    }

    public void onSaveButtonClick(View v) {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        EditText phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);
        TextView phoneTextView = (TextView) findViewById(R.id.phoneTextView);
        TextView landOrCellTextView = (TextView) findViewById(R.id.landOrCellTextView);

        nameTextView.setText(nameEditText.getText());
        emailTextView.setText(emailEditText.getText());
        phoneTextView.setText(phoneEditText.getText());
        landOrCellTextView.setText(this.getLineType());

        this.setFormVisible(false);
        this.setResultsVisible(true);
    }

    public void onEnterAnotherButtonClick(View v) {
        this.setResultsVisible(false);
        this.clearForm();
        this.setFormVisible(true);
    }

    private String getLineType() {
        String result = "";
        RadioButton landlineBtn = (RadioButton) findViewById(R.id.landlineBtn);
        RadioButton cellBtn = (RadioButton) findViewById(R.id.cellBtn);
        if (landlineBtn.isChecked()) {
            result = "Land Line";
        } else if (cellBtn.isChecked()) {
            result = "Cell Phone";
        }
        return result;
    }

    private void setFormVisible(Boolean showForm) {
        ViewGroup form =  (ViewGroup) findViewById(R.id.formLayout);
        if (showForm) {
            form.setVisibility(View.VISIBLE);
        } else {
            form.setVisibility(View.GONE);
        }
    }

    private void setResultsVisible(Boolean showResults) {
        ViewGroup results =  (ViewGroup) findViewById(R.id.resultsDisplay);
        if (showResults) {
            results.setVisibility(View.VISIBLE);
        } else {
            results.setVisibility(View.GONE);
        }
    }

    private  void clearForm() {
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        EditText phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        nameEditText.setText("");
        emailEditText.setText("");
        phoneEditText.setText("");
        RadioButton landlineBtn = (RadioButton) findViewById(R.id.landlineBtn);
        RadioButton cellBtn = (RadioButton) findViewById(R.id.cellBtn);
        landlineBtn.setChecked(false);
        cellBtn.setChecked(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
