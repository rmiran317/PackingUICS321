package com.example.packingui;

import android.app.Application;

import java.util.*;

public class DS4States extends Application {
    //List<String> stateList = new ArrayList<>();
    //String[] stateList = new String[50];
    static List<List<String>> stateList = new ArrayList<List<String>>(50);
    static Map<String, Integer> states = new HashMap<String, Integer>();
    public DS4States(){

        states.put("alaska", 0);
        states.put("alabama", 1);
        states.put("arkansas", 2);
        states.put("arizona", 3);
        states.put("california", 4);
        states.put("colorado", 5);
        states.put("connecticut", 6);
        states.put("wyoming", 7);
        states.put("delaware", 8);
        states.put("florida", 9);

        states.put("georgia", 10); //Tennesee(4.977935485721), South Carolina(2.4094927287709), Florida(4.7088732335878), Alabama(4.0051081883015)
        states.put("hawaii", 11);
        states.put("iowa", 12); //South Dakota(7.1182967808318), Minnesota(5.1049389614372), Wisconsin(4.71261466704), Illinois(3.9030573464913)
        states.put("idaho", 13); // Wyoming(7.5174659114625), Utah(5.9871529736595), Nevada(7.020955276345), Oregon(8.3339653526116), Washington(8.685705325431)
        states.put("illinois", 14); //Wisconsin, Indiana, Kentucky, Missouri, Iowa
        states.put("indiana", 15); //Ohio, Mihcigan, Kentucky, Illinois
        states.put("kansas", 16); //Nebraska, Missouri, Oklahoma, Colorado
        states.put("kentucky", 17); //Indiana, Ohio, West Virginia, Virginia, Tennessee, Missouri, Illinois
        states.put("louisiana", 18); //Arkansaas, Mississippi, Texas
        states.put("massachusetts", 19); //Vermont, NewHampshire, Rhode Island, Conneticut, New York

        states.put("maryland", 20);
        states.put("maine", 21);
        states.put("michigan", 22);
        states.put("minnesota", 23);
        states.put("missouri", 24);
        states.put("mississippi", 25);
        states.put("montana", 26);
        states.put("north carolina", 27);
        states.put("north dakota", 28);
        states.put("nebraska", 29);
        states.put("new hampshire", 30);

        states.put("new jersey", 31); //Pennslyvania, New Yorick, Delaware
        states.put("new mexico", 32); //Colorado, Oklahoma, Texas, Mexico, Arizona
        states.put("nevada", 33); // Oregon, Idaho, Utah, Arizona, California
        states.put("new york", 34); //Vermont, Massachusetts, Connecticut, New Jersey, Pennslyvania
        states.put("ohio", 35); // Michigan, Pennslyvania, West Virginia, Kentucky, Indiana
        states.put("oklahoma", 36); //Colorado, Kansas, Missouri, Arkansas, Texas, New Mexico
        states.put("oregon", 37); //Washington, Idaho, Nevada, California

        states.put("pennsylvania", 38);
        states.put("rhode island", 39);
        states.put("south carolina", 40);
        states.put("south dakota", 41);
        states.put("tennessee", 42);
        states.put("texas", 43);
        states.put("utah", 44);
        states.put("virginia", 45);
        states.put("vermont", 46);
        states.put("washington", 47);
        states.put("wisconsin", 48);
        states.put("west virginia", 49);

        //Washington D.C.
        // states.put("district of columbia", 7);
        // states.put("dc", 7);

        //add acronyms ex. AZ, VA, etc.?
        //what data type are we storing for double arrayList?
        //hasmap inside hasmap? states->cities->districts?
    }
    public static void printStates(){
        for(int i = 0; i < stateList.size(); i++){
            System.out.println(stateList.get(i));
        }
    }

    // public void convertToArrayList(String[] stateList){

    // }

    public void printKeys(){
        for (String i : states.keySet()) {
            System.out.println(i);
        }
    }

    public int getStateCode(String stateName){
        if(states.get(stateName.toLowerCase()) == null){
            System.out.println("There is no matching States!");
            return 0;
            //throw new IllegalArgumentException("There is no matching States!");
        }
        else{
            return states.get(stateName.toLowerCase()); //this makes it not case sensitive.
        }
    }

    public static void main(String[] args) {
        DS4States state = new DS4States();
        System.out.println(state.getStateCode("alabama")); //this should give us code of 0 -> arrayList index at 0
        //System.out.println(state.getStateCode("test")); //this should throw illegal args
        System.out.println(state.getStateCode("dc"));
        state.printKeys();

    }
}
