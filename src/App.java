import java.util.*;

public class App {
    private static final int CODE_BIG_A = 65;
    private static final int CODE_BIG_Z = 90;
    private static final int CODE_LITTLE_A = 97;
    private static final int CODE_LITTLE_Z = 122;

    private static final int TWENTY_ELEMENTS = 20;
    private static final int UPPER_RANDOM_LIMIT = 14;
    private static final int LOWER_RANDOM_LIMIT = -15;

    public static void main(String[] args) {
        System.out.println("Задание 1.");
        defineCharacter();

        System.out.println("\nЗадание 2.");
        maxDigitInNumber();

        System.out.println("\nЗадание 3.");
        defineRadicalAbs();

        System.out.println("\nЗадание 4.");
        numberOfDigits();

        System.out.println("\nЗадание 5.");
        emptyLineToSum();
    }

    //  Первое задание
    public static void defineCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int code = scanner.nextInt();
        if ((code >= CODE_BIG_A && code <= CODE_BIG_Z) || (code >= CODE_LITTLE_A && code <= CODE_LITTLE_Z)) {
            System.out.println(code + " - код английской буквы");
        } else {
            System.out.println(code + " - код не английской буквы");
        }
    }

    //  Второе задание
    public static void maxDigitInNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        while (number < 0) {
            System.out.print("Введите целочисленное и положительное число: ");
            number = scanner.nextInt();
        }
        String numberInString = String.valueOf(number);
        char[] numberInCharArray = numberInString.toCharArray();
        int maxDigit = 0;
        for (int i = 0; i < numberInCharArray.length; i++) {
            int currentDigit = Character.getNumericValue(numberInCharArray[i]);
            if (maxDigit < currentDigit) {
                maxDigit = currentDigit;
            }
        }
        System.out.println("Максимальная цифра в числе = " + maxDigit);
    }
    //  Третье задание
    public static void defineRadicalAbs() {
        int[] twenty = new int[TWENTY_ELEMENTS];
        Random random = new Random();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < twenty.length; i++) {
            twenty[i] = random.nextInt(UPPER_RANDOM_LIMIT + 1 - LOWER_RANDOM_LIMIT) + LOWER_RANDOM_LIMIT;
            int currentValue = twenty[i];
            if (maxValue < currentValue) {
                maxValue = currentValue;
            }
        }
        int counter = 0;
        for (int i = 0; i < twenty.length; i++) {
            if (Math.abs(twenty[i]) > maxValue) {
                counter++;
            }
        }
        System.out.println("Все 20 элементов массива: " + Arrays.toString(twenty));
        System.out.println("Элемент с максимальным значением = " + maxValue);
        System.out.println("Количество элементов по модулю больших максимального = " + counter);
    }

    //  Четвёртое задание
    public static void numberOfDigits() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int number = scanner.nextInt();
        String numberInString = String.valueOf(number);
        char[] numberInCharArray = numberInString.toCharArray();
        int charArrayLength = numberInCharArray.length;
        System.out.println("У введённого числа количество разрядов = " + charArrayLength);
    }

    //  Пятое задание
    public static void emptyLineToSum() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersToSum = new LinkedList<>();
        System.out.println("Вводите числа, которые нужно сложить (для сложения введите пустую строку).");
        while (true) {
            System.out.print("Введите число в список для сложения: ");
            String numberToSumInString = scanner.nextLine();
            if (numberToSumInString.equals("") && numbersToSum.size() == 0) {
                continue;
            } else if (numberToSumInString.equals("") && numbersToSum.size() > 0) {
                break;
            }
            int numberToSum = Integer.parseInt(numberToSumInString);
            numbersToSum.add(numberToSum);
        }
        int sum = 0;
        for (int i = 0; i < numbersToSum.size(); i++) {
            sum += numbersToSum.get(i);
        }
        System.out.println("Сумма введённых чисел = " + sum);
    }
}
