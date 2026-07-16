# Exercise
- [] Exercise: finding-amount-pairs
    * There is an array `numbers` made of N integers. Each number has at least two digits and its first and last digits are different.
    * You can select a pair of numbers if the last digit of the first selected number is the same as the first digit of the second selected number. Calculate the number of ways in which such a pair of numbers can be selected.
    * Write a function:
    `function solution(numbers)`
    * that, given an array number made of N integers, returns the number of ways to select a pair of numbers as described abobve.
    * Examples:
        1. Given `numbers`=[30, 12, 29, 91], the function should return 3. The pairs are (12, 29), (29, 91), (91, 12).
        2. Given `numbers`=[122, 21, 21, 23], the function should return 5. The pairs are (122, 21) occurring twice, (122, 23), and (21, 122) occuring twice. Please note that the same pair of numbers can appear multiple times if the pairs of their indices are different.
    * Write an efficient algorithm for the following assumptions:
        * N is an integer within the range [1..100,00];
        * Each element of array numbers is an integer within the range [10..1000,000,000]
        * The first and last digits in each element of array numbers are different;
        * the answer does not exeed 1,000,000,000
- [] Exercise: estimate-amount-day-played-game
    * In order to finish a game, a player has to complete N missions. The missions are numbered from 0 to N-1. The K-th mission has an integer D[K] assigned, representing its difficulty level.
    * During a day, you can perform any number of missions given the two following rules:
        * Missions should be performed in the specificed order, in other words, a mission can be undertaken only if all of the missions preceding it have already been completed;
        * The difference between the difficulty levels of any two missions performed on the same day should not be greater than an integer X.
    * Write a function:
        `function solution(D, X)`
    * that, given an array D of N integers and an integer X, returns the minimum number of days required to complete all the missions in the game.
    * Example:
        1. Given D=[5, 8, 2, 7] and X = 3, your function should return 3. The first two misssions can be performed on the first day, the third mission on the second day and the last mission on the third day. It is not possible to complete all of the missions in fewer days.
        2. Given D=[2, 5, 9, 2, 1, 4] and X =4, your function should return 3. The first two missions can be performed on the first day, the third mission on the second day and all of the remaning missions on third day. Note that it is possible to perform the first mission on the first day and the next two missions on the second day. In both these cases, the minimum number of days required to complete all of the missions is 3.
        3. Given D=[1, 12, 10, 4, 5, 2] and X=2, your function should return 4. The first mission can be performed on the first day, the next two missiongs on the second day, the fourth and fifth missions on the third day, and the last remaining mission on the fourth day. It is not possible to complete all the missions in fewer days.
    * Write an efficient algorithm for the following assumptions:
- [] Exercise: frog-jumping
    * There are N blocks, numbered from 0 to N-1, arranged in row. A couple of frogs were sitting together on one block when they had a terrible quarrel. Now they want to jump away from one another so that the distance between them will be as large as possible. The distance betwwen blocks numbered J and K, where J <= K, is computed as K-J+1. The frogs can only jump up, meaning that they can move from one block to another only if the two blocks are adjacent and the second block is of the same or greater height as the first. What is the longest distance that they can possibly create between each other, if they also chose to sit on the optimal starting block initially?
    * Write a function `function solution(blocks)`
    * that, given an array blocks consisting of N integers denoting the heights of the blocks, returns the longest possible distance that two can make between each other starting from one of the blocks.
    * Examples:
        1. Given blocks=[2, 6, 8, 5], the function should return 3. If starting from blocks[0], the first frog can stay where it is and the second frog can jump to blocks[2](but not to blocks[3])
        2. Given blocks=[1, 5, 5, 2, 6], the function should return 4. If starting from blocks[3], the first frog can jump to blocks[1], but not blocks[0], and the second frog can jump to blocks[4]