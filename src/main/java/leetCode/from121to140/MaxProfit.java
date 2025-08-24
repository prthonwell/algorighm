package leetCode.from121to140;

class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int[] status = new int[4];
        status[0] = -prices[0];
        status[1] = 0;
        status[2] = -prices[0];
        status[3] = 0;
        for (int pos = 0; pos < n; pos++) {
            status[0] = Math.max(status[0], -prices[pos]);
            status[1] = Math.max(status[1], status[0] + prices[pos]);
            status[2] = Math.max(status[2], status[1] - prices[pos]);
            status[3] = Math.max(status[3], status[2] + prices[pos]);
            maxProfit = Math.max(maxProfit, status[3]);
        }
        return maxProfit;
    }
}