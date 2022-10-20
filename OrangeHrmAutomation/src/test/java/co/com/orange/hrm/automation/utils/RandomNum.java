package co.com.orange.hrm.automation.utils;

import java.util.Random;

public class RandomNum {
    public static int randomNumber(){
        Random random = new Random();
        return random.nextInt(100000-1);
    }
}
