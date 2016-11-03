package com.zillion.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;  
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGeneratorUtil {

	public static void main(String[] args) {  
		List<String> warnings = new ArrayList<String>();  
        boolean overwrite = true;  
        
        //读取配置文件  
        File configFile = new File("src/generatorConfig.xml");  
        ConfigurationParser cp = new ConfigurationParser(warnings);  
        Configuration config = null; 
        
        try {  
       	 	System.out.println("执行开始....");
            config = cp.parseConfiguration(configFile);  
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
            MyBatisGenerator myBatisGenerator;  
            myBatisGenerator = new MyBatisGenerator(config, callback,warnings);  
	        myBatisGenerator.generate(null);  
	        
	        //打印结果  
	        for(String str : warnings){  
	        	System.out.println(str);  
	        }  
	        System.out.println("执行结束！");
           
       } catch (Exception e) {  
          e.printStackTrace();  
       }  
        
    }  
}
