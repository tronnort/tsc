package com.tron.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @auther tron
 * @create 2019-11-14
 * <p>
 * <p>
 *         场景分析：有一个字符串>>>"rows=[Rowcolumns=[1, c], Rowcolumns=[2, java], Rowcolumns=[3, ruby], Rowcolumns=[4, go], Rowcolumns=[5, python], Rowcolumns=[6, lua], Rowcolumns=[7, csharp], Rowcolumns=[8, ajax], Rowcolumns=[9, jsp]]";"
 * <p>
 *         现在要截取[ ]中的数据，即1,c/2,java/3,ruby...
 * <p>
 *         那么根据上述的套路，首先我们要写出一个正则并将其编译为Pattern类的实例，因为上述字符串中[ ]有两种形态，一种是"rows=["，另一种是"Rowcolumes=["，我们只想匹配后面的这种子串，所以
 * <p>
 *         1.直接选取“ns=[”作为开头，先写出这个子串的表达式“ns”是具体的字母，不用改变，"="和"["都是特殊字符，需要进行转义，因此“ns=[”的正则表达式为"ns\\=\\["，同理结尾匹配"\\]"
 * <p>
 *         2.这样已经匹配了开头，但我们想截取的字符串并不想带上开头和结尾，因此需要运用零宽断言，举例来说(?=exp)代表匹配以exp结尾的字符串，但匹配出来的结果并不带exp，例如(?=ing)匹配reading，结果为read；(?<=exp)匹配以exp开头的字符串，但结果不带exp，例如(?<=read)匹配reading，结果为ing。这样一来我们的问题都解决了，运用零宽断言，开头匹配"(?<=ns\\=\\[)"，结尾匹配"(?=\\])"
 * <p>
 *         3.开头和结尾都搞定了，还差中间，我们队中间的数据没有要求，因此直接匹配".*"（任意字符匹配0次或多次），但是这里有一个问题是，这个表达式是贪心的，因此它会匹配完整个字符串，即"(?<=ns\\=\\[).*(?=\\])"匹配的结果是"2, java], Rowcolumns=[3, ruby], Rowcolumns=[4, go], Rowcolumns=[5, python], Rowcolumns=[6, lua], Rowcolumns=[7, csharp], Rowcolumns=[8, ajax], Rowcolumns=[9, jsp"，显然不是我们想要的，因此再添加一个"?"（前面的内容匹配0次或1次）
 * <p>
 *         4.最后需要截取的子串的正则表达式就是"(?<=ns\\=\\[).*?(?=\\])"
 */
public class Start {
    public static void main(String[] args) {
        String startWith = "<a>";
        String endWith = "</a>";
        String str = "分割线<a>123abcd</a>分割线<a>1</a>分割线<a>88</a>分割线";
        //过滤写法
        List list = matchString(startWith, endWith, str);
        System.out.println(list);

        List list1 = matchString("a", "b", "111a111b111a999bbbaaabbb");
        System.out.println(list1);


    }


    //截取字符串中指定开头和结尾之间的内容
    private static List matchString(String startWith, String endWith, String str) {
        Pattern pattern = Pattern.compile("(?<=" + startWith + ").*?(?=" + endWith + ")");
        Matcher matcher = pattern.matcher(str);
        ArrayList<String> strings = new ArrayList<>();
        while (matcher.find()) {
            strings.add(matcher.group());
        }
        return strings;
    }
}
