package com.example.cesarepini.pacecalculator;

/**
 * Created by cesarepini on 18/03/16.
 * Used to compute the different paces.
 */
public class Pace {

    public double distance;
    public double time;
    public double pace;

    /**
     * Empty constructor initialising all class variables to 0.
     */
    public Pace(){
        this.distance = 0;
        this.time = 0;
        this.pace = 0;
    }

    /**
     * Constructs a pace object by passing the pace directly.
     * @param pace is the pace.
     */
    public Pace(double pace){
        this.pace = pace;
        this.distance = 1;
        this.time = pace;
    }

    /**
     * Constructs a pace object from a distance and a time.
     * @param distance is the distance in km.
     * @param time is the time in seconds.
     */
    public Pace(double distance, double time) {
        this.distance = distance;
        this.time = time;
        this.pace = time / distance;
    }

}