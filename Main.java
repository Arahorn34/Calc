package Kata;

import java.util.*;

// rffffrgergetghetg
public class Main {
    static List<String> roma = new ArrayList<>(Arrays.asList("I", "II", "IV", "V", "III", "VI", "VII", "VIII", "IX", "X"
    ));

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Привет, введи пример в формате \"2 * 2\"!");
        System.out.println("А если надоест введи \"exit\"");
        String s;
        while (!(s = sc.nextLine()).equals("exit")) {
            System.out.println(calc(s));
            System.out.println("Давай еще!");
        }
        System.out.println("До новых встреч!");
    }

    public static String calc(String input) throws Exception {
        String[] s = input.split(" ");
        if (check(s).equals("arab")){
            return arab(s);
        } else {
            return roma(s);
        }
    }

    private static String check(String[] s) throws Exception {
        int num1;
        int num2;
        if (s.length != 3){
            throw new Exception("Неправильный ввод.");
        }

        if (!"+-*/".contains(s[1])){
            throw new Exception("Не тот знак.");
        }

        try{
            num1 = Integer.parseInt(s[0]);
            num2 = Integer.parseInt(s[2]);
        } catch (Exception e){
            if (!roma.contains(s[0]) || !roma.contains(s[2])){
                throw new Exception("Неверный формат ввода.");
            } else {
                return "roma";
            }
        }

        if (num1 < 1 || num1 > 10){
            throw new Exception("Введите число от 1 до 10.");
        }
        if (num2 < 1 || num2 > 10){
            throw new Exception("Введите число от 1 до 10.");
        }
        return "arab";

    }

    private static String arab(String[] s){
        int num1 = Integer.parseInt(s[0]);
        int num2 = Integer.parseInt(s[2]);

        switch (s[1]) {
            case ("+"):
                return String.valueOf(num1 + num2);
            case ("-"):
                return String.valueOf(num1 - num2);
            case ("/"):
                return String.valueOf(num1 / num2);
            case ("*"):
                return String.valueOf(num1 * num2);
            default:
                return null;
        }
    }

    private static String roma(String[] s) throws Exception {
        int num1 = roma.indexOf(s[0]) + 1;
        int num2 = roma.indexOf(s[2]) + 1;
        int result = 0;
        switch (s[1]) {
            case ("+"):
                result = num1 + num2;
                break;
            case ("-"):
                result = num1 - num2;
                break;
            case ("/"):
                result = num1 / num2;
                break;
            case ("*"):
                result = num1 * num2;
                break;

        }
        if (result < 1){
            throw new Exception("Недопустимый ответ.");
        } else {
            return res(result);
        }

    }

    private static String res (int result) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[result];
        return s;
    }
}
