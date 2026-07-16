var isValid = function(s) {
    const startMap = {
      '(': ')',
      '{': '}',
      '[': ']'
    }
    const endMap = {
      ')': '(',
      '}': '{',
      ']': '['
    }
    const waiting = [];
    for (const parenthes of s) {
        if (startMap[parenthes]) {
            waiting.push(startMap[parenthes])
        }
        if (endMap[parenthes]) {
            const pa = waiting.pop()
            if(pa !== parenthes) {
                return false;
            }
        }
    }
    if (waiting.length > 0) {
        return false;
    }
    return true;
};
console.log(isValid('()[]{}'));
console.log(isValid('([{}])'));
console.log(isValid('([}])'));
console.log(isValid('([{])'));
console.log(isValid('([{'));