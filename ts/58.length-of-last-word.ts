function lengthOfLastWord(s: string): number {
    let count = 0;
    let hasSpaceBefore = false;
    for (const char of s) {
        if (char !== ' ') {
            if (hasSpaceBefore) {
                count = 0;
                hasSpaceBefore = false;
            }
            count++;
        } else {
            hasSpaceBefore = true;
        }
    }
    return count;
};
function lengthOfLastWordVer2(s: string): number {
    return s.trim().split(' ').pop()?.length || 0;
};

const text1 = 'Hello World'
const text2 = "   fly me   to   the moon  "
const text3 = "luffy is still joyboy"
const text4 = "Today is a nice day"
console.log(lengthOfLastWord(text1));
console.log(lengthOfLastWord(text2));
console.log(lengthOfLastWord(text3));
console.log(lengthOfLastWord(text4));

console.log(lengthOfLastWordVer2(text1));
console.log(lengthOfLastWordVer2(text2));
console.log(lengthOfLastWordVer2(text3));
console.log(lengthOfLastWordVer2(text4));


