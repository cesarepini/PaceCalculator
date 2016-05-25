package com.example.cesarepini.pacecalculator;
/**
 * Created by cesarepini on 19/03/16.
 * Class for collecting the paces according to the FIRST Method.
 */
public class FirstPaces {

    public Pace first5km;
    public Pace first400;
    public Pace first600;
    public Pace first800;
    public Pace first1000;
    public Pace first1200;
    public Pace first1600;
    public Pace first2000;
    public Pace firstST;
    public Pace firstMT;
    public Pace firstLT;
    public Pace firstEA;
    public Pace firstMP;
    public Pace firstHMP;
    public Pace first10km;

    public FirstPaces(double time5km){
        this.first5km = new Pace(5, time5km);
    }

    //DEFINITION OF THE DIFFERENT PACES FOR THE DIFFERENT WORKOUTS.
    public final Pace[] FIRST_5_KM = {
            new Pace(5, 960),
            new Pace(5, 1800)
    };

    public final Pace[] FIRST_400_M = {
            new Pace(0.4, 67),
            new Pace(0.4, 135)
    };

    public final Pace[] FIRST_600_M = {
            new Pace(0.6, 103),
            new Pace(0.6, 204)
    };

    public final Pace[] FIRST_800_M = {
            new Pace(0.8, 138),
            new Pace(0.8, 274)
    };

    public final Pace[] FIRST_1000_M = {
            new Pace(1, 175),
            new Pace(1, 344)
    };

    public final Pace[] FIRST_1200_M = {
            new Pace(1.2, 214),
            new Pace(1.2, 417)
    };

    public final Pace[] FIRST_1600_M = {
            new Pace(1.6, 293),
            new Pace(1.6, 563)
    };

    public final Pace[] FIRST_2000_M = {
            new Pace(2, 371),
            new Pace(2, 709)
    };

    public final Pace[] FIRST_ST = {
            new Pace(203),
            new Pace(371)
    };

    public final Pace[] FIRST_MT = {
            new Pace(212),
            new Pace(380)
    };

    public final Pace[] FIRST_LT = {
            new Pace(220),
            new Pace(389)
    };

    public final Pace[] FIRST_EA = {
            new Pace(261),
            new Pace(430)
    };

    public final Pace[] FIRST_HMP = {
            new Pace(207),
            new Pace(406)
    };

    public final Pace[] FIRST_MP = {
            new Pace(219),
            new Pace(418)
    };

    public void setFirstPacesFromFiveKmTime(){
        this.first400 = first400PaceFromFiveKmTime(this.first5km.pace);
        this.first600 = first600PaceFromFiveKmTime(this.first5km.pace);
        this.first800 = first800PaceFromFiveKmTime(this.first5km.pace);
        this.first1000 = first1000PaceFromFiveKmTime(this.first5km.pace);
        this.first1200 = first1200PaceFromFiveKmTime(this.first5km.pace);
        this.first1600 = first1600PaceFromFiveKmTime(this.first5km.pace);
        this.first2000 = first2000PaceFromFiveKmTime(this.first5km.pace);
        this.firstST = firstSTPaceFromFiveKmTime(this.first5km.pace);
        this.firstMT = firstMTPaceFromFiveKmTime(this.first5km.pace);
        this.firstLT = firstLTPaceFromFiveKmTime(this.first5km.pace);
        this.firstEA = firstEAPaceFromFiveKmTime(this.first5km.pace);
        this.firstMP = firstMPPaceFromFiveKmTime(this.first5km.pace);
        this.firstHMP = firstHMPPaceFromFiveKmTime(this.first5km.pace);
    }

    /**
     * It calculates the different training paces from a 5km race time.
     * @return a string of doubles with the different paces for the workouts.
     */
    public Pace[] calculatePacesFromFiveKmTime(){
        return new Pace[]{
                first400PaceFromFiveKmTime(this.first5km.pace),
                first600PaceFromFiveKmTime(this.first5km.pace),
                first800PaceFromFiveKmTime(this.first5km.pace),
                first1000PaceFromFiveKmTime(this.first5km.pace),
                first1200PaceFromFiveKmTime(this.first5km.pace),
                first1600PaceFromFiveKmTime(this.first5km.pace),
                first2000PaceFromFiveKmTime(this.first5km.pace),
                firstSTPaceFromFiveKmTime(this.first5km.pace),
                firstMTPaceFromFiveKmTime(this.first5km.pace),
                firstLTPaceFromFiveKmTime(this.first5km.pace),
                firstEAPaceFromFiveKmTime(this.first5km.pace),
                firstMPPaceFromFiveKmTime(this.first5km.pace),
                firstHMPPaceFromFiveKmTime(this.first5km.pace)
        };
    }

