package Section4;

public class MyDate2 {
    String date;
    int month;
    int day;

    public MyDate2(String d){

        date = d;
        month = Integer.parseInt(d.split("/")[0]);
        day = Integer.parseInt(d.split("/")[1]);
    }

    public String readMyDate2(){
        return date;
    }
}
