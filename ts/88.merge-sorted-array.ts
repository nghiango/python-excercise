/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number) {
   nums2.sort((a, b) => a - b);
   const tempNum1 = nums1.filter(num => num !== 0);

   const moreZero = m - tempNum1.length;

   if (tempNum1.length < m) {
      for (let index = 0; index < moreZero; index++) {
         tempNum1.push(0);
      }
   }

   tempNum1.sort((a, b) => a - b);
   let index = 0;
   let indexNum1 = 0;
   let indexNum2 = 0;
   const totalLeng = m + n;
   while (index < totalLeng) {
      if (tempNum1[indexNum1] > nums2[indexNum2] || indexNum1 >= m) {
         nums1[index] = nums2[indexNum2]
         indexNum2++;
      } else {
         nums1[index] = tempNum1[indexNum1];
         indexNum1++;
      }
      index++;
   }
   return nums1;
};
// const nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3
// console.log(merge(nums1, m, nums2, n));
// const numsTest1 = [-1,0,0,3,3,3,0,0,0], m1 = 6, numsTest2 = [1,2,2], n1 = 3
// console.log(merge(numsTest1, m1, numsTest2, n1));
// const nums1Case2 = [1,2,4,5,6,0], m2 = 5, nums2Cas2 = [3], n2 = 1
// console.log(merge(nums1Case2, m2, nums2Cas2, n2));
const nums1C3  = [-1,0,0,0,3,0,0,0,0,0,0], m3 = 5, nums2C3 = [-10,-1,0,0,1,2], n3 = 6
console.log(merge(nums1C3, m3, nums2C3, n3));
