package arrays;


/**
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a
 different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 Example 1:
 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

 Example 2:
 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.

 Constraints:
 1 <= prices.length <= 105
 0 <= prices[i] <= 104

 **/
public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int output = maxProfit(prices);
        System.out.println(output);
    }

    //Approach Understanding from the input: So in order to make profit we should buy the shares at lowest price
    //and sell them at higher price to make max profit.
    //If we buy a share at high price and preceding day is lower, that we can switch selected price day to the
    //preceding day

    /**
     * Below approach exceeds time limit for higher inputs, because time complexity is of n square **/
    private static int maxProfitFromGivenDays(int[] prices) {
        int maxProfit = 0; //maxProfit is set to zero because -ve is not calculated and minProfit will be on zero

        for(int index1=0;index1<prices.length-1;index1++) { //Iteration on 7,1,5,3,6,4
            int index1Price = prices[index1];
            for(int index2=index1+1;index2<= prices.length-1;index2++) {//Iteration on 1,5,3,6,4
                if(index1Price>prices[index2]) {
                    break; //breaks the inner loop and continues the outer loop
                } else {
                    maxProfit = Math.max(maxProfit,prices[index2]-index1Price);
                }
            }
        }

        return maxProfit;
    }

    //Change in approach, we try with time complexity of n, removing the outer loop as an optimization
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;//maxProfit can be -ve, so set that as zero
        int buyPrice = prices[0]; //Assigned the initial price of stock
        for(int index = 1;index<prices.length;index++) {// price of stock checked from index 1
            int price = prices[index]; //price from index 1
            //if initial buy price is higher than today's price, replace buyPrice with current price for maxProfit
            if(buyPrice>price) {
                buyPrice = price;
            } else {
                //if buyPrice less than today's price, find the maxProfit the prices can make.
                maxProfit = Math.max(maxProfit, price-buyPrice);
            }
        }
        return maxProfit;
    }
}
