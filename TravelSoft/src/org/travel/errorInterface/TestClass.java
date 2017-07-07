/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.travel.errorInterface;

import java.util.Arrays;

/**
 *
 * @author MichaelButnaru
 */
public class TestClass {
    public static void main(String [] args){
        System.out.println("Let's test to see if is worknig");
       String test = System.getProperty("user.name");
       String[] test1 = test.split("(?=\\p{Upper})");
        System.out.println(Arrays.toString(test1));
    }
}
