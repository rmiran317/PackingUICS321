package com.example.packingui;

import java.util.ArrayList;


public class TrackingNumber {
    ArrayList<Double> inUseTrackingNumbers = new ArrayList<Double>();
    public double trackNumber() {
        int max = 9;
        int min = 1;
        int tempInt;

        String trackVal = "";
        double trackingN = 0.0;

        int i = 0;
        while(i < 10){
            tempInt = (int) ((Math.random() * (max - min)) + min);
            trackVal = trackVal + String.valueOf(tempInt);
            i++;
        }
        System.out.println(trackVal);
        trackingN = Double.parseDouble(trackVal);
        if(inUseTrackingNumbers.contains(trackingN)){
            trackNumber();
        }
        else{
            System.out.println("Tracking Number successfully created.");
            inUseTrackingNumbers.add(trackingN);
            System.out.println(inUseTrackingNumbers.size()  );
        }
        return trackingN;
    }
    public void trackingNumber(double val) {
        if(inUseTrackingNumbers.remove(val)){
            System.out.println("Successfully removed");
        }
        else {
            System.out.println("ERROR: tracking number does not exist in the system.");
        }
    }
}