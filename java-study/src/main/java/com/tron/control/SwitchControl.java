package com.tron.control;

public class SwitchControl {
    public static void main(String[] args) {
        //switch 支持的匹配类型包含 int byte short char  String Enum
        //why? switch底层维护着一个32位CPU指令跳转表，超出跳转表的长度处理不了。

        switch ("") {
            case "1":
                System.out.println("匹配成功进入该代码块");
                break;
            default:
                System.out.println("所有的case匹配失败进入该代码块，后面不用加break");
        }
    }
}
