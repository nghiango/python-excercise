interface CharNode {
    char: string;
    nextChar?: CharNode;
    commonCount: number;
}
function longestCommonPrefix(strs: string[]): string {
    let common = "";
    for (let index = 0; index < strs[0].length; index++) {
        if(haveSameCharAt(index, strs)) {
            common += strs[0][index];
        } else {
            return common;
        }
    }
   return common;
};

function haveSameCharAt(position: number, strs: string[]) {
    let lastChar = strs[0][position];
    for (let index = 1; index < strs.length; index++) {
        if (lastChar !== strs[index][position]) {
            return false; 
        }
    }
    return true;
}

const arr1 = ["flower", "flow", "flight"]
const arr2 = ["dog","racecar","car"]
const arr3 = ["reflower","flow","flight"]
const arr4 = ["flight","flight","flight"]
console.log(longestCommonPrefix(arr1) === "fl");
console.log(longestCommonPrefix(arr2) === "");
console.log(longestCommonPrefix(arr3) === "");
console.log(longestCommonPrefix(arr4) === "flight");
