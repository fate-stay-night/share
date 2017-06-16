package xyz.vimtools.share;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 项目开始类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-25
 */
@EnableTransactionManagement//开启事务支持
@MapperScan("xyz.vimtools.share.domain.mapper")
@SpringBootApplication
@ServletComponentScan(value = "xyz.vimtools")
public class Share {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Share.class);
        springApplication.addListeners(new ApplicationPidFileWriter("flag.pid"));
        springApplication.run(args);
    }
}
