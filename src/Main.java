import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = readIntegers();
        reverseArr(arr);
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

    private static void reverseArr(int... arr) {
        int maxLength = arr.length - 1;
        int halfLength = arr.length / 2;

        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < halfLength; i++) {
            int temp = arr[i];
            arr[i] = arr[maxLength - i];
            arr[maxLength - i] = temp;
        }
        System.out.println("This is the original reversed array: " + Arrays.toString(arr));


        int[] reversedArr = new int[arr.length];
        for(int element : arr) {
            reversedArr[maxLength--] = element;
        }
        System.out.println("This is a reversed (again) copy of the original array: " + Arrays.toString(reversedArr));
        System.out.println("The original, reversed once, still reversed: " + Arrays.toString(arr));
    }
}
