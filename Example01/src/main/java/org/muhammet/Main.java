package org.muhammet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.muhammet.entity.*;
import org.muhammet.utility.HibernateUtility;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayi girin: ");
        int num = scanner.nextInt();
        scanner.close();

        int sum = 0;

        for(int i=1;i<num;i++){
            if(num%i==0){
                sum+=i;
            }
        }

        if(sum==num){
            System.out.println(num + " mukemmel sayidir.");
        } else {
            System.out.println(num + " mukemmel sayi degildir.");
        }
    }
}