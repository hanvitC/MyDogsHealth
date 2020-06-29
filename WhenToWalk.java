package Section4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// 이 프로그램의 문제
// 같은 날 산책이 몰빵 될 수도 있음 -> 산책은 같은 날 최대 1번만 하게 해야함 (최대 난제 ....)

public class WhenToWalk {
    private static String[][] result;
    public static String name;
    public static int freq;
    public static ArrayList<String> nodates = new ArrayList<>();
    public static String[][] arr = readFile("walkdog.txt");
    public static ArrayList<MyDay> remdays= new ArrayList<>();
    public static MyDay remday = null;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.println("<우리 강아지 산책 주기 추천 프로그램>");

        System.out.println();
        System.out.println("현대인들의 바쁜 삶 속에 무의식 적으로 잊기 쉬운 일들 중 하나인 나의 반려견 산책하기," +
                           "\n이젠 잊지 않게 제가 알려 드리겠습니다 :) 우리 강아지 산책 잊지 않고 꼭 해주어요 !");

        // Q 0: name of dog
        System.out.println();
        System.out.println("강아지의 이름이 뭔가요?");
        name = kb.next();

        System.out.println("알겠습니다 :) 그럼 저희가 언제 " + name + " 산책을 하면 좋을 지 추천 해 드릴게요! ");
        System.out.println("총 2가지의 질문을 드릴거에요 잘 대답해 주세요!");
        System.out.println();

        System.out.println("Q 1. " + name + "의 산책 빈도는 몇 번으로 하시겠어요? : 보기의 숫자를 하나 입력해 주세요." );
        System.out.println("  1. 일주일에 2 번");
        System.out.println("  2. 일주일에 3 번");
        System.out.println("  3. 일주일에 4 번");
        freq = kb.nextInt() + 1;

        System.out.println("Q 2. 보기 중 하루의 어느 시간대도 산책이 불가능 하신 날이 있으신가요? : 보기의 숫자를 하나 입력해 주세요.");


        for (int i = 1; i < arr[0].length; i++){
            System.out.println("  " + (i) + ". " + arr[0][i]);
        }
        System.out.println("  " + (arr[0].length) + ". 아니요, 언제든 가능 합니다 :)" );

        while(true){
            int nodateindex = kb.nextInt();
            if (nodateindex != arr[0].length){
                nodates = IcantOn(nodateindex);
                System.out.println("안 되시는 날이 더 있으신 가요?");
            }
            else break;
        }

        System.out.println("아래의 날짜와 시간대가 " + name + " 에게 꼭 맞는 산책 시간일 것 같은데요! ");
        System.out.println("비가 오지 않고, 기온이 30도 이하인 날들 위주로 골라 보았어요.");
        System.out.println("=====================================================");
        remUnav(arr);
        System.out.println("=====================================================");

        System.out.println();
        System.out.println("산책 날짜 추천 프로그램을 이용해 주셔서 감사합니다 <3");
    }

    private static void remUnav(String[][] arr) {
        for (int i = 1; i < arr.length; i++){
            for (int j = 1; j < arr[0].length; j++){

                MyDate2 date = new MyDate2(arr[0][j]);
                MyTime time = new MyTime(arr[i][0]);
                MyWeather weather = new MyWeather(arr[i][j]);

                remday = new MyDay(date, time, weather);

                if (!nodates.contains(arr[0][j]) && weather.T < 30 && !weather.W.equals("R")) {
                    remdays.add(remday);
                }
            }
        }

        int size = remdays.size();
        if (size != 0){
            Random ran = new Random(); // random generator
            ArrayList<MyDay> sortedremdays= new ArrayList<>();

            int z = 0;
            while (z < freq) { // randomly produces # days user inputs
                int ran_int = ran.nextInt(size);
                if (!sortedremdays.contains(remdays.get(ran_int))){
                    sortedremdays.add(remdays.get(ran_int));
                    Collections.sort(sortedremdays);
                    // sorting the dates earlier dates shown before
                    z++;
                }
            }
            for (int h = 0; h <freq; h++)
            sortedremdays.get(h).printDay();
       }
       else System.out.println("죄송 하지만 알맞은 산책 날짜 및 시간대를 찾을 수 없었어요 :(");


    }

    public static ArrayList<String> IcantOn(int nodateindex){
        nodates.add(arr[0][nodateindex]);
        return nodates;
    }

    public static String[][] readFile(String filename) {
        try {
            Scanner inFile = new Scanner(new File(filename));
            List<String[]> lines = new ArrayList<>();

            int row = 9;
            for (int j = 0; j < row; j++) {
                String[] line = inFile.nextLine().trim().split("  ");
                lines.add(line);
            }
            result = new String[lines.size()][];
            for (int i = 0; i < result.length; i++) {
                result[i] = lines.get(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return result;
    }
}
