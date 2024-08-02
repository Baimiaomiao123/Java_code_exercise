package Simulation;

//充当角色发生了改变：webapp开发者
//只要是我们webapp开发者写的xxxServlet都要实现Servlet接口
public class UserLoginServlet implements servlet {

  @Override
    public void service() {
    System.out.println("UserLoginServlet's service...");
  }
}
