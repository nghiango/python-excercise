// https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while(left < right) {
      int width = right - left;
      int actualHeight = Math.min(height[left], height[right]);
      int tempMax = actualHeight * width;
      if (max < tempMax) {
        max = tempMax;
      }
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    ContainerWithMostWater container = new ContainerWithMostWater();
    int[] height = {1,8,6,2,5,4,8,3,7};
    System.out.println(container.maxArea(height));
    int[] height1 = {1, 1};
    System.out.println(container.maxArea(height1));
  }
}
