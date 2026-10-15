class Solution {
    public int maxProfit(int[] prices) {
        // int l = 0 , r = prices.length - 1;
        // int maxVal = 0;
        // while(l< r){
        //     if(prices[l] == prices[r]) r--;
        //     if(prices[l] > prices[r]) l++;
        //     if(prices[l] < prices[r]){
        //         maxVal = Math.max(maxVal,prices[r] - prices[l]);
        //         r--;
        //     } 
        // }
        int minBuy = prices[0], maxSell = 0, maxProfit = 0;
        for(int i = 1; i < prices.length; i ++){
            if(minBuy < prices[i]){
                maxSell = prices[i];
                maxProfit = Math.max(maxProfit, maxSell-minBuy);
            }else{
                minBuy = prices[i];
            }

        }
        return maxProfit;
    }
}
