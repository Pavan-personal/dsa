import java.util.*;

public class First {
    public static int findSecondLargest(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int setBitCount(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }

    public static char team(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.split(" ").length; i++) {
            char c = str.split(" ")[i].charAt(str.split(" ")[i].length() - 1);
            if (hm.get(c) != null) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, hm.getOrDefault(hm, 1));
            }
        }
        int max = -1;
        for (Character key : hm.keySet()) {
            if (hm.get(key) > max) {
                max = (int) (key) - 65;
            }
        }
        return (char) (65 + max);
    }

    public static int getCode(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLen = 0;
        int endIndex = 0;
        int count = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    count += dp[i][j];
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }
        System.out.println("Longest common substring: " + s1.substring(endIndex - maxLen + 1, endIndex + 1)
                + "\nSubstrings: " + count);
        return -1;
    }

    public static int getMaxOccurence(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        // System.out.println(hm);
        boolean isSame = true;
        int max = -1;
        for (Character c : hm.keySet()) {
            if (hm.get(c) >= max) {
                if (hm.get(c) == max) {
                    isSame = false;
                }
                max = hm.get(c);
            }
        }
        return isSame ? max : 0;
    }

    public static boolean isValidIndex(int[][] arr, int p) {
        for (int i = 0; i < arr[p].length; i++) {
            if (arr[p][i] != 0) {
                if (i != p) {
                    return false;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][p] != 0 && i != p) {
                return false;
            }
        }
        return true;
    }

    public static int findIndex(int[][] arr) {
        int min = arr.length + 1;
        for (int i = 0; i < arr.length; i++) {
            if (isValidIndex(arr, i)) {
                min = Math.min(i, min);
            }
        }
        return min;
    }

    public static int noOfWaysHelper(int n, int i) {
        if (i >= n) {
            if (i == n) {
                return 1;
            }
            return 0;
        }
        int c1 = noOfWaysHelper(n, i + 1);
        int c2 = noOfWaysHelper(n, i + 2);
        return c1 + c2;
    }

    public static int noOfWays(int n) {
        return noOfWaysHelper(n, 0);
    }

    public static int getSumOfSquares(int n) {
        int sum = 0;
        for (int i = 0; i < String.valueOf(n).length(); i++) {
            sum += Math.pow(Integer.valueOf(String.valueOf(n).charAt(i)), 2);
        }
        return sum;
    }

    public static boolean isHappyNumber(int n) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(n);
        while (true) {
            if (hs.contains(getSumOfSquares(n))) {
                if (n != getSumOfSquares(n)) {
                    break;
                }
            }
            if (getSumOfSquares(n) == 1) {
                return true;
            }
            hs.add(getSumOfSquares(n));
            n = getSumOfSquares(n);
        }
        return false;
    }

    public static int coinHelper(int[] arr, int target, ArrayList<Integer> a, int i, int current, int max) {
        if (current == target) {
            return Math.min(max, a.size());
        }
        if (current > target || i >= arr.length) {
            return max;
        }
        a.add(arr[i]);
        max = coinHelper(arr, target, a, i, current + arr[i], max);
        a.remove(a.size() - 1);
        max = coinHelper(arr, target, a, i + 1, current, max);
        return max;
    }

    public static int coins(int[] arr, int target) {
        ArrayList<Integer> a = new ArrayList<>();
        return coinHelper(arr, target, a, 0, 0, Integer.MAX_VALUE);
    }

    public static int findWinner(int[] arr, int k){
        int i = 0;
        int count = 0;
        while(count != 1){
            i = (i + (k-1))%arr.length;
            count += 1;
            if(count == arr.length){
                return arr[i];
            }
        }
        return arr[i];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4,5};
        System.err.println(findWinner(arr, 2));
        // System.out.println(coins(arr, 3));
        // System.out.println("Hello World");
        // int[] a = {6,4,3,3,3,2,2,2,2,2,6,89,21};
        // System.out.println(findSecondLargest(a));
        // System.out.println(setBitCount(35));
        // System.out.println("TEAM" + team("TEAMC TEAMB TEAMC TEAMA TEAMB TEAMC"));
        // getCode("eatsleepnightxyz", "eatsleepabcxyz");
        // int[][] a = { { 1, 1, 6, 0, 4 }, { 0, 2, 0, 0, 0 }, { 4, 0, 1, 0, 2 }, { 0,
        // 0, 0, 0, 0 }, { 8, 0, 7, 0, 4 } };
        // System.out.println(findIndex(a));
        // System.out.println(noOfWays(5));
        // System.out.println(isHappyNumber(19));
        // System.out.println(getMaxOccurence("pavansknaasb"));
    }
}