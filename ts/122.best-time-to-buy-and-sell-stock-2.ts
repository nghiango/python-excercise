function maxProfit(prices: number[]): number {
    let minPrice = prices[0];
    let profits = 0;
    for (let index = 1; index < prices.length; index++) {
        if (minPrice > prices[index]) {
            minPrice = prices[index];
        }
        if (minPrice < prices[index]) {
            profits += prices[index] - minPrice;
            minPrice = prices[index]
        }
    }
    return profits;
};

const prices = [7, 1, 5, 3, 6, 4];
const prices2 = [1,2,3,4,5];
console.log(maxProfit(prices));
console.log(maxProfit(prices2));
