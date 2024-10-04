package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 * https://leetcode.cn/problems/restore-ip-addresses/
 */
public class LC13_RestoreIp_Addresses {

    /**
     * 思路：回溯
     * 这道题的解法就是扫描字符串，分为4步扫描字符串，一步确定一个数字，
     * 如果这个字符长度为1，就OK，如果这个数据有2个字符，那么比如>10,如果这个数字有三个字符 比如>=100 <=255 否则就是不合法
     * 当 步骤走完，而且字符串也扫描完毕就说明这个Path包含的字符串合法。否则就不合法，但是也需要退出
     * @param s
     * @return
     */

    List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        char[] charArray = s.toCharArray();
        List<String> path = new ArrayList<>();
        restoreIpAddresses_r(charArray,0,4,0,path);

        return list;
    }

    private void restoreIpAddresses_r(char[] charArray, int k, int n, int index,List<String> path) {
        if (k == n) {
            if (index == charArray.length) {
                String ipAddr = String.join(".", path);
                list.add(ipAddr);
            }
            return;
        }

        int num = Math.min(3,charArray.length - index);
        for (int i = 0; i< num;i++) {
            if (isOk(charArray,index,index + i)) {
                String ipPart = String.valueOf(charArray, index, i + 1);
                path.add(ipPart);
                restoreIpAddresses_r(charArray,k+1,n,index + i + 1,path);
                path.remove(path.size() - 1);   
            }
        }
    }

    private boolean isOk(char[] charArray, int start, int end) {
        if (end - start == 0) {
            return true;
        }

        if (charArray[start] == '0') {
            return false;
        }

        String value = String.valueOf(charArray, start, end - start + 1);
        int num = Integer.parseInt(value);
        return num <= 255;
    }

}
