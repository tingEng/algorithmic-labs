package problems;

import java.util.*;

public class LC77_Combinations {
	public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || k > n) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp,1, n, k);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> temp, int cur, int n, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = cur; i <= n; i++) {
            temp.add(i);
            dfs(res, temp, i + 1, n, k);
            temp.remove(temp.size() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(combine(4, 2));
		System.out.println(combine(1, 1));

	}
}
