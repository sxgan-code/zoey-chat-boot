package cn.sxgan.chat.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "cn.sxgan.chat.common.mappers", markerInterface = BaseMapper.class, annotationClass = Mapper.class)
@ComponentScan(basePackages = {"cn.sxgan.chat.admin", "cn.sxgan.chat.common", "cn.sxgan.chat.core"})
public class ChatAdminApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ChatAdminApplication.class, args);
    }
    
}
