import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";

        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        boolean result = wordBreak(s, dict);
        System.out.println(result);


        String s2 = "catsanddog";
        Set<String> dict2 = new HashSet<String>();
        dict2.add("cat");
        dict2.add("cats");
        dict2.add("and");
        dict2.add("sand");
        dict2.add("dog");
        ArrayList<String> result2 = wordBreak2(s2, dict2);
//        Iterator<String> iterator = result2.iterator();
//        while (iterator.hasNext()) {
//            String sentence = iterator.next();
//            System.out.println(sentence);
//        }
        for (String sentence : result2) {
            System.out.println(sentence);
        }
    }


    // 状态转移方程：设wb(i)表示s{0...i}是否可以分词
    // 则有：wb(i) = wb(j) && wb(j+1 i); 0<=j<i
    private static boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();

        boolean[] helpArr = new boolean[length + 1];
        helpArr[0] = true;

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (helpArr[j] && dict.contains(s.substring(j, i))) {
                    helpArr[i] = true;
                    break;
                }
            }
        }

        return helpArr[length];
    }

    private static ArrayList<String> wordBreak2(String s, Set<String> dict) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        return DFS(s, dict, map);
    }

    private static ArrayList<String> DFS(
            String s, Set<String> wordDict, HashMap<String, ArrayList<String>> map) {

        // map 保存已经求得的结果
        if (map.containsKey(s)) {
            return map.get(s);
        }

        ArrayList<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }

        for (String subStr : wordDict) {
            if (s.startsWith(subStr)) {
                for (String str : DFS(s.substring(subStr.length()), wordDict, map)) {
                    result.add(
                            subStr + (str.equals("") ? "" : " ") + str
                    );
                }

            }
        }

        map.put(s, result);

        return result;
    }
}
