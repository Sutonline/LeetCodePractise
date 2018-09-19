package cn.kevin.leetcode.easy;

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 * @author yongkang.zhang
 * created at 19/09/2018
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 计算最大收益
     * 本质是要找出来每个元素和其后元素的一个差
     *
     * @param priceArray 股票价格的变化
     * @return [maxProfit, buyDay, sellDay]
     */
    private static Integer[] solution(Integer[] priceArray) {
        int tempProfit = 0;
        int buyDay = 1;
        int sellDay = 2;

        for (int i = 0; i < priceArray.length - 1; i++) {
            for (int j = i + 1; j <= priceArray.length - 1; j++) {
                if (priceArray[j] - priceArray[i] > tempProfit) {
                    buyDay = i;
                    sellDay = j;
                    tempProfit = priceArray[j] - priceArray[i];
                }
            }
        }

        return new Integer[]{tempProfit, buyDay, sellDay};
    }

    public static void main(String[] args) {
        Integer[] solution = solution(new Integer[]{7,6,4,3,1});
        if (solution[0] == 0) {
            System.out.println("max profit is 0, no transaction should be made");
        } else {
            System.out.println("max profit is " + solution[0] + ", buy at " + solution[1] + ", sell at " + solution[2]);
        }
    }

}
