function solution(blocks) {
    let maxDistance = 0;
    for (let index = 0; index < blocks.length; index++) {
        const currentDistance = distanceAt(index, blocks);
        if (currentDistance > maxDistance) {
            maxDistance = currentDistance
        } 
    }
    return maxDistance;
}

function distanceAt(position, blocks) {
    const maleFrogDistance = moveLeft(position, blocks);
    const femaleFrogDistance = moveRight(position, blocks);
    return maleFrogDistance + femaleFrogDistance + 1;
}

function moveLeft(position, blocks) {
    let distance = 0;
    for (let index = position; index >= 0; index--) {
        if (canMoveLeft(index, blocks)) {
            distance++;
        } else {
            break;
        }
    }
    return distance;
}

function moveRight(position, blocks) {
    let distance = 0;
    for (let index = position; index < blocks.length; index++) {
        if (canMoveRight(index, blocks)) {
            distance++;
        } else {
            break;
        }
    }
    return distance;
}

function canMoveLeft(position, blocks) {
    let nextPosition;
    nextPosition = position - 1;
    if (nextPosition < 0) {
        return false;
    }
    return isLargerOrEquals(blocks[nextPosition], blocks[position])
}

function canMoveRight(position, blocks) {
    let nextPosition;
    nextPosition = position + 1;
    if (nextPosition >= blocks.length) {
        return false;
    }
    return isLargerOrEquals(blocks[nextPosition], blocks[position])
}

function isLargerOrEquals(number1, number2) {
    return number1 >= number2;
}

console.log(solution([2, 6, 8, 5]));
console.log(solution([1, 5, 5, 2, 6]));
console.log(solution([1, 1]));
console.log(solution([1,2,3,4,5,8]));