package com.zhenzhen.demo.springboot2.springboot2demo;

import java.util.List;

/**
 * @author zhen.yin
 * @title:
 * @description:
 * @date 2020/12/8 9:32
 */
public class TwoLinkNumPuls {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        ListNode resultList = null;
        ListNode tempResultList = null;

        int flag = 0;
        while(tempL1!=null && tempL2!=null){
            int tempValue = tempL1.val + tempL2.val + flag;
            flag = 0;
            if(tempValue>=10){
                flag = 1;
                tempValue = tempValue -10;
            }

            if(resultList == null){
                tempResultList = new ListNode(tempValue);
                resultList = tempResultList;
            }else{
                tempResultList.next = new ListNode(tempValue);
                tempResultList = tempResultList.next;
            }

            tempL1 = tempL1.next;
            tempL2 = tempL2.next;
        }

        if(tempL1!=null){
            while(tempL1!=null){
                int tempValue = tempL1.val + flag;
                flag = 0;
                if(tempValue>=10){
                    flag = 1;
                    tempValue = tempValue -10;

                }
                if(resultList == null){
                    tempResultList = new ListNode(tempValue);
                    resultList = tempResultList;
                }else{
                    tempResultList.next = new ListNode(tempValue);
                    tempResultList = tempResultList.next;
                }

                tempResultList = tempResultList.next;
                tempL1 = tempL1.next;
            }
        }else if(tempL2!=null){
            while(tempL2!=null){
                int tempValue = tempL2.val + flag;
                flag = 0;
                if(tempValue>=10){
                    flag = 1;
                    tempValue = tempValue -10;

                }

                if(resultList == null){
                    tempResultList = new ListNode(tempValue);
                    resultList = tempResultList;
                }else{
                    tempResultList.next = new ListNode(tempValue);
                    tempResultList = tempResultList.next;
                }

                tempResultList = tempResultList.next;
                tempL2 = tempL2.next;
            }
        }

        if(flag==1){
            tempResultList.next = new ListNode(1,null);
        }

        return resultList;
    }

    public static void main(String[] args) {

        ListNode l1 = getListNode();
        ListNode l2 = getListNode();
        addTwoNumbers(l1,l2);


        System.out.println(l1);
    }

    private static ListNode getListNode() {
        ListNode l1 = new ListNode(1);
        ListNode temp = null;
        temp = l1;
        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;
        return l1;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
