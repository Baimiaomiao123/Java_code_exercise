package com.baimiaomiao.javassist.test;

public interface AccountDaoTest {
    void delete();
    int insert(String actno);
    int update(String actno,Double balance);

    String selectByActno(String actno);
}
