package com.think.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yc
 * @description
 * @date 2021-10-28 14:54
 */
public class IntersectionOfTwoSets {

    public static void main(String[] args) {
        Set<String> arr = new HashSet();
        for (int i = 0; i < 1000000; i++) {
            arr.add("role" + i);
        }

        Set<String> arr2= new HashSet();
        for (int i = 1000000; i > 0; i--) {
            arr.add("role" + i);
        }
        long time = System.currentTimeMillis();
        System.out.println(hasElement(arr, arr2));
        time = System.currentTimeMillis() - time;
        System.out.println("10000花费时间:" + time);

        time = System.currentTimeMillis();
        System.out.println(hasElement2(arr, arr2));
        time = System.currentTimeMillis() - time;
        System.out.println("10000花费时间:" + time);

    }

    public static boolean hasElement(Set<String> userRoles, Set<String> uriRoles) {
        if(userRoles.size() == 0 || uriRoles.size() == 0){
            return false;
        }
        return userRoles.stream().anyMatch(uriRoles::contains);
    }

    public static boolean hasElement2(Set<String> userRoles, Set<String> uriRoles) {
        if(userRoles.size() == 0 || uriRoles.size() == 0){
            return false;
        }
        return userRoles.retainAll(uriRoles);
    }
}
