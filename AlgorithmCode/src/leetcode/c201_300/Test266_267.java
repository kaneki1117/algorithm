package leetcode.c201_300;

public class Test266_267 {
    /**
     * 加锁题
     *  266 hash思路做
     * Given a string s, return all the palindromic permutations (without duplicates) of it.
     * Return an empty list if no palindromic permutation could be form.
     * For example:
     *
     * Given s = "aabb", return ["abba", "baab"].
     *
     * Given s = "abc", return [].
     * 思路就是 先通过hash判断能否是回文
     * 可以的话分奇数和偶数长度两种情况：利用backtracing 思想做即可 前半部分 + （奇数数） + 前半 reverse
     */
}
