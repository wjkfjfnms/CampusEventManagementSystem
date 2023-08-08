package com.six.campuseventmanagementsystem;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {  //代码生成器类
    public static void main(String[] args) {
        //填入数据库配置
        String url="jdbc:mysql://localhost:3306/microservic?useSSL=FALSE&serverTimezone=GMT%2B8&characterEncoding=UTF8";
        String username="root";
        String password="hxx11771177";
        String moduleName="campuseventmanagementsystem";
        String mapperLocation="D:\\校园赛事活动管理系统\\CampusEventManagementSystem\\src\\main\\resources\\mapper\\"+moduleName;
        String tables="tb_user";//填上数据库里的所有表名，用逗号隔开
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("TheSix") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\校园赛事活动管理系统\\CampusEventManagementSystem\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.six") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("tb_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
