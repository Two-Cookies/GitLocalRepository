import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *      给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *
 *
 *  解法： 采用回溯的思想，加上深度优先搜索，只不过是全不查询
 */
public class LC0009 {
    public List<String> letterCombinations(String digits) {
        //存放结果集
        List<String> list = new ArrayList<>();

        if (digits == null || digits.length()==0) return list;
        Map<Character,String> hashmap = new HashMap<>();
        hashmap.put('2',"abc");
        hashmap.put('3',"def");
        hashmap.put('4',"ghi");
        hashmap.put('5',"jkl");
        hashmap.put('6',"mno");
        hashmap.put('7',"pqrs");
        hashmap.put('8',"tuv");
        hashmap.put('9',"wxyz");

        StringBuilder sb = new StringBuilder();
        domethod(digits,0,hashmap,list,sb); // 入口
        return list;
    }

    private void domethod(String digits, int index, Map<Character, String> hashmap, List<String> list, StringBuilder sb) {
        if (index == digits.length()){  //当长度符合条件时，将结果存进结果容器中
            list.add(String.valueOf(sb));
        }else {
            String s = hashmap.get(digits.charAt(index));
            for (int i = 0;i < s.length();i++){ //深度搜索的变形，对每一层的几个选项（节点）进行遍历
                sb.append(s.charAt(i));
                domethod(digits,index+1,hashmap,list,sb);   //递归进行深搜
                sb.deleteCharAt(index);     //回溯操作
            }
        }
    }
}
