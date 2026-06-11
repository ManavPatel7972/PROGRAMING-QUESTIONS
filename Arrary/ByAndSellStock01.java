public class ByAndSellStock01 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + stockBuySell(prices));
    }


    public static int stockBuySell(int[] arr){
        int mini = arr[0];
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            
           int currentProfit= arr[i] - mini;
           profit = Math.max(profit, currentProfit);
           mini = Math.min(arr[i], mini);

        }
        return profit;
    }


}
