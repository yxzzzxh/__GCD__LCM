package com.yxzzzxh;

import java.util.Scanner;

public class Main {


    static int gcd(int a, int b){
        if(Integer.max(a,b)%Integer.min(a,b) == 0){
            return Integer.min(a,b);
        }else{
            return gcd(Integer.max(a,b)-Integer.min(a,b),Integer.min(a,b));
        }
    }

    static int lcm(int a, int b){
        int g = gcd(a,b);
        return gcd(a,b)*(a/g)*(b/g);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();


        System.out.println(gcd(A,B));
        System.out.println(lcm(A,B));



    }
}
