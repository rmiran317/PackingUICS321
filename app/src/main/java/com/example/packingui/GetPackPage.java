package com.example.packingui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GetPackPage extends AppCompatActivity {

    TextView searchPackNum;
    public static final int SearchPackNum = 00000000000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pack_page);
        searchPackNum = (TextView) findViewById(R.id.search_package_entry);
    }
}