// Design a time-based key-value data structure that can store multiple values
// for the same key at different time stamps and retrieve the key's value at a
// certain timestamp.
//
// Implement the TimeMap class: 
//
// 
// TimeMap() Initializes the object of the data structure. 
// void set(String key, String value, int timestamp) Stores the key key with 
// the value value at the given time timestamp.
// String get(String key, int timestamp) Returns a value such that set was 
// called previously, with timestamp_prev <= timestamp. If there are multiple such
// values, it returns the value associated with the largest timestamp_prev. If there
// are no values, it returns "".
// 
//
// 
// Example 1: 
//
// 
// Input
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
//, ["foo", 5]]
// Output
//[null, null, "bar", "bar", null, "bar2", "bar2"]
//
// Explanation
// TimeMap timeMap = new TimeMap();
// timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along
// with timestamp = 1.
// timeMap.get("foo", 1);         // return "bar"
// timeMap.get("foo", 3);         // return "bar", since there is no value
// corresponding to foo at timestamp 3 and timestamp 2, then the only value is at
// timestamp 1 is "bar".
// timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along
// with timestamp = 4.
// timeMap.get("foo", 4);         // return "bar2"
// timeMap.get("foo", 5);         // return "bar2"
// 
//
// 
// Constraints: 
//
// 
// 1 <= key.length, value.length <= 100 
// key and value consist of lowercase English letters and digits. 
// 1 <= timestamp <= 10⁷ 
// All the timestamps timestamp of set are strictly increasing. 
// At most 2 * 10⁵ calls will be made to set and get. 
// 
//
// 👍 234 👎 0

package problems.leetcode.editor.cn;

import cn.hutool.core.lang.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Id：&emsp;&emsp;981
 * <p>
 * Name：Time Based Key-Value Store
 *
 * @author Yuri
 * @since 2024-08-15 16:09:16
 */

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class TimeMap {


        Map<String, Pair<List<String>, List<Integer>>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key))
                map.put(key, new Pair<>(
                    Stream.of("").collect(Collectors.toList()),
                    Stream.of(-1).collect(Collectors.toList()))); // 初始位置填充个-1，方便后面没找到更小time的情况下返回""
            Pair<List<String>, List<Integer>> pair = map.get(key);
            pair.getKey().add(value);
            pair.getValue().add(timestamp);
        }

        public String get(String key, int timestamp) {
            Pair<List<String>, List<Integer>> pair = map.get(key);
            if (pair == null) return "";
            return pair.getKey().get(dichotomy(pair.getValue(), timestamp) - 1); // 二分找的是大于timestamp的位置，减1就变为了小于等于的位置
        }

        private int dichotomy(List<Integer> nums, int t) {
            int l = 0, r = nums.size();
            while (l < r) {
                int mid = l + r >> 1;
                if (nums.get(mid) <= t) l = mid + 1;
                else r = mid;
            }
            return l;
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// leetcode submit region end(Prohibit modification and deletion)

}