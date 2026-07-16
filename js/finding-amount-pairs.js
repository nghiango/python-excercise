function solution(numbers) { 
    let amountPairs = 0;
    numbers.forEach((number, index) => {
        const pairs = getPairsOf(number, index, numbers)
        amountPairs += pairs[number].length;
    });
    return amountPairs;
}
function getPairsOf(number, currentIndex, numbers) {
    const pairs = {};
    pairs[number] = [];
    for (let index = 0; index < numbers.length; index++) {
        if (currentIndex !== index) {
            if (getFistDigit(number) === getLastDigit(numbers[index])) {
                pairs[number].push(numbers[index]);
            }
        }
        
    }
    return pairs;
}
function getFistDigit(number) {
    const numberLeng = String(number).length;
    const devided = 10 ** (numberLeng - 1);
    return Math.floor(number/devided);
}
function getLastDigit(number) {
    return number%10;
}

function solution2(numbers) {
    const map = {};
    let count = 0;
    let countNumberDuplicated = 0;
    for (const number of numbers) {
        const firstDigit = getFistDigit(number);
        const lastDigit = getLastDigit(number);
        if(!map[firstDigit]) {
            map[firstDigit] = []
        }
        if (firstDigit === lastDigit) {
            countNumberDuplicated++;
        }
        map[firstDigit].push(number)
    }
    for (const number of numbers) {
        const lastDigit = getLastDigit(number);
        if(map[lastDigit]) {
            count += map[lastDigit].length;
        }
    }
    count -= countNumberDuplicated;
    return count;
}

console.log(solution([122, 21, 21, 21]));/*?.*/
console.log(solution([30, 12, 29, 91]));/*?.*/
console.log(solution2([122, 21, 21, 21]));/*?.*/
console.log(solution2([30, 12, 29, 91]));/*?.*/


