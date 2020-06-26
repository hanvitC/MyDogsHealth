package Section3;

public class MyDay implements Comparable<MyDay> {
    public MyDate2 date;
    public MyTime time;
    public MyWeather WT;

    public MyDay(MyDate2 d, MyTime t, MyWeather wt ){
        date = d;
        time = t;
        WT = wt;
    }

    public int compareTo(MyDay other) {
        int month = date.month;
        int day = date.day;

        if(month < other.date.month || month == other.date.month && day < other.date.day
                || month == other.date.month && day == other.date.day && time.compareTo(other.time)==-1 )
            return -1; // this day is earlier
        else if (month > other.date.month || month == other.date.month && day > other.date.day
                 || time.compareTo(other.time) == 1 )
            return 1; // other day is earlier
        else return 0; // same day
    }

    public void printDay(){
        System.out.println ( date.readMyDate2() + "의 " + time.readTime() + " : 날씨는 " + WT.readWT(WT.splitted()));
    }


}
