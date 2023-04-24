package com.example.packingui;

import java.util.LinkedList;

public class packageNodeClass implements Comparable<packageNodeClass> {
    public double id;

    public packageNodeClass left, right;

    private double weight;

    private String startingLocation, endLocation, currentLocation, nextLocation;

    private DS4States states = new DS4States();

    private StatesGraph graph = new StatesGraph(states);

    private ReverseDS4States rStates = new ReverseDS4States();

    private LinkedList<Integer> path = new LinkedList<Integer>();

    public packageNodeClass(double id, double weight, String startingLocation, String endLocation) {

        if (weight <= 0) throw new IllegalArgumentException("The weight can not be less than or equal to 0");
        if (startingLocation == null || endLocation == null) throw new NullPointerException("The locations can not be null.");
        this.id = id;
        this.weight = weight;
        this.currentLocation = startingLocation;
        this.startingLocation = startingLocation;
        this.endLocation = endLocation;
        path.addAll(graph.shortestPath(states.getStateCode(startingLocation), states.getStateCode(endLocation)));
        if (startingLocation.equals(endLocation)) nextLocation = startingLocation;
        else this.nextLocation = rStates.getStateCode(path.get(1));

    }

    public double getID() {return id;}

    public double weight() {return weight;}

    public String getCurrentLocation() {return currentLocation;}

    public String getStartingLocation() {return startingLocation;}

    public String getEndLocation() {return endLocation;}

    public LinkedList<Integer> getPath() {return path;}

    public void setNextCurrentLocation() {

        if (path.size() < 2) return;
        currentLocation = nextLocation;
        path.removeFirst();
        if (path.size() < 2) nextLocation = currentLocation;
        else nextLocation = rStates.getStateCode(path.get(1));
        path.clear();
        path.addAll(graph.shortestPath(states.getStateCode(currentLocation), states.getStateCode(endLocation)));

    }


    @Override
    public int compareTo(packageNodeClass other) {
        return (int) (this.getID() - other.getID());
    }

    public static void main(String[] args) {

        packageNodeClass pakage = new packageNodeClass(10, 10, "alabama", "new york");
        System.out.print(pakage.currentLocation);
        System.out.print("\n");
        System.out.print(pakage.getPath().toString());
        pakage.setNextCurrentLocation();
        System.out.print("\n");
        System.out.print(pakage.getPath().toString());
        System.out.print("\n");
        System.out.print(pakage.currentLocation);
    }
}

