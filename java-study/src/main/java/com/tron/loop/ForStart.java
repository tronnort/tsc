package com.tron.loop;

public class ForStart {
    public static void main(String[] args) {

        //初始化指令; 条件判断; 循环变量修改
        for (int i = 0, j= 10, k = 100; i <10; i++ ,j--,k-=10) {
//            i+=1;  //第三部分代码可以在这里执行
            System.out.println(i+"-----"+j+"-----"+k);
        }
    }
}
