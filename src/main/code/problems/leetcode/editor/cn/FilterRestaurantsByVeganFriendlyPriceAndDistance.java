// Given the array restaurants where restaurants[i] = [idi, ratingi,
// veganFriendlyi, pricei, distancei]. You have to filter the restaurants using three filters.
//
//
// The veganFriendly filter will be either true (meaning you should only 
// include restaurants with veganFriendlyi set to true) or false (meaning you can include
// any restaurant). In addition, you have the filters maxPrice and maxDistance
// which are the maximum value for price and distance of restaurants you should
// consider respectively.
//
// Return the array of restaurant IDs after filtering, ordered by rating from 
// highest to lowest. For restaurants with the same rating, order them by id from
// highest to lowest. For simplicity veganFriendlyi and veganFriendly take value 1
// when it is true, and 0 when it is false.
//
// 
// Example 1: 
//
// 
// Input: restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5
//,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10
// Output: [3,1,5]
// Explanation:
// The restaurants are:
// Restaurant 1 [id=1, rating=4, veganFriendly=1, price=40, distance=10]
// Restaurant 2 [id=2, rating=8, veganFriendly=0, price=50, distance=5]
// Restaurant 3 [id=3, rating=8, veganFriendly=1, price=30, distance=4]
// Restaurant 4 [id=4, rating=10, veganFriendly=0, price=10, distance=3]
// Restaurant 5 [id=5, rating=1, veganFriendly=1, price=15, distance=1]
// After filter restaurants with veganFriendly = 1, maxPrice = 50 and
// maxDistance = 10 we have restaurant 3, restaurant 1 and restaurant 5 (ordered by rating
// from highest to lowest).
// 
//
// Example 2: 
//
// 
// Input: restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5
//,1,1,15,1]], veganFriendly = 0, maxPrice = 50, maxDistance = 10
// Output: [4,3,2,1,5]
// Explanation: The restaurants are the same as in example 1, but in this case
// the filter veganFriendly = 0, therefore all restaurants are considered.
// 
//
// Example 3: 
//
// 
// Input: restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5
//,1,1,15,1]], veganFriendly = 0, maxPrice = 30, maxDistance = 3
// Output: [4,5]
// 
//
// 
// Constraints: 
//
// 
// 1 <= restaurants.length <= 10^4 
// restaurants[i].length == 5 
// 1 <= idi, ratingi, pricei, distancei <= 10^5 
// 1 <= maxPrice, maxDistance <= 10^5 
// veganFriendlyi and veganFriendly are 0 or 1. 
// All idi are distinct. 
// 
//
// 👍 57 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Id：&emsp;&emsp;1333
 * <p>
 * Name：Filter Restaurants by Vegan-Friendly, Price and Distance
 *
 * @author Yuri
 * @since 2023-09-27 19:14:56
 */

public class FilterRestaurantsByVeganFriendlyPriceAndDistance {

    public static void main(String[] args) {
        Solution solution = new FilterRestaurantsByVeganFriendlyPriceAndDistance().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // stream
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            return Arrays.stream(restaurants)
                .filter(restaurant -> restaurant[3] <= maxPrice && restaurant[4] <= maxDistance
                    && restaurant[2] >= veganFriendly)
                .sorted((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1])
                .map(o -> o[0])
                .collect(Collectors.toList());
        }

        // 优先队列
        public List<Integer> filterRestaurants_PriorityQueue(int[][] restaurants, int veganFriendly, int maxPrice,
            int maxDistance) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {
                if (restaurants[o1][1] == restaurants[o2][1])
                    return restaurants[o2][0] - restaurants[o1][0];
                return restaurants[o2][1] - restaurants[o1][1];
            }));
            for (int i = 0; i < restaurants.length; i++) {
                int[] restaurant = restaurants[i];
                if (restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)
                    queue.add(i);
            }
            List<Integer> ans = new ArrayList<>();
            while (!queue.isEmpty()) ans.add(restaurants[queue.remove()][0]);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}