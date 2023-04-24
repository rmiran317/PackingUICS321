package com.example.packingui;

import static com.example.packingui.CameraAnalyzer.longWay;
import static com.example.packingui.FullscreenActivity.bigTree;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class LabelScanned extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.label_scanned);

//        String parserToBe = longWay;
        System.out.println(longWay);
        String[] allWords = longWay.split(", ");

        //List<String> allWords = Arrays.asList(longWay.split(","));
        packageNodeClass newAddee = new packageNodeClass(Double.parseDouble(allWords[0]), Double.parseDouble(allWords[1]), allWords[2], allWords[3]);
        if (bigTree.addVal(newAddee) == false){
            finish();
        }


        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(newAddee.getID() + "\n" + newAddee.getCurrentLocation());
                finish();
            }
        });
    }
}


