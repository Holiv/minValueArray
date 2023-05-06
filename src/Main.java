import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readIntegers();
    }

    public static int[] readIntegers() {
        Scanner scanner = new Scanner(System.in);

        String numList;
        do {
            System.out.println("Enter a list of 10 numbers separated by comma");
            numList = scanner.nextLine();
        } while (validation(numList));

        String[] splitList = numList.split(",");
        int[] numArr = new int[splitList.length];
        for (int i = 0; i < splitList.length; i++) {
            numArr[i] = Integer.parseInt(splitList[i].trim());
        }
        System.out.println("The min value on the current array is " + findMin(numArr));
        return numArr;
    }

    public static boolean validation(String numList){
        if (numList.split(",").length == 10) {
            String[] numArr = numList.split(",");
            for (String element : numArr) {
                if (!isNumeric(element)) {
                    System.out.println("Invalid character in the list of numbers");
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isNumeric (String character) {
        try {
            Integer.parseInt(character);
        } catch (NumberFormatException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public static int findMin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
