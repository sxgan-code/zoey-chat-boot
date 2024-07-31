package cn.sxgan.chat.core;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "cn.sxgan.chat.common.mappers", markerInterface = BaseMapper.class, annotationClass = Mapper.class)
@ComponentScan(basePackages = {"cn.sxgan.chat.common", "cn.sxgan.chat.core"})
public class ChatCoreApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ChatCoreApplication.class, args);
    }
    
}
