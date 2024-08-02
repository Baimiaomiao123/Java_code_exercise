package com.baimiaomiao.spring6.biz;

import org.springframework.stereotype.Service;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className VipService
 * @since 1.0
 */

@Service
public class VipService {

    public void saveVip(){
        System.out.println("新增会员信息");
    }

    public void deleteVip(){
        System.out.println("删除会员信息");
    }

    public void updateVip(){
        System.out.println("修改会员信息");
    }

    public void getVip(){
        System.out.println("查找会员信息");
    }
}
