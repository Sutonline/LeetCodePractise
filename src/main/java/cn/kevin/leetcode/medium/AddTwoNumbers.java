package cn.kevin.leetcode.medium;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author yongkang.zhang
 * created at 19/09/2018
 */
public class AddTwoNumbers {


    public static LinkedList<Integer> addTowNumbers(LinkedList<Integer> first, LinkedList<Integer> second) {
        int carryPortion = 0;
        int loop = 0;
        int firstInt = 0;
        int secondInt = 0;
        LinkedList<Integer> resultList = new LinkedList<>();
        while (loop < first.size() || loop < second.size()) {
            if (loop < first.size()) {
               firstInt = first.get(loop);
            } else {
               firstInt = 0;
            }

            if (loop < second.size()) {
                secondInt = second.get(loop);
            } else {
                secondInt = 0;
            }

            int sum = firstInt + secondInt + carryPortion;
            if (sum >= 10) {
                carryPortion = 1;
                resultList.add(sum - 10);
            } else {
                carryPortion = 0;
                resultList.add(sum);
            }

            loop++;
        }

        if (carryPortion == 1) {
            resultList.add(carryPortion);
        }

        return resultList;
    }

    public static void main(String[] args) {
        LinkedList<Integer> firstList = new LinkedList<>();
        firstList.add(2);
        firstList.add(4);
        firstList.add(3);
        firstList.add(4);
        LinkedList<Integer> secondlist = new LinkedList<>();
        secondlist.add(5);
        secondlist.add(6);
        secondlist.add(4);
        secondlist.add(5);
        secondlist.add(7);

        LinkedList<Integer> integers = addTowNumbers(firstList, secondlist);
        System.out.println(integers);
    }
}
