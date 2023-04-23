package com.example.packingui;

import static com.example.packingui.GetPackPage.searchedNode;
import static com.example.packingui.NewScanPage.newNode;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class NewPackageSuccess extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String tracker = Double.toString(newNode.getID());
        builder.setMessage("Package Successfully created!\nTracking Number: " + tracker)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // START THE GAME!
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}


