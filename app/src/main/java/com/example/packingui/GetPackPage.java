package com.example.packingui;

import static com.example.packingui.FullscreenActivity.bigTree;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class GetPackPage extends AppCompatActivity {

    EditText searchPackNum;
    public double SearchPackNum = 00000000000;
    static packageNodeClass searchedNode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pack_page);

        searchPackNum = (EditText) findViewById(R.id.search_package_entry);

        Button searchButton = findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringSearch = searchPackNum.getText().toString();
                double SearchPackNum = Double.parseDouble(stringSearch);
                try {
                    searchedNode = bigTree.containsID(SearchPackNum);
                    if (searchedNode == null) throw new NullPointerException();
                    System.out.println("good");
                    DialogFragment newFragment = new SearchResultsSuccess();
                    newFragment.show(getSupportFragmentManager(), "results");
                    LinkedList<Integer> plank = searchedNode.getPath(); //testing path
                }
                catch (Exception e){
                    System.out.println("bad");
                    //new dialog showing that there wasn't a package found, do this for other error messages
                }


            }
        });

    }

//    public void
}