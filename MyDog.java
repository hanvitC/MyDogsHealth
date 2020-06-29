package Section4;

import java.util.Scanner;

public class MyDog {
    public String name;
    public int size;
    public int age;
    public int health;
    public String allergic;
    public String gender;
    public Scanner kb = new Scanner(System.in);

    public int freq;

    public MyDog(String n, String g, int s, int a, int h, String al){
        name = n;
        gender = g;
        age = a;
        health = h;
        allergic = al;
        size = s;
    }

    public MyDog(String n, int f){
        name = n;
        freq = f;
    }


    public int Health() {
        System.out.println("Q 3. Does " + name + " currently have any health issues? : Please type a number from these options");
        // healthy ? answers based on gender
        if (gender.equalsIgnoreCase("F")) System.out.println("  1. She is healthy!");
        else System.out.println("  1. He is healthy!");

        // other health issues options
        System.out.println("  2. Sensitive Stomach");
        System.out.println("  3. Sensitive Skins ");
        System.out.println("  4. Obesity ");
        System.out.println("  5. Weak Bones");
        health = kb.nextInt();
        // in case the user puts a wrong answer
        if (health > 5 || health < 0) throw new IllegalArgumentException("Oops! Please type it again");

        return health;
    }
    public String Allergies() {
        //any food that the puppy can't eat
        if (gender.equalsIgnoreCase("F")) System.out.println("Does she have any food allergies? : Please type a WORD!!!! :) (case insensitive)");
        else System.out.println("Does he have any food allergies? : Please type a WORD!!!! :) (case insensitive)");
        System.out.println();
        System.out.println("  20. No");
        System.out.println("  21. Beef");
        System.out.println("  22. Chicken");
        System.out.println("  23. Pork");
        System.out.println("  24. Grain");
        System.out.println("  25. Eggs");

        allergic = kb.next();
        return allergic; /// 여기서 string 형식으로 알러지 음식이 나와줘야 함 !!!!!!!!
    }
    public int Age() {
        if (gender.equalsIgnoreCase("F")) System.out.println("Q 2. How old is she ?: Please type a number from these options");
        else System.out.println("Q 2. How old is he ? : Please type a number");

        if (size == 1) { // if small
            System.out.println("  1. 2 years old or younger"); // puppies
            System.out.println("  2. 2 years old ~ 8 years old"); // adults
            System.out.println("  3. 8 years old or older"); // seniors

        } else if (size== 2) { // medium
            System.out.println("  1. 2 years old or younger");
            System.out.println("  2. 2 years old ~ 7 years old");
            System.out.println("  3. 7 years old or older");

        } else if (size== 3) { // if large
            System.out.println("  1. 3 years old or younger");
            System.out.println("  2. 3 years old ~ 6 years old");
            System.out.println("  3. 6 years old or older");
        }
        age = kb.nextInt();

        // in case user types the answer wrong
        if (age < 0 || age > 4) throw new IllegalArgumentException("Oops! Please type it again");
        return age;
    }
    public int Size() {
        System.out.println("Q 1. How big is " + name + "? : Please type a number from these options");
        System.out.println("  1. Small (Under 10 kg) ");
        System.out.println("  2. Medium (10kg ~ 24 kg) ");
        System.out.println("  3. Large (25 kg or above) ");
        size = kb.nextInt();

        // in case the user types the answer wrong
        if (size > 3 || size < 0)
            throw new IllegalArgumentException("Oops! Please type it again");
        return size;
    }
    public int Freq(){
        System.out.println("Q 1. " + name + "의 산책 빈도는 몇 번으로 하시겠어요? : 보기의 숫자를 하나 입력해 주세요." );
        System.out.println("  1. 일주일에 2 번");
        System.out.println("  2. 일주일에 3 번");
        System.out.println("  3. 일주일에 4 번");
        freq = kb.nextInt() + 1;
        return freq;
    }
}
