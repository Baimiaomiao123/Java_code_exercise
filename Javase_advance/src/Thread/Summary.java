package Thread;

/*
    线程：
    1、什么是进程？什么是线程？
        进程是一个应用程序（1个进程是一个软件）
        线程是一个进程中的执行场景/执行单元
        一个进程可以启动多个线程
    2、对于java程序来说，当在DOS命令窗口中输入：
        java HelloWorld 回车之后
        会先启动JVM，而JVM就是一个进程
        JVM再启动一个主线程调用main方法
        同时再启动一个垃圾回收器线程负责看护，回收垃圾
        最起码，现在的java程序中至少有两个线程并发
        一个是垃圾回收线程，一个是执行main方法的主线程
    3、进程和线程是什么关系？举个例子
        阿里巴巴：进程
            马云：阿里巴巴的一个线程
            童文红：阿里巴巴的一个线程
        京东：进程
            刘强东：京东的一个线程
            奶茶妹妹：京东的一个线程
        进程可以看作是现实生活当中的公司
        线程可以看作是公司当中的某个员工

        注意：
            进程A和进程B的内存独立不共享。（阿里巴巴和京东资源不会共享）
                魔兽是一个进程，搜狗音乐是一个进程，两个进程是独立的，不共享资源
            线程A和线程B呢？
                在java语言中，线程A和线程B，堆内存和方法区内存共享。
                但是栈内存独立，一个线程一个栈。

                假设启动10个线程，会有10个栈空间，每个栈和每个栈之间互不干扰，各自执行各自的，这就是多线程并发

            火车站也可以看作一个进程。火车站中的每一个售票窗口可以看作一个线程
            在窗口1买票不会感染窗口2买票的，可以多线程买票，而且窗口1和窗口2共享了火车站的网上购票资源
    4、思考一个问题：
        使用了多线程机制之后，main方法结束，是不是有可能程序也不会结束
        main方法结束只是主线程结束了，主栈空了，其他的栈（线程）可能还在压栈弹栈
    5、分析一个问题，对于单核的CPU来说，真的可以做到真正的多线程并发吗？
        对于多核CPU电脑来说，可以真正的有4个进程并发执行
            4核CPU表示同时一个时间点上，可以真正的有4个进程并发执行

        什么是真正的多线程并发？
            t1线程执行t1的
            t2线程执行t2的
            t1不会影响t2，t2也不会影响t1，这叫做真正的多线程并发

        单核的CPU电脑表示只有一个大脑：
            不能够做到真正的多线程并发，但是可以做到给人一种"多线程并发"的感觉
            对于单核CPU来说，在某一个时间点上实际上只能处理一件事情，但是由于
            CPU的处理速度很快，多个线程之间频繁切换执行，跟人来的感觉是：多个事情同时在做！！！
                线程A：播放音乐
                线程B：运行魔兽游戏
                线程A和线程B频繁切换执行，人类会感觉音乐在一直播放，游戏一直在运行，给人类的感觉就是同时并发的

        电影院采用胶卷播放电影，一个胶卷播放速度达到一定程度之后，
        人类的眼睛产生了错觉，感觉是动画的，这说明人类的反应速度很慢，就像
        一根钢针扎到手上，到最终感觉到疼，这个过程是需要"很长的"时间，在
        这个期间计算机可以进行亿万次的循环，所以计算机的执行速度很快
    6、java语言中，实现线程有两种方式，哪两种方法呢？
        java支持多线程机制，并且已经将多线程实现了，我们只需要用它即可
        第一种方式：编写一个类，直接继承java.lang.Thread，重写run方法。
            //定义线程
            public class MyThread Extends Thread{
                public void run(){
                }
            }
            //创建线程对象
            MyThread myThread = new MyThread();
            //启动线程
            myThread.start();
        第二种方式：编写一个类，实现java.lang.Runnable接口。
            //定义一个可运行的类
            public class MyRunnable implements Runnable{
                public void run(){

                }
            }
            //创建线程对象
            Thread t = new Thread(new MyRunnable());
            //启动线程
            t.start();

       注意：第二种方式实现接口比较常用，因为一个类实现了接口，它还可以去继承其他的类。更灵活（面向接口编程）
    7、关于线程对象的生命周期？
        新建状态，就绪状态，运行状态，阻塞状态，死亡状态
 */
