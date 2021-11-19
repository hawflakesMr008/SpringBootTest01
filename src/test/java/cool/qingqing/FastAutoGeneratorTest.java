package cool.qingqing;

/**
 * @author 高山青
 * @Date 2021/11/14  -   20:50
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * 快速生成
 * </p>
 *
 * @author lanjerry
 * @since 2021-09-16
 */

	/**
	 * H2 代码生成
	 *
	 * @author hubin,lanjerry
	 * @since 1.0
	 */
	public class FastAutoGeneratorTest {

		/**
		 * 执行初始化数据库脚本
		 */
		@BeforeAll
		public static void before() throws SQLException {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			String url = "jdbc:mysql://localhost:3306/demo?serverTimezone=GMT%2B8";
			Properties info = new Properties();
			info.setProperty("user", "root");
			info.setProperty("password", "root");
			Connection connect = driver.connect(url, info);


			connect.close();
		}

		/**
		 * 数据源配置
		 */
		private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
				.Builder("jdbc:mysql://localhost:3306/demo?serverTimezone=GMT%2B8", "root", "root")
				.build();

		/**
		 * 策略配置
		 */
		private StrategyConfig.Builder strategyConfig() {
			return new StrategyConfig.Builder().addInclude("t_simple").addInclude("city"); // 设置需要生成的表名
		}

		/**
		 * 全局配置
		 */
		private GlobalConfig.Builder globalConfig() {
			return new GlobalConfig.Builder().fileOverride();
		}

		/**
		 * 包配置
		 */
		private PackageConfig.Builder packageConfig() {
			return new PackageConfig.Builder();
		}

		/**
		 * 模板配置
		 */
		private TemplateConfig.Builder templateConfig() {
			return new TemplateConfig.Builder();
		}

		/**
		 * 注入配置
		 */
		private InjectionConfig.Builder injectionConfig() {
			// 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
			return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
				System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
			});
		}

		/**
		 * 简单生成
		 */
		@Test
		public void testSimple() {
			FastAutoGenerator.create("jdbc:mysql://localhost:3306/demo?serverTimezone=GMT%2B8", "root", "root")
					.globalConfig(builder -> {
						builder.author("gaoshanqing") // 设置作者
								.enableSwagger() // 开启 swagger 模式
								.fileOverride() // 覆盖已生成文件
								.outputDir("D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\java"); // 指定输出目录
					})
					.packageConfig(builder -> {
						builder.parent("cool.qingqing") // 设置父包名
								.moduleName("SpringBootTest01") // 设置父包模块名
								.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\resources\\mappers")); // 设置mapperXml生成路径
					})
					.strategyConfig(builder -> {
						builder.addInclude("t_simple").addInclude("city") // 设置需要生成的表名
								.addTablePrefix("t_", "c_"); // 设置过滤表前缀
					})
					.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
					.execute();

			//generator.execute();
		}

		/**
		 * 过滤表前缀（后缀同理，支持多个）
		 * result: t_simple -> simple
		 */
		@Test
		public void testTablePrefix() {
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().addTablePrefix("t_", "c_").build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 过滤字段后缀（前缀同理，支持多个）
		 * result: deleted_flag -> deleted
		 */
		@Test
		public void testFieldSuffix() {
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().addFieldSuffix("_flag").build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 乐观锁字段设置
		 * result: 新增@Version注解
		 * 填充字段设置
		 * result: 新增@TableField(value = "xxx", fill = FieldFill.xxx)注解
		 */
		@Test
		public void testVersionAndFill() {
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().entityBuilder()
					.versionColumnName("version") // 基于数据库字段
					.versionPropertyName("version")// 基于模型属性
					.addTableFills(new Column("create_time", FieldFill.INSERT))    //基于数据库字段填充
					.addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))    //基于模型属性填充
					.build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 逻辑删除字段设置
		 * result: 新增@TableLogic注解
		 * 忽略字段设置
		 * result: 不生成
		 */
		@Test
		public void testLogicDeleteAndIgnoreColumn() {
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().entityBuilder()
					.logicDeleteColumnName("deleted") // 基于数据库字段
					.logicDeletePropertyName("deleteFlag")// 基于模型属性
					.addIgnoreColumns("age") // 基于数据库字段
					.build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 自定义模板生成的文件名称
		 * result: TSimple -> TSimpleEntity
		 */
		@Test
		public void testCustomTemplateName() {
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig()
					.entityBuilder().formatFileName("%sEntity")
					.mapperBuilder().formatMapperFileName("%sDao").formatXmlFileName("%sXml")
					.controllerBuilder().formatFileName("%sAction")
					.serviceBuilder().formatServiceFileName("%sService").formatServiceImplFileName("%sServiceImp")
					.build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 自定义模板生成的文件路径
		 *
		 * @see OutputFile
		 */
		@Test
		public void testCustomTemplatePath() {
			// 设置自定义路径
			Map<OutputFile, String> pathInfo = new HashMap<>();
			pathInfo.put(OutputFile.mapperXml, "D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\resources\\mappers");
			pathInfo.put(OutputFile.entity, "D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\java\\cool\\qingqing\\entity");
			pathInfo.put(OutputFile.controller, "D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\java\\cool\\qingqing\\controller");
			pathInfo.put(OutputFile.service, "D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\java\\cool\\qingqing\\service");
			pathInfo.put(OutputFile.serviceImpl, "D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\java\\cool\\qingqing\\service\\serviceImpl");
			pathInfo.put(OutputFile.mapper, "D:\\IDEAPACKAGE\\SpringBootTest01\\src\\main\\java\\cool\\qingqing\\mapper");
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().build());
			generator.packageInfo(packageConfig().pathInfo(pathInfo).build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 自定义模板
		 */
		@Test
		public void testCustomTemplate() {
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().build());
			generator.template(templateConfig()
					.entity("/templates/entity1.java")
					.build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 自定义注入属性
		 */
		@Test
		public void testCustomMap() {
			// 设置自定义属性
			Map<String, Object> map = new HashMap<>();
			map.put("abc", 123);
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().build());
			generator.template(templateConfig()
					.entity("/templates/entity1.java")
					.build());
			generator.injection(injectionConfig().customMap(map).build());
			generator.global(globalConfig().build());
			generator.execute();
		}

		/**
		 * 自定义文件
		 * key为文件名称，value为文件路径
		 * 输出目录为 other
		 */
		@Test
		public void testCustomFile() {
			// 设置自定义输出文件
			Map<String, String> customFile = new HashMap<>();
			customFile.put("test.txt", "/templates/test.vm");
			AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
			generator.strategy(strategyConfig().build());
			generator.injection(injectionConfig().customFile(customFile).build());
			generator.global(globalConfig().build());
			generator.execute();
		}
	}