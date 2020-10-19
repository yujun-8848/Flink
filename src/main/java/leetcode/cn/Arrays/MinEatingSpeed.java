package leetcode.cn.Arrays;

/**
 * 875 爱吃香蕉的阿珂
 * <p>
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 */
public class MinEatingSpeed {

    public static int minEatingSpeed(int[] piles, int H) {
        //套用搜索左侧边界的算法框架
        int left = 1;
        //最大值加1
        int right = getMax(piles) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinsh(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canFinsh(int[] piles, int speed, int H) {

        int time = 0;
        for (int pile : piles) {
            time += timeOf(pile, speed);
        }
        return time <= H;
    }

    private static int timeOf(int pile, int speed) {
        return (pile / speed) + ((pile % speed) > 0 ? 1 : 0);
    }

    public static int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles, 6));
    }
}
