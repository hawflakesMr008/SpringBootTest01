package cool;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/*
提示：如果你不想使用 @SpringBootApplication，
则它导入的 @EnableAutoConfiguration 和 @ComponentScan
注解定义了该行为，因此也可以使用。

所以@Component标签会被@SpringBootApplication扫描注入到容器
位置在上层目录的原因也是扫描他的下层文件夹
 */
@MapperScan("cool.qingqing.SpringBootTest01.mapper")
@SpringBootApplication
public class SpringBootTest01Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest01Application.class, args);
	}

	/*private final com.baomidou.mapper.CityMapper cityMapper;

	public SpringBootTest01Application(com.baomidou.mapper.CityMapper cityMapper){
		this.cityMapper=cityMapper;
	}*/
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(this.cityMapper.findByState("CA"));
	}
}
