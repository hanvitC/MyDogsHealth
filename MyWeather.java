package Section3;

public class MyWeather {
    public String WT;
    public String W;
    public int T;

    public MyWeather(String wt){
        WT = wt;
        W = splitted()[0];
        T = Integer.parseInt(splitted()[1]);
    }

    public String[] splitted(){
        String[] splitted = WT.split(",");

        return splitted;
    }

    public String readWT(String[] split) {
        String newW = null;

        String w = split[0];
        String t = split[1];

        if (w.equals("S")) newW = "아주 좋고 ";
        else if (w.equals("C")) newW = "구름이 많지만 ";
        else if (w.equals("W")) newW = "바람이 조금 불고 ";
        else if (w.equals("R")) newW = "rainy";

        return newW + "기온은 " + t + "°C 에요. ";
    }


}
