package src;

public class Converter {


    public static String arabicToRoman(final int number) {
        if (number < 0 || 11 < number) {
            throw new IllegalArgumentException();
        }
        String[] nums = { "I", "V", "X", "L", "C", "D", "M" };
        int numCounter = 0;
        String result = "";
        StringBuilder partResult = new StringBuilder();
        int numeral;
        String stringNumber = String.valueOf(number);
        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            partResult.delete(0, partResult.length());
            numeral = Integer.parseInt(stringNumber.substring(i, i + 1));
            if (1 <= numeral && numeral < 4) {
                for (int j = 0; j < numeral; j++) {
                    partResult.append(nums[numCounter]);
                }
                numCounter += 2;
            } else if (4 <= numeral && numeral < 9) {
                numCounter += 2;
                if (numeral == 4) {
                    partResult.append(nums[numCounter - 2]);
                }
                partResult.append(nums[numCounter - 1]);
                for (int j = 0; j < (numeral - 5); j++) {
                    partResult.append(nums[numCounter - 2]);
                }
            } else if (numeral == 9) {
                numCounter += 2;
                partResult.append(nums[numCounter - 2] + nums[numCounter]);
            } else if (numeral == 0) {
                numCounter += 2;
            }
            result = partResult.append(result).toString();
        }
        return result;
    }


    public static int romanToArabic(final String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            switch (number.charAt(i)) {
                case 'I':
                    sum++;
                    break;
                case 'V':
                    if (sum == 0 || number.charAt(i-1) != 'I') {
                        sum += 5;
                    } else {
                        sum += 3; // IV - I from previous step
                    }
                    break;
                case 'X':
                    if (sum == 0 || number.charAt(i-1) != 'I') {
                        sum += 10;
                    } else {
                        sum += 8;
                    }
                    break;
                case 'L':
                    if (sum == 0 || number.charAt(i-1) != 'X') {
                        sum += 50;
                    } else {
                        sum += 30;
                    }
                    break;
                case 'C':
                    if (sum == 0 || number.charAt(i-1) != 'X') {
                        sum += 100;
                    } else {
                        sum += 80;
                    }
                    break;
                case 'D':
                    if (sum == 0 || number.charAt(i-1) != 'C') {
                        sum += 500;
                    } else {
                        sum += 300;
                    }
                    break;
                case 'M':
                    if (sum == 0 || number.charAt(i-1) != 'C') {
                        sum += 1000;
                    } else {
                        sum += 800;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return sum;
    }
}
