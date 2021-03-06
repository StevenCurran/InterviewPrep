package recursive;

// https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
// https://leetcode.com/problems/subsets/
public class GenerateAllSubsets {
    public static void main(String[] args) {
        allSubsetsRecursive(new int[]{1, 2, 3}, new boolean[3], 0);
        allSubsets(new int[]{1, 2, 3, 4});
    }

    private static void allSubsetsRecursive(int[] numbers, boolean[] include, int index) {
        if (index == numbers.length) {
            System.out.print("{ ");
            for (int i = 0; i < include.length; i++) {
                if (include[i]) {
                    System.out.print(numbers[i] + " ");
                }
            }
            System.out.println("}");
            return;
        } else {
            include[index] = false;
            allSubsetsRecursive(numbers, include, index + 1);
            include[index] = true;
            allSubsetsRecursive(numbers, include, index + 1);
        }
    }

    private static void allSubsets(int[] numbers) {
        System.out.println("\n{ }");
        for (int i = 1; i < Math.pow(2, numbers.length); ++i) {
            System.out.print("{ ");
            for (int j = 0; j <= numbers.length; j++) {
                if (((i >> j) & 1) == 1) {
                    System.out.print(numbers[j] + " ");

                }
            }
            System.out.println("}");
        }
    }
}
