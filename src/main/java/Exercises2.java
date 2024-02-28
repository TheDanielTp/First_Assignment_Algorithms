import java.util.*;

public class Exercises2 {

    /*
    function that, given an array of integers numbers and an integer target, returns indices of the two numbers
    such that they add up to target. each input returns only one solution
    */

    public static int[] twoSum(int[] nums, int target) {
        int arraySize = nums.length;
        int[] answerArray = new int[2]; //defines an array with the size of 2, because each answer has 2 numbers
        for (int i = 0; i < arraySize; i++) { //starts from the first number and sums it up with each number to determine if it equals to the target
            for (int j = 0; j < arraySize; j++) {
                if (nums[i] + nums[j] == target && i != j) { //if the desired numbers sum up to the target and are different numbers, sets them as answer
                    answerArray[0] = j;
                    answerArray[1] = i;
                    break;
                }
            }
        }
        return answerArray;
    }

    /*
    function that, given a roman numeral, convert it to an integer.
    */

    public static int romanToInt(String s) {
        int stringSize = s.length();
        int sum = 0;

        for (int i = 0; i < stringSize; i++) {
            if (s.charAt(i) == 'I') {
                if (i < stringSize - 1 && s.charAt(i + 1) == 'V') { //if there's IV in the string, adds 4 to the total number
                    sum = sum + 4;
                    i++;
                }
                else if (i < stringSize - 1 && s.charAt(i + 1) == 'X') { //if there's IX in the string, adds 9 to the total number
                    sum = sum + 9;
                    i++;
                }
                else { //if there's a single I in the string, adds 1 to the total number
                    sum = sum + 1;
                }
            }
            else if (s.charAt(i) == 'V') { //if there's a single V in the string, adds 5 to the total number
                sum = sum + 5;
            }
            else if (s.charAt(i) == 'X') {
                if (i < stringSize - 1 && s.charAt(i + 1) == 'L') { //if there's XL in the string, adds 40 to the total number
                    sum = sum + 40;
                    i++;
                }
                else if (i < stringSize - 1 && s.charAt(i + 1) == 'C') { //if there's XC in the string, adds 90 to the total number
                    sum = sum + 90;
                    i++;
                }
                else { //if there's a single X in the string, adds 10 to the total number
                    sum = sum + 10;
                }
            }
            else if (s.charAt(i) == 'L') { //if there's a single L in the string, adds 50 to the total number
                sum = sum + 50;
            }
            else if (s.charAt(i) == 'C') {
                if (i < stringSize - 1 && s.charAt(i + 1) == 'D') { //if there's CD in the string, adds 400 to the total number
                    sum = sum + 400;
                    i++;
                }
                else if (i < stringSize - 1 && s.charAt(i + 1) == 'M') { //if there's CM in the string, adds 900 to the total number
                    sum = sum + 900;
                    i++;
                }
                else { //if there's a single C in the string, adds 100 to the total number
                    sum = sum + 100;
                }
            }
            else if (s.charAt(i) == 'D') { //if there's a single D in the string, adds 500 to the total number
                sum = sum + 500;
            }
            else if (s.charAt(i) == 'M') { //if there's a single M in the string, adds 1000 to the total number
                sum = sum + 1000;
            }
        }
        return sum;
    }

    /*
    function that, given an array numbers of distinct integers, return all the possible permutations
    */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>()); //adds a new list to the first dimension of the 2D array

        for (int num : nums) //an integer that moves from 0 to nums
        {
            List<List<Integer>> permutations = new ArrayList<>(); //creates a new 2D list and defines its first dimension

            for (List<Integer> permutation : answer) //from the first list to the list defined at the beginning
            {
                for (int i = 0; i <= permutation.size(); i++)
                {
                    List<Integer> newPermutation = new ArrayList<>(permutation); //creates a new 1D array which holds a set of permutations
                    newPermutation.add(i, num); //adds the numbers to the permutation
                    permutations.add(newPermutation); //adds the permutation to the 2D list
                }
            }
            answer = permutations; //sets the 2D answer array to the 2D permutation array
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //testing the twoSum function
        System.out.println("Enter the count of numbers:");
        int numsCount = input.nextInt();
        int[] nums = new int[numsCount];

        System.out.println("Enter the numbers:");
        for (int i = 0; i < numsCount; i++) {
            nums[i] = input.nextInt();
        }

        System.out.println("Enter the target number:");
        int target = input.nextInt();

        System.out.println("The two numbers that sum up to target:");
        int[] answerArray = twoSum(nums, target);
        System.out.print("[" + answerArray[0] + ", " + answerArray[1] + "]");
        System.out.println();
        System.out.println();

        //testing the romanToInt function
        System.out.println("Enter the Roman number:");
        String romanNumber = input.next();

        int integerNumber = romanToInt(romanNumber);
        System.out.println("The integer value of Roman number:");
        System.out.println(integerNumber);
        System.out.println();

        //testing the permute function
        System.out.println("Enter the count of numbers:");
        int numbersCount = input.nextInt();

        System.out.println("Enter the numbers:");
        int[] numbers = new int[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            numbers[i] = input.nextInt();
        }

        List<List<Integer>> permutations = permute(numbers);
        System.out.println("All possible permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