    /**
     * Predicts the race times.
     */
    public void predictRaceTimes(){
        if (this.firstMP == null) {
            this.firstMP = firstMPPaceFromFiveKmTime(this.first5km.pace);
        }
        if (this.firstHMP == null) {
            this.firstHMP = firstMPPaceFromFiveKmTime(this.first5km.pace);
        }
        this.first10km = new Pace(10, firstMP.time/4.64);
    }

    /**
     *
     * @return a string list with all the training paces.
     */
    public String[] pacesToString(){
        String format = "%d";
        return new String[] {
                String.format(format, (long) this.first400.pace),
                String.format(format, (long) this.first600.pace),
                String.format(format, (long) this.first800.pace),
                String.format(format, (long) this.first1000.pace),
                String.format(format, (long) this.first1200.pace),
                String.format(format, (long) this.first1600.pace),
                String.format(format, (long) this.first2000.pace),
                String.format(format, (long) this.firstST.pace),
                String.format(format, (long) this.firstMT.pace),
                String.format(format, (long) this.firstLT.pace),
                String.format(format, (long) this.firstEA.pace),
                String.format(format, (long) this.firstMP.pace),
                String.format(format, (long) this.firstHMP.pace)
        };
    }

    //PRIVATE METHODS
    //METHODS FOR INTERPOLATING THE DIFFERENT PACES
    private Pace first400PaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_400_M[0].time,
                FIRST_400_M[1].time
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_400_M[0].time,
                FIRST_400_M[1].time
        );
        return new Pace(.400, m * fiveKmTime + q);
    }

    private Pace first600PaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_600_M[0].time,
                FIRST_600_M[1].time
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_600_M[0].time,
                FIRST_600_M[1].time
        );
        return new Pace(.600, m * fiveKmTime + q);
    }

    private Pace first800PaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_800_M[0].time,
                FIRST_800_M[1].time
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_800_M[0].time,
                FIRST_800_M[1].time
        );
        return new Pace(.800, m * fiveKmTime + q);
    }

    private Pace first1000PaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_1000_M[0].time,
                FIRST_1000_M[1].time
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_1000_M[0].time,
                FIRST_1000_M[1].time
        );
        return new Pace(1.000, m * fiveKmTime + q);
    }

    private Pace first1200PaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_1200_M[0].time,
                FIRST_1200_M[1].time
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_1200_M[0].time,
                FIRST_1200_M[1].time
        );
        return new Pace(1.200, m * fiveKmTime + q);
    }

    private Pace first1600PaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_1600_M[0].time,
                FIRST_1600_M[1].time
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_1600_M[0].time,
                FIRST_1600_M[1].time
        );
        return new Pace(1.600, m * fiveKmTime + q);
    }

    private Pace first2000PaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_2000_M[0].time,
                FIRST_2000_M[1].time
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_2000_M[0].time,
                FIRST_2000_M[1].time
        );
        return new Pace(2.000, m * fiveKmTime + q);
    }

    private Pace firstSTPaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_ST[0].pace,
                FIRST_ST[1].pace
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_ST[0].pace,
                FIRST_ST[1].pace
        );
        return new Pace(m * fiveKmTime + q);
    }

    private Pace firstMTPaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_MT[0].pace,
                FIRST_MT[1].pace
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_MT[0].pace,
                FIRST_MT[1].pace
        );
        return new Pace(m * fiveKmTime + q);
    }

    private Pace firstLTPaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_LT[0].pace,
                FIRST_LT[1].pace
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_LT[0].pace,
                FIRST_LT[1].pace
        );
        return new Pace(m * fiveKmTime + q);
    }

    private Pace firstEAPaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_EA[0].pace,
                FIRST_EA[1].pace
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_EA[0].pace,
                FIRST_EA[1].pace
        );
        return new Pace(m * fiveKmTime + q);
    }

    private Pace firstMPPaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_MP[0].pace,
                FIRST_MP[1].pace
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_MP[0].pace,
                FIRST_MP[1].pace
        );
        return new Pace(42.195, 42.195 * (m * fiveKmTime + q));
    }

    private Pace firstHMPPaceFromFiveKmTime(double fiveKmTime){
        double m = calculateSlope(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_HMP[0].pace,
                FIRST_HMP[1].pace
        );
        double q = calculateQuota(
                FIRST_5_KM[0].pace,
                FIRST_5_KM[1].pace,
                FIRST_HMP[0].pace,
                FIRST_HMP[1].pace
        );
        return new Pace(42.195/2, 42.195 * (m * fiveKmTime + q) / 2);
    }

    //METHODS FOR EXTRACTING A STRAIGHT FROM TWO KNOWN POINTS
    private double calculateSlope(double x1, double x2, double y1, double y2){
        return (y2 - y1) / (x2 - x1);
    }

    private double calculateQuota(double x1, double x2, double y1, double y2){
        double m = calculateSlope(x1, x2, y1, y2);
        return y1 - m * x1;
    }
}
