/**
 * 3. 无重复字符最长子串
 *      给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LC0003 {

    public static void main(String[] args) {
        //String s = "abcabcdaccd";
        String s = "adda";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        //边界
        if (s==null || s.equals(""))return 0;
        //使用hashtable来记录元素出现的下表
        int[] hashtable = new int[256];
        //hashtable初始化为-1，避免0下表的元素与初始化0冲突
        for (int i = 0;i<256;i++){
            hashtable[i] = -1;
        }
        //当前长度
        int curDistance = 0;
        //最大长度
        int maxDistance = 1;
        //循环对字符串检索
        for (int i = 0;i<s.length();i++){
            if (hashtable[s.charAt(i)] == -1) { //若字符没有出现过，则将hashtable对应的下标出放入该字符在字符串中出现的位置下表，并把当前长度+1.
                hashtable[s.charAt(i)] = i;
                curDistance++;
            }else {
                int distance = i-hashtable[s.charAt(i)];    //若字符已出现，求出两次字符之间的距离length，
                if (curDistance>maxDistance)    //判断当前长度是否大于最大长度
                    maxDistance = curDistance;
                //对当前出现的重复字符判断，若大于curDistance，则说明他在之前出现的重复字符之外，使curDistance = curDistance+1；否则出现在子串之内，curDistance = distance
                //例子：abba
                curDistance = distance>curDistance?curDistance+1:distance;
                //将重复字符的在hashtable中保存的下表进行更换
                hashtable[s.charAt(i)] = i;
            }
        }

        //若从上次出现过重复字符，直到字符串结尾都没有再出现重复字符串，则不会走到else分支，这里需要进行一次判断，更新maxDistance
        if (curDistance>maxDistance)
            maxDistance = curDistance;
        return maxDistance;
    }
}
