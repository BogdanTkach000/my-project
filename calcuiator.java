package calcRA;
import java.util.InputMismatchException;
import java.util.Scanner;


        public class calcuiator {
            static Scanner scanner = new Scanner(System.in);
            static int number1, number2;
            static char operation;
            static int result;

            public static void main (String[] args) {
                System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
                String userInput = scanner.nextLine();
                char[] under_char = new char[10];
                for (int i = 0; i < userInput.length(); i++) {
                    under_char[i] = userInput.charAt(i);
                    if (under_char[i] == '+') {
                        operation = '+';
                    }
                    if (under_char[i] == '-') {
                        operation = '-';
                    }
                    if (under_char[i] == '*') {
                        operation = '*';
                    }
                    if (under_char[i] == '/') {
                        operation = '/';
                    }
                }
                String under_charString = String.valueOf(under_char);
                String[] blacks = under_charString.split("[+-/*]");
                String stable00 = blacks[0];
                String stable01 = blacks[1];
                String string03 = stable01.trim();
                number1 = calculator(stable00);
                number2 = calculator(string03);
                if (number1 < 0 && number2 < 0) {
                    result = 0;
                } else {
                    result = calculated(number1, number2, operation);
                    System.out.println("---Результат для римских цифр----");
                    String resultRoman = convertNumToRoman(result);
                    System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
                }
                number1 = Integer.parseInt(stable00);
                number2 = Integer.parseInt(string03);
                result = calculated(number1, number2, operation);
                System.out.println("--Результат для арабских цифр----");
                System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
            }

            private static String convertNumToRoman (int numArabian) {
                String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
                };
                final String s = roman[numArabian];
                return s;
            }


            private static int calculator (String calculator) {
                try {
                    if (calculator.equals("I")) {
                        return 1;
                    } else if (calculator.equals("II")) {
                        return 2;
                    } else if (calculator.equals("III")) {
                        return 3;
                    } else if (calculator.equals("IV")) {
                        return 4;
                    } else if (calculator.equals("V")) {
                        return 5;
                    } else if (calculator.equals("VI")) {
                        return 6;
                    } else if (calculator.equals("VII")) {
                        return 7;
                    } else if (calculator.equals("VIII")) {
                        return 8;
                    } else if (calculator.equals("IX")) {
                        return 9;
                    } else if (calculator.equals("X")) {
                        return 10;
                    }
                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Неверный формат данных");
                }
                return -1;
            }

            public static int calculated (int num1, int num2, char op) {
                int result = 0;
                switch (op) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        try {
                            result = num1 / num2;
                        } catch (ArithmeticException | InputMismatchException e) {
                            System.out.println("Exception : " + e);
                            System.out.println("Only integer non-zero parameters allowed");

                            break;
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Не верный знак операции");
                }
                return result;
    }
}
