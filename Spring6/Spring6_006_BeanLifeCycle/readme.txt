Bean的生命周期五步：
    第一步：实例化Bean
    第二步：Bean属性赋值
    第三步：初始化Bean
    第四步：使用Bean
    第五步：销毁Bean

Bean的生命周期七步：比五步添加的那两步在哪里？在初始化Bean的前和后（BeanPostProcessor接口）
    第一步：实例化Bean
    第二步：Bean属性赋值
    第三步：执行"Bean后处理器"的before方法
    第四步：初始化Bean
    第五步：执行"Bean后处理器"的after方法
    第六步：使用Bean
    第七步：销毁Bean

Bean的生命周期十步：比七步添加的那三步在哪里？
    点位1：在"Bean后处理器"before方法之前（Aware接口相关接口：BeanNameAware, BeanClassLoaderAware, BeanFactoryAware）
    点位2：在"Bean后处理器"before方法之后（InitializingBean接口）
    点位3：使用Bean之后，销毁Bean之前（DisposableBean接口）
    添加的这三个点位都是检查BeanFactory是否实现特定的接口，是的话就会调用这个接口的方法