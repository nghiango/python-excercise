function maxProfit(prices: number[]): number {
    let minPrice = prices[0];
    let profits = 0;
    for (let index = 1; index < prices.length; index++) {
        minPrice = Math.min(minPrice, prices[index]);
        profits = Math.max(prices[index] - minPrice, profits)
        
    }
   return profits; 
};

const prices = [7,1,5,3,6,4];
console.log(maxProfit(prices));
