package com.example.packingui;

import static com.example.packingui.FullscreenActivity.bigTree;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class NewScanPage extends AppCompatActivity {
    EditText startLocEntry, endLocEntry, weightEntry;
    Snackbar popUp;
    public double weight = 0.0;
    public String startLoc, endLoc;
    static packageNodeClass newNode;
    TrackingNumber trackGen = new TrackingNumber();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_scan_page);

        startLocEntry = (EditText) findViewById(R.id.start_location_entry);
        endLocEntry = (EditText) findViewById(R.id.end_location_entry);
        weightEntry = (EditText) findViewById(R.id.weight_entry);
        Button getButton = findViewById(R.id.newPackageButton);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startLoc = startLocEntry.getText().toString();
                String endLoc = endLocEntry.getText().toString();
                String stringWeight = weightEntry.getText().toString();
                double weight = Double.parseDouble(stringWeight);

                try{
                    createPackage(startLoc, endLoc, weight);
                    DialogFragment newFragment = new NewPackageSuccess();
                    newFragment.show(getSupportFragmentManager(), "results");
//                    popUp = Snackbar.make(findViewById(R.id.ScanPage), "Package successfully added!", 3000);
//                    popUp.show();
                    //add into tree package, change so that ane xception is thrown. Note the exception as we might have to check for the catch statement
                }
                catch(Exception e){
                    popUp = Snackbar.make(findViewById(R.id.ScanPage), "A Package was not made. Please try again" + e.toString(), 3000);
                    popUp.show();
                }
//
//                if (createPackage(startLoc, endLoc, weight)){
//                    popUp = Snackbar.make(findViewById(R.id.ScanPage), "Package successfully added!", 3000);
//                    popUp.show();
//                }
//                else {
//                    popUp = Snackbar.make(findViewById(R.id.ScanPage), "A Package was not made. Please try again", 3000);
//                    popUp.show();
//                }
            }
        });
    }

    public void createPackage(String startLoc, String endLoc, double weight){
        double id = trackGen.trackNumber();
        newNode = new packageNodeClass(id, weight, startLoc, endLoc);
        System.out.println(weight);
        bigTree.addVal(newNode);
    }
}