//复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件： 
//
// 
// 实部 是一个整数，取值范围是 [-100, 100] 
// 虚部 也是一个整数，取值范围是 [-100, 100] 
// i² == -1 
// 
//
// 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1+1i", num2 = "1+1i"
//输出："0+2i"
//解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1+-1i", num2 = "1+-1i"
//输出："0+-2i"
//解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
// 
//
// 
//
// 提示： 
//
// 
// num1 和 num2 都是有效的复数表示。 
// 
//
// Related Topics 数学 字符串 模拟 👍 142 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;537
 * <p>
 * Name：复数乘法
 *
 * @author Yuri
 * @since 2022-07-06 14:56:36
 */

public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        Solution solution = new ComplexNumberMultiplication().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            int k1 = num1.indexOf("+");
            int k2 = num2.indexOf("+");
            String strX = num1.substring(0, k1);
            String strY = num1.substring(k1 + 1, num1.length() - 1);
            String strA = num2.substring(0, k2);
            String strB = num2.substring(k2 + 1, num2.length() - 1);
            int x = Integer.parseInt(strX);
            int y = Integer.parseInt(strY);
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);
            int n1 = x * a - y * b;
            int n2 = x * b + y * a;
            return n1 + "+" + n2 + "i";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}