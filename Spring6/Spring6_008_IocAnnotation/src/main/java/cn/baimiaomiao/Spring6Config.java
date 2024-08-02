package cn.baimiaomiao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类，代替spring框架的配置文件
 * @author baimiaomiao
 * @version 1.0
 * @className Spring6Config
 * @since 1.0
 */

@Configuration
@ComponentScan({"cn.baimiaomiao.dao","cn.baimiaomiao.service"})
public class Spring6Config {
}
