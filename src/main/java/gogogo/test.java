package gogogo;

import leetcode.cn.LD.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class test {
    private static int count = 0;
    private static List<List<String>> res = new ArrayList<>();
    private static int[] ans;

    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        inorder(node,res);
        return ans;
    }

    public void inorder(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    static int solution(String s) {
        ans = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
        }
        List<String> path = new ArrayList<>();
        dfs(s, path);
        int min = Integer.MAX_VALUE;
        for (List<String> re : res) {
            int temp = re.size();
            min = Math.min(temp, min);
        }
        return min;
    }

    public static void dfs(String s, List<String> path) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 1; i <= s.length(); i++) {
            if (!helper(s.substring(0, i))) {
                continue;
            }
            path.add(s.substring(0, i));
            dfs(s.substring(i), path);
            path.remove(path.size() - 1);
        }
    }

    public static boolean helper(String s) {
        if (s.length() >= 2) {
            return s.charAt(0) == s.charAt(s.length() - 1);
        }
        return ans[s.charAt(0) - 'a'] == 1;
    }

    public static void main(String[] args) {
        System.out.println(solution("abaccddedffgff"));
    }
}
