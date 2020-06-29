package Section4;

public class MyTime {
    String time;
    String AorP;
    String timeinterval;

    public MyTime(String s) {
        time = s;
        AorP = s.substring(0,1);
        timeinterval = s.substring(1); // reading s from 1st to the end
    }


    public int compareTo(MyTime other){
        int begintimeint = Integer.parseInt(timeinterval.substring(0,1));
        int other_begintimeint = Integer.parseInt(other.timeinterval.substring(0,1));
        if (AorP.equals("A") && other.AorP.equals("P") || AorP.equals(other.AorP) && begintimeint < other_begintimeint )
            return -1; //this time earlier
        else if (AorP.equals("P") && other.AorP.equals("A") || AorP.equals(other.AorP) && begintimeint > other_begintimeint)
            return 1; // other time earlier

        else return 0; // same date and same time
    }

    public String readTime() {
        if (time.substring(0, 1).equals("A"))
            timeinterval += " A.M";
        else timeinterval += " P.M";

        return timeinterval;
    }


}
