package com.tron.system;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-27
 */
public class Start {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        //系统环境配置信息
        Properties properties = System.getProperties();

        //系统环境变量
        Map<String, String> getenv = System.getenv();

        //获取系统的默认地址
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        //获取所有网卡信息
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                if (!inetAddress.isLoopbackAddress() && inetAddress.getHostAddress().indexOf(':') == -1) {
                    System.out.println(nextElement.getName() + " " + inetAddress.getHostAddress());
                }
            }
        }


    }
}
