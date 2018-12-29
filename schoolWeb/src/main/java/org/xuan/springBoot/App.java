package org.xuan.springBoot;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: App
 * @Description: TODO功能描述:(这里用一句话描述这个类的作用)
 * @author 朱修轩
 * @date 2018年12月28日 上午11:05:07
 * @remark 备注:(这里是添加备注的信息...)
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}

}
