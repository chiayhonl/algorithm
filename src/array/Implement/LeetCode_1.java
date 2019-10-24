package array.Implement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chiayhon
 * @create 2019 - 10 - 24
 */
public class LeetCode_1 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[][] res = new int[3][];
        res[0] = new Solution().twoSum(nums, target);
        res[1] = new Solution2().twoSum(nums, target);
        res[2] = new Solution2().twoSum(nums, target);

        for(int[] n : res){
            System.out.println(Arrays.toString(n));
        }

    }
}

//暴力方法：T(N) = O(N^2) , S(N) = O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length ; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == target - nums[j])
                    return new int[] {i , j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");//没有int[]数组则抛出异常
    }
}

//两遍哈希表 T(N) = O(N) , S(N) = O(N)
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i], i);
        }
        for(int i = 0 ; i < nums.length ; i++){
            int res = target - nums[i];
            if(map.containsKey(res) && i != map.get(res)){
                return new int[] {i , map.get(res)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");//没有int[]数组则抛出异常
    }
}

//一遍哈希表 T(N) = O(N) , S(N) = O(N)
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            int res = target - nums[i];
            if(map.containsKey(res)){
                return new int[] {map.get(res) , i};
            }
            map.put(nums[i] , i);
        }
        throw new IllegalArgumentException("No two sum solution");//没有int[]数组则抛出异常
    }
}
