import java.util.ArrayList;

public class StringPartition {
    public static void main(String[] args) {
        String s = "aab";

        ArrayList<ArrayList<String>> res = partition(s);

        for (ArrayList<String> strings : res) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        if (s == null || s.length() == 0) {
            return result;
        }

        solve(s, 0, new ArrayList<String>(), result);

        return result;
    }

    private static void solve(String s, int index, ArrayList<String> preList, ArrayList<ArrayList<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(preList));
            return;
        }

        ArrayList<String> list = new ArrayList<String>(preList);

        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(index, i))) {
                list.add(s.substring(index, i));
                solve(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    // 判断某个字符串是否为回文串
    private static boolean isPalindrome(String s) {
        if (s == null)
            return false;

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;

    }
}
