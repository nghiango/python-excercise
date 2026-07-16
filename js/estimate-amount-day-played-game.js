function solution(missions, difference) {
    let day = 1;
    const finishedMissionsMap = {};
    finishedMissionsMap[day] = []
    for (const mission of missions) {
        if (isOverDifficulty(difference, mission, finishedMissionsMap[day])) {
            day++;
            if (!finishedMissionsMap[day]) {
                finishedMissionsMap[day] = []
            }
        }
        finishedMissionsMap[day].push(mission)
    }
    return day;

}
function solution2(missions, difference) {
    
}
function isOverDifficulty(difference, newMissionLevel, currentFinishedMissions) {
    for (const mission of currentFinishedMissions) {
        if (Math.abs(newMissionLevel - mission) > difference) {
            return true;
        }
    }
    return false;
}
console.log(solution([5, 8, 2, 7], 3))
console.log(solution([2, 5, 9, 2, 1, 4], 4))
console.log(solution([1, 12, 10, 4, 5, 2], 2))