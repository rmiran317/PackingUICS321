package com.example.packingui;

import java.util.*;

public class ReverseDS4States {
    Map<Integer, String> states = new HashMap<Integer, String>();

    public ReverseDS4States() {
        states.put(0, "alaska");
        states.put(1, "alabama");
        states.put(2, "arkansas");
        states.put(3, "arizona");
        states.put(4, "california");
        states.put(5, "colorado");
        states.put(6, "connecticut");
        states.put(7, "wyoming");
        states.put(8, "delaware");
        states.put(9, "florida");
        states.put(10, "georgia");
        states.put(11, "hawaii");
        states.put(12, "iowa");
        states.put(13, "idaho");
        states.put(14, "illinois");
        states.put(15, "indiana");
        states.put(16, "kansas");
        states.put(17, "kentucky");
        states.put(18, "louisiana");
        states.put(19, "massachusetts");
        states.put(20, "maryland");
        states.put(21, "maine");
        states.put(22, "michigan");
        states.put(23, "minnesota");
        states.put(24, "missouri");
        states.put(25, "mississippi");
        states.put(26, "montana");
        states.put(27, "north carolina");
        states.put(28, "north dakota");
        states.put(29, "nebraska");
        states.put(30, "new hampshire");
        states.put(31, "new jersey");
        states.put(32, "new mexico");
        states.put(33, "nevada");
        states.put(34, "new york");
        states.put(35, "ohio");
        states.put(36, "oklahoma");
        states.put(37, "oregon");
        states.put(38, "pennsylvania");
        states.put(39, "rhode island");
        states.put(40, "south carolina");
        states.put(41, "south dakota");
        states.put(42, "tennessee");
        states.put(43, "texas");
        states.put(44, "utah");
        states.put(45, "virginia");
        states.put(46, "vermont");
        states.put(47, "washington");
        states.put(48, "wisconsin");
        states.put(49, "west virginia");
    }

    public void printStateCodes() {
        for (int i : states.keySet()) {
            System.out.println(i + ": " + states.get(i));
        }
    }

    public String getStateCode(int stateCode) {
        for (int i : states.keySet()) {
            if (i == stateCode) {
                return states.get(i);
            }
        }
        System.out.println("There is no matching state code!");
        return null;
    }

}

