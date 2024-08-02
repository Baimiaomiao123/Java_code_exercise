package com.baimiaomiao.bank.web;


import com.baimiaomiao.bank.exceptions.MoneyNotEoughException;
import com.baimiaomiao.bank.exceptions.TransferException;
import com.baimiaomiao.bank.service.AccountService;
import com.baimiaomiao.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    //为了让这个对象在其他方法中也可以用，声明为实例变量
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));

        try {
            //调用service的转账方法完成转账（调业务层）
            accountService.transfer(fromActno,toActno,money);
            //程序走到这里表示转账成功了，调用View完成展示结果
            response.sendRedirect(request.getContextPath() + "/TransferSuccess.html");
        } catch (MoneyNotEoughException e) {
            response.sendRedirect(request.getContextPath() + "/MoneyNotEoughError.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath() + "/TransferError.html");
        } catch (Exception e){
            response.sendRedirect(request.getContextPath() + "/TransferError2.html");
        }

    }
}