public class Summary {
    public static void main(String[] args) {

    }
}
/*
    1、关于线程的调度
        1.1常见的线程调度有哪些？
            抢占式调度模型：
                哪个线程的优先级比较高，抢到的CPU时间片的概率就高一些
                java就是采用的抢占式调度模型
            均分式调度模型：
                平均分配CPU时间片。每个线程占有的CPU时间片时间长度一样
                平均分配，一切平等
                有一些编程语言就是采用这种方法

        1.2java中提供哪些方法是和线程调度有关系的呢？
            实例方法：
                void setPriority(int newPriority) 设置线程的优先级
                int getPriority() 获取线程的优先级
                最低优先级1
                默认优先级是5
                最高优先级是10
                优先级比较高的获取CPU时间片可能会多一些。（但也不完全是，大概率是多的）

            静态方法：
                static void yield() 让位方法，暂停当前正在执行的线程对象，并执行其它线程
                yield()方法不是阻塞方法，让当前线程让位，让给其它线程使用
                yield()方法的执行会让当前线程从"运行状态"回到"就绪状态"
                注意：在回到"就绪状态"可能还会继续抢到

            实例方法：
                void join() 合并线程
                class MyThread1 extends Thread{
                    public void doSome(){
                        MyThread2 t = new MyThread2();
                        t.join(); //当前线程进入阻塞，t线程执行，直到t线程结束，当前线程才会继续

                    }
                }
                class MyThread2 extends Thread{

                }
    2、关于多线程并发环境下，数据的安全问题
        2.1、为什么这个是重点
            以后在开发中，我们的项目都是运行在服务器当中，而服务器已经将线程的定义，线程对象的创建，线程的
            启动等，都已经实现了，这些代码我们都不需要编写。
            最重要的是：你要知道，你编写的线程需要放到一个多线程的环境下运行，你更需要关注的是这些数据在多线程
            并发的环境下是否是安全的。

        2.2、什么时候数据在多线程并发的环境下会存在安全问题呢？
            三个条件：
                条件1：多线程并发
                条件2：有共享数据
                条件3：共享数据有修改的行为
            满足以上3个条件之后，就会存在线程安全问题

        2.3、怎么解决线程安全问题呢？
            当多线程并发的环境下，有共享数据，并且这个数据还会被修改，此时就会存在线程安全问题，解决方案：
                线程排队执行（不能并发）
                用排队执行解决线程安全问题
                这种机制被称为：线程同步机制

                专业术语叫做：线程同步，实际上就是线程不能并发了，线程必须排队执行

            怎么解决线程安全问题？
                使用"线程同步机制"。

            线程同步就是线程排队了，线程排队了就会牺牲一部分效率，没办法，数据安全第一位，只有数据安全了才能谈效率

        2.4、说到线程同步这块，涉及到这两个专业术语：

            异步编程模型：
                线程t1和线程t2，各自执行各自的，t1不管t2，t2不管t1，谁也不需要等谁，这种编程模型就叫做异步编程模型
                其实就是：多线程并发（效率较高。）
                异步就是并发。
            同步编程模型：
                线程t1和线程t2，在t1执行的时候，必须等待t2的执行结束或t2执行的时候，必须等待t1的执行结束。两个线程之间
                发生了等待关系，这就是同步编程模型
                但是效率较低，线程排队执行
                同步就是排队。

    3、java中有三个变量？

        实例变量：在堆中

        静态变量：在方法区中

        局部变量：在栈中

        注意以上三大变量中：
            局部变量都不会存在线程安全问题。
            因为局部变量不共享。（一个线程一个栈。），局部变量在栈中，所以局部变量永远都不会共享

        实例变量在堆中，堆只有1个
        静态变量在方法区中，方法区只有1个
        堆和方法区都是多线程共享的，所以成员变量（实例变量，静态变量）可能存在线程安全问题

        局部变量+常量：不会有线程安全问题
        成员变量：可能会有线程安全问题

    4、如果使用局部变量的话：
        建议使用：StringBuilder
        因为局部变量不存在线程安全问题。选择StringBuilder。而StringBuffer效率较低

      ArrayList是非线程安全的
      Vector是线程安全的
      HashMap HashSet是非线程安全的
      HashTable是线程安全的

    5、总结：
        synchronized有两种写法：
            第一种：同步代码块
                灵活
                synchronized (线程共享对象) {
                    同步代码块
                }

            第二种：在实例方法上使用synchronized
                表示共享对象一定是this（当前的类）
                并且同步代码块是整个方法体

            第三种：在静态方法上使用synchronized
                表示找类锁
                类锁永远只有1把
                就算创建了100个对象，那类锁也只有一把

    6、聊一聊，我们以后开发中怎么解决线程安全问题？

        是一上来就选择线程同步吗？ synchronized
            不是，synchronized会让程序的执行效率降低，用户的体验不好，
            系统的用户吞吐量降低，用户体验差。在不得已的情况下再选择

        第一种方案：尽量使用局部变量代替"实例变量和静态变量"

        第二种方案：如果必须是实例变量，那么可以考虑创建多个对象，这样
        实例变量的内存就不共享了。（一个线程对应一个对象，100个线程对应100个对象，
        对象不共享，就没有数据安全问题了）

        第三种方案：如果不能使用局部变量，对象也不能创建多个，这个时候只能选择synchronized了

    7、线程这块还有哪些内容呢？列举一下
        7.1、守护线程
            java语言中线程分为两大类：
                一类是：用户线程
                一类是：守护线程
                其中最具有代表性的是：垃圾回收线程（守护线程）

            守护线程的特点：
                一般守护线程是一个死循环，所有的用户线程只要结束，守护线程自动结束

            注意：主线程main方法是一个用户线程

            守护线程用在什么地方呢？
                每天00：00的时候系统数据自动备份。
                这个需要使用到定时器，并且我们可以将定时器设置为守护线程
                一直在那里看着，每到00：00的时候就备份一次。所有的用户线程如果结束了，
                守护线程自动退出，没有必要进行数据备份了

        7.2、定时器
            定时器的作用：
                间隔特定的时间，执行特定的程序。

                每周要进行银行账户的总账操作
                每天要进行数据的备份操作

                在实际的开发中，每隔多久执行一段特定的程序，这种需求是很常见的。
                那么java中其实可以采用多种方式实现：

                    可以使用sleep方法，睡眠，设置睡眠时间，每到这个时间点醒来，执行任务
                    这种方式是最原始的定时器。（比较low）

                    在java的类库中已经写好了一个定时器：java.util.Timer，可以直接拿来使用
                    不过，这种方式在目前的开发中也很少用，因为现在很多高级框架都是支持定时任务的

                    在实际的开发中，目前使用较多的是spring框架中提供的SpringTask框架，
                    这个框架只要进行简单的配置，就可以完成定时器的任务

        7.3、实现线程的第三种方式：FutureTask方式，实现Callable接口（JDK8新特性）
            这种方式实现的线程可以获取线程的返回值
            之前讲解的那两种方式是无法获取线程返回值的，因为run方法返回void

            思考：
                系统委派一个线程去执行一个任务，该线程执行完任务之后，可能
                会有一个执行结果，我们怎么能拿到这个执行结果呢
                    使用第三种方式：实现Callable接口

        7.4、关于Object类中的wait和notify方法（生产者和消费者模式）
            第一：wait和notify方法不是线程对象的方法，是java中任何一个java对象
            都有的方法，因为这个两个方法是Object的方法
                wait方法和notify方法不是通过线程对象调用的
                不是这样的：t.wait()，也不是t.notify()

            第二：wait()方法作用？
                Object o = new Object();
                o.wait();

                表示：让正在o对象上活动的线程进入等待状态，无期限等待，
                     直到被唤醒为止。
                     o.wait()方法的调用，会让"当前线程（正在o对象上
                     活动的线程）"进入等待状态。
            第三：notify()方法作用？
                Object o = new Object();
                o.notify();

                表示：唤醒正在o对象上等待的线程

                还有一个notifyAll()方法：
                    这个方法是唤醒o对象上处于等待的所有线程。


 */
