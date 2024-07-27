package Leetcode;

import java.util.*;

public class LongestBand {
    public static void main(String[] args) {
        int arr[] = new int[]{1,9,3,0,18,5,2,4,10,7,12,6};
//
            Set<Integer> A1 = new TreeSet<>();
            for (int i = 0; i < arr.length; i++) {
                A1.add(arr[i]);
            }
        System.out.println(A1);
            int band=1;
            int maxBand=0;
        for (int x:A1) {
            if(A1.contains(x+1)){
                band++;
            } else {
                if(maxBand<band){
                    maxBand=band;
                    band=1;
                }
            }
        }
        System.out.println(maxBand);

        Set<Integer> A = new HashSet<>();
        for(int i =0; i<arr.length; i++){
            A.add(arr[i]);
        }
        System.out.println(A);
        int max=0;
        int cnt =1;
        for (int element:A) {
            int parent = element-1;
            if(!A.contains(parent)){
                int next_no = element+1;
              while (A.contains(next_no)){
                  cnt++;
                  next_no++;
              }
            }
            if(cnt>max) {
                max=cnt;
                cnt=1;
            }
            }
        System.out.println(max);
        }
    }