package com.baimiaomiao.spring6.bean;

import java.util.Arrays;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className YuQian
 * @since 1.0
 */


public class YuQian {
    private String[] hobbies;

    //多个女性朋友
    private Woman[] women;

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void setWomen(Woman[] women) {
        this.women = women;
    }

    @Override
    public String toString() {
        return "YuQian{" +
                "hobbies=" + Arrays.toString(hobbies) +
                ", women=" + Arrays.toString(women) +
                '}';
    }
}
