package com.example.packingui;

import android.app.Application;

import java.sql.Array;
import java.util.PriorityQueue;

public class TreePackage extends Application {
    private static PriorityQueue<packageNodeClass> packageNodeClassPriorityQueue = null;
    public TreePackage(){
        packageNodeClassPriorityQueue = new PriorityQueue<packageNodeClass>();
    }

    //need to edit so that we can just input the tracking number
    //probably better to create an instance, show the information of the package (start, curr, and end), will have to pass on information or can create a different pop-up???
//    public static boolean search(double id){
//        packageNodeClass searchedNode = containsID(id);
//        if (searchedNode == null){
//            return false;
//        }
//        else{
//
//        }
//
//        return true;
//    }
    public void addVal(packageNodeClass packageVal){
        if(packageNodeClassPriorityQueue.contains(packageVal)){
            System.out.println("ERROR: The package is in the system.");
        }
        else{
            packageNodeClassPriorityQueue.add(packageVal);
            System.out.println("Package successfully added into tree.");
        }

    }
    public void remove(packageNodeClass packageVal){
        if(packageNodeClassPriorityQueue.contains(packageVal)){
            packageNodeClassPriorityQueue.remove(packageVal);
            System.out.println("Package successfully removed.");
        }
        else{
            System.out.println("ERROR: The package is not in the system.");
        }

    }

    public static packageNodeClass containsID(double id){
        System.out.println("Gobbly gook\n");
        packageNodeClass[] pNodes = packageNodeClassPriorityQueue.toArray(new packageNodeClass[0]);
        System.out.println("The length is: " + pNodes.length);
        for (int i = 0; i < pNodes.length; i++){
            System.out.println(pNodes[i].id + "\t" + id + "\n");
            if (pNodes[i].getID() == id){
                return pNodes[i];
            }
        }
        return null;
    }
}
