package src;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws ScanExc {
        System.out.println("Введите выражение, состоящее из двух натуральных чисел, в арабской или римской системе счисления" +
                " от 1 до 10 включительно и знака операции (+,-,*,/) между ними.\n" +
                "Пример: 2+2.\n" +
                "Пример: II-I.\n" +
                "Нельзя использовать арабские и римские цифры вместе!\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Результат: "+calc(scanner.nextLine()));

    }


    public static String calc(String input) throws ScanExc {
        int operationIndex = 0;
        String result = null;
        int k = 0;
        String[] exp = input.split("");
        for (int i = 0; i < exp.length; i++) {
            if ((exp[i].equals("+") || exp[i].equals("-") || exp[i].equals("*") || exp[i].equals("/"))) {
                operationIndex = i;
                k++;
            }
        }

        if (k != 1) {
            throw new ScanExc("Некорректное выражение");
        }
        int a = exp.length;
        int x = 0;
        int y = 0;


        if (isInt(exp[0])) {
            if (exp.length == 3) {
                if (isInt(exp[0]) && isInt(exp[2])) {
                    result = (calcArab(Integer.parseInt(exp[0]), Integer.parseInt(exp[2]), exp[1])) + "";
                }
                else throw new ScanExc("Некорректное выражение"); }
                else if ((a >= 5) && !isInt(exp[5])) {throw new ScanExc("Некорректное выражение");} //!!!
                if (exp.length == 5) {
                if (isInt(exp[0]) && isInt(exp[1]) && isInt(exp[4]) && isInt(exp[3])) {
                    result = (calcArab(Integer.parseInt(exp[0] + exp[1]), Integer.parseInt(exp[3] + exp[4]), exp[2])) + "";
                }
                else throw new ScanExc("Некорректное выражение");
            } else if (exp.length == 4) {
                if (isInt(exp[0]) && isInt(exp[1]) && isInt(exp[3])) {
                    result = (calcArab(Integer.parseInt(exp[0] + exp[1]), Integer.parseInt(exp[3]), exp[2])) + "";
                } else if (isInt(exp[0]) && isInt(exp[2]) && isInt(exp[3])) {
                    result = (calcArab(Integer.parseInt(exp[0]), Integer.parseInt(exp[2] + exp[3]), exp[1])) + "";
                }
                else throw new ScanExc("Некорректное выражение");

            }
        }
        //int a = exp.length;
        else if ((exp.length == 4) && (!isInt(exp[0])) && (isInt(exp[3])))
        {
            throw new ScanExc("Некорректное выражение");
        }
        else if ((exp.length == 5) && (!isInt(exp[0])) && (isInt(exp[4])))
        {
            throw new ScanExc("Некорректное выражение");
        }
        else if ((exp.length == 6) && (!isInt(exp[0])) && (isInt(exp[5])))
        {
            throw new ScanExc("Некорректное выражение");
        }
        else if ((a > 6) && (!isInt(exp[0])) && (isInt(exp[5])))
        {
            throw new ScanExc("Некорректное выражение");
        }




        else if (!isInt(exp[0]) && !isInt(exp[2])) {

            if (operationIndex == 1 && exp.length == 3) {
                x = src.Converter.romanToArabic(exp[0]);
                y = src.Converter.romanToArabic(exp[2]);
            }

            if (operationIndex == 1 && exp.length == 4) {
                x = src.Converter.romanToArabic(exp[0]);
                y = src.Converter.romanToArabic(exp[2] + exp[3]);
            }
            if (operationIndex == 2 && exp.length == 5) {
                x = src.Converter.romanToArabic(exp[0] + exp[1]);
                y = src.Converter.romanToArabic(exp[3] + exp[4]);
            }
            if (operationIndex == 2 && exp.length == 4) {
                x = src.Converter.romanToArabic(exp[0]+ exp[1]);
                y = src.Converter.romanToArabic(exp[3]);
            }
            if (operationIndex == 3 && exp.length == 5) { //III+I
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2]);
                y = src.Converter.romanToArabic(exp[4]);
            }
            if (operationIndex == 3 && exp.length == 6) { //III+II
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2]);
                y = src.Converter.romanToArabic(exp[4] + exp[5]);
            }
            if (operationIndex == 3 && exp.length == 7) { //III+III
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2]);
                y = src.Converter.romanToArabic(exp[4] + exp[5] + exp[6]);
            }
            if (operationIndex == 1 && exp.length == 5) { //I+III
                x = src.Converter.romanToArabic(exp[0]);
                y = src.Converter.romanToArabic(exp[2] + exp[3] + exp[4]);
            }
            if (operationIndex == 2 && exp.length == 6) { //II+III
                x = src.Converter.romanToArabic(exp[0] + exp[1]);
                y = src.Converter.romanToArabic(exp[3] + exp[4] + exp[5]);
            }
            if (operationIndex == 4 && exp.length == 6) { //VIII+I
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2] + exp[3]);
                y = src.Converter.romanToArabic( exp[5]);
            }
            if (operationIndex == 4 && exp.length == 7) { //VIII+II
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2] + exp[3]);
                y = src.Converter.romanToArabic( exp[5] + exp[6]);
            }
            if (operationIndex == 4 && exp.length == 8) { //VIII+III
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2] + exp[3]);
                y = src.Converter.romanToArabic( exp[5] + exp[6] + exp[7]);
            }
            if (operationIndex == 4 && exp.length == 9) { //VIII+VIII
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2] + exp[3]);
                y = src.Converter.romanToArabic( exp[5] + exp[6] + exp[7] + exp[8]);
            }
            if (operationIndex == 1 && exp.length == 6) { //I+VIII
                x = src.Converter.romanToArabic(exp[0]);
                y = src.Converter.romanToArabic(exp[2] + exp[3] + exp[4] + exp[5]);
            }
            if (operationIndex == 2 && exp.length == 7) { //II+VIII
                x = src.Converter.romanToArabic(exp[0] + exp[1]);
                y = src.Converter.romanToArabic(exp[3] + exp[4] + exp[5] + exp[6]);
            }
            if (operationIndex == 3 && exp.length == 8) { //III+VIII
                x = src.Converter.romanToArabic(exp[0] + exp[1] + exp[2]);
                y = src.Converter.romanToArabic(exp[4] + exp[5] + exp[6] + exp[7]);
            }


            int preResult = calcArab(x, y, exp[operationIndex]);
            if (preResult <= 0) throw new ScanExc("В римской системе счисления, ответ должен быть больше 0");
            result = src.Converter.arabicToRoman(preResult);
        }

        else throw new ScanExc("Некорректное выражение");
        return result;
    }


    public static boolean isInt(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int calcArab(int x, int y, String operation) throws ScanExc {
        if ((x > 10) || (x < 1) || (y > 10) || (y < 1) )
            throw new ScanExc("Некорректное выражение");

        int result;
        if (operation.equals("+")) {
            result = x + y;
        } else if (operation.equals("-")) {
            result = x - y;
        } else if (operation.equals("*")) {
            result = x * y;
        } else {
            result = x / y;
        }
        return result;
    }

    public static int toArab(String x) throws ScanExc {
        int result = 0;
        if (x.contains("XL")) {
            result += 40;
            x = x.replace("XL", "");
        }
        if (x.contains("IX")) {
            result += 9;
            x = x.replace("IX", "");
        }
        if (x.contains("IV")) {
            result += 4;
            x = x.replace("IV", "");
        }
        int j = x.length();
        for (int i = 0; i < j; i++) {
            if (x.contains("L")) {
                x = x.replaceFirst("L", "");
                result += 50;
            } else if (x.contains("X")) {
                x = x.replaceFirst("X", "");
                result += 10;
            } else if (x.contains("V")) {
                x = x.replaceFirst("V", "");
                result += 5;
            } else if (x.contains("I")) {
                x = x.replaceFirst("I", "");
                result += 1;
            }
        }
        if (!x.equals("")) throw new ScanExc("Некорректное выражение");
        return result;
    }

    public static String toRoman(int x) {
        String result = "";
        if (x == 100) {
            result += "C";
            x -= 100;
        }
        if (x >= 50) {
            if (x >= 90) {
                result += "XC";
                x -= 90;
            } else {
                result += "L";
                x -= 50;
            }
        }
        if (x >= 10) {
            if (x >= 40) {
                result += "XL";
                x -= 40;
            } else {
                int j = x / 10;
                for (int i = 0; i < j; i++) {
                    result += "X";
                    x -= 10;
                }
            }

        }
        if (x >= 5) {
            if (x == 9) {
                result += "IX";
                x -= 9;
            } else {
                result += "V";
                x -= 5;
            }
        }
        if (x == 4) {
            result += "IV";
            x -= 4;
        } else {
            for (int i = 0; i < x; i++) {
                result += "I";
            }
        }
        return result;
    }


}
