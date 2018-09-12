package com.ebei.eba;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * 代码自动生成
 */
public class CodeGenerator {
	public static void main(String[] args) {

		boolean fileOverride = true; //覆盖文件开关 true开启

		// 数据库连接
		String[] includeArr = {"tzm_device_level"};
		String tablePrefix = "tzm_"; 		//设置了前缀生成bean时排除前缀 ts_user 转换为 user
		String logicDeleteFieldName  = "del_state";//逻辑删除字段


		/* VM中调用 ${cfg.***}*/
		Map<String, Object> map = new HashMap<>();
		map.put("version","auto code version 1.4");
		map.put("getLabelAndValueList", true); //前端下拉框数据  生成 getLabelAndValueList
		//map.put("value", "area_id"); // 可设置 默认主键={X}_id
		//map.put("label", "area_name");//可设置 默认名称={X}_name  X根据主键获取
		//map.put("order", "operate_date desc");//非必填
		map.put("needEmptyMethod",true);
		map.put("emptyMethods","emptyMethod1,emptyMethod2,getShowDeviceLevelPage".split(",")); //写个空方法提高效率 monthA,monthB  如果需要分许请在结尾带Page

		String url = "jdbc:mysql://localhost:3306/qpi_ys";
		String userName = "root";
		String password = "root";
		// 全局配置
		//String outPutDir = "D:\\generator"; // 生成路径
		String outPutDir = "C:\\WorkspaceWebstrom\\eba-management-service\\src\\main\\java";
		String author = "yangsm"; // 作者
		IdType type = IdType.AUTO; // 主键策略
		// 策略配置
		String sngleName = ""; //单表生成替换名称 暂时无用
		String parent = "com.ebei.eba";

		AutoGenerator autoGenerator = new AutoGenerator();
		autoGenerator.setTemplateEngine(new VelocityTemplateEngine());/**选择模板引擎，默认 Veloctiy 可选 freemarker */
		
		// 1. 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setActiveRecord(false) // 是否支持AR模式
				.setOutputDir(outPutDir) // 生成路径
				.setFileOverride(fileOverride) // 文件覆盖
				 .setIdType(type) // 主键策略
				.setServiceName("%sService") // 设置生成的service接口的名字的首字母是否为I,例:IEmployeeService
				.setBaseResultMap(true) //
				.setBaseColumnList(true) //
				.setEnableCache(false) //
				.setAuthor(author); // 作者
		autoGenerator.setGlobalConfig(gc);

		// 2. 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDriverName("com.mysql.jdbc.Driver") //
				.setDbType(DbType.MYSQL)
				.setUrl(url) //
				.setUsername(userName) //
				.setPassword(password);
		autoGenerator.setDataSource(dsc);

		// 3. 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setCapitalMode(true) // 全局大写命名
				.setDbColumnUnderline(true) // 指定表名 字段名是否使用下划线
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
				.setTablePrefix(tablePrefix) //
				.setInclude(includeArr); // 生成的表
		strategy.setRestControllerStyle(true); //rest 风格
		strategy.setLogicDeleteFieldName(logicDeleteFieldName);
		autoGenerator.setStrategy(strategy);

		// 4. 包名策略配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(parent).setMapper("mapper") //
				.setService("service") //
				.setController("controller") //
				.setEntity("model.entity")//
				.setXml("mapper");
		autoGenerator.setPackageInfo(pc);
		
		// 5. 自定义模版配置
		TemplateConfig tc = new TemplateConfig();
		tc.setController("/templates/controller.java.vm");
        tc.setService("/templates/service.java.vm");
        tc.setServiceImpl("/templates/serviceImpl.java.vm");
        tc.setEntity("/templates/entity.java.vm");
        tc.setMapper("/templates/mapper.java.vm");
        tc.setXml(null);
		autoGenerator.setTemplate(tc);

        // 6.自定义配置
        // 自定义属性(可无)
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                this.setMap(map);
            }
        };

        /* 自定义生成路径(可无) Mapper为自定义目录 */
        String mapperPath = outPutDir + "\\..\\resources\\mapper";
        mkDir(new File(mapperPath));
        
        List<FileOutConfig> fileOutList = new ArrayList<>();
        fileOutList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return mapperPath + "\\" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

		injectionConfig.setFileOutConfigList(fileOutList);
		autoGenerator.setCfg(injectionConfig);

		// 5. 执行
		autoGenerator.execute();

		System.err.println("全局变量"+autoGenerator.getCfg().getMap());
	}
	
	// 递归创建文件夹
	public static void mkDir(File file) {
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			mkDir(file.getParentFile());
			file.mkdir();
		}
	}
}
