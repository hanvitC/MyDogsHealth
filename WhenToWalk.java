package Section4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// 이 프로그램의 문제
// 같은 날 산책이 몰빵 될 수도 있음 -> 산책은 같은 날 최대 1번만 하게 해야함 (최대 난제 ....)

public class WhenToWalk {

    public Scanner kb = new Scanner(System.in);
    public String[][] arr;
    public ArrayList<String> nodates = new ArrayList<>() ;
    public ArrayList<MyDay> remdays = new ArrayList<>();

    public MyDog myDog2;
    public String filename;

    public WhenToWalk (MyDog myDog2, String filename){
        this.myDog2 = myDog2;
        this.filename = filename;
    }

    public String[][] readFile() { // reading the file and saves into a 2-d array
        try {
            Scanner inFile = new Scanner(new File(filename));
            List<String[]> lines = new ArrayList<>();

            int row = 9;
            for (int j = 0; j < row; j++) {
                String[] line = inFile.nextLine().trim().split("  ");
                lines.add(line);
            }
            arr = new String[lines.size()][];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = lines.get(i);
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return arr;
    }

    public ArrayList<String> Unav(){ // reads arr, collects unav. days from user and saves into arraylist
        System.out.println("Q 2. 보기 중 하루의 어느 시간대도 산책이 불가능 하신 날이 있으신가요? : 보기의 숫자를 하나 입력해 주세요.");
        for (int i = 1; i < arr[0].length; i++){
            System.out.println("  " + (i) + ". " + arr[0][i]);
        }
        System.out.println("  " + (arr[0].length) + ". 아니요, 언제든 가능 합니다 :)" );

        while(true){
            int nodateindex = kb.nextInt();
            if (nodateindex != arr[0].length){
                nodates.add(arr[0][nodateindex]);
                System.out.println("안 되시는 날이 더 있으신 가요?");
            }
            else break;
        }
        return nodates;
    }

    private ArrayList<MyDay> remUnav() { // only adds available days to the arraylist "remdays"
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                MyDate2 date = new MyDate2(arr[0][j]);
                MyTime time = new MyTime(arr[i][0]);
                MyWeather weather = new MyWeather(arr[i][j]);
                MyDay remday = new MyDay(date, time, weather);

                // Unav(): returns string arraylist of unav dates
                if (!nodates.contains(arr[0][j]) && weather.T < 30 && !weather.W.equals("R"))
                    remdays.add(remday);
            }
        }
        return remdays;
    }

    public void printremUnav() { // prints the remdays
        remUnav();
        int len = remdays.size();
        if (len != 0){
            Random ran = new Random(); // random generator
            ArrayList<MyDay> sortedremdays= new ArrayList<>();

            int z = 0;
            while (z < myDog2.freq) { // randomly produces # days user inputs
                int ran_int = ran.nextInt(len);
                if (!sortedremdays.contains(remdays.get(ran_int))){
                    sortedremdays.add(remdays.get(ran_int));
                    Collections.sort(sortedremdays);
                    // sorting the dates earlier dates shown before
                    z++;
                }
            }
            for (int h = 0; h <myDog2.freq; h++)
                sortedremdays.get(h).printDay();
        }
        else System.out.println("죄송 하지만 알맞은 산책 날짜 및 시간대를 찾을 수 없었어요 :(");
    }
    public void printWalkDays(){
        System.out.println("아래의 날짜와 시간대가 " + myDog2.name + " 에게 꼭 맞는 산책 시간일 것 같은데요! ");
        System.out.println("비가 오지 않고, 기온이 30도 이하인 날들 위주로 골라 보았어요.");
        System.out.println("=====================================================");
        printremUnav();
        System.out.println("=====================================================");
        System.out.println();
        System.out.println("산책 날짜 추천 프로그램을 이용해 주셔서 감사합니다 <3");
        System.out.println();
    }
}
