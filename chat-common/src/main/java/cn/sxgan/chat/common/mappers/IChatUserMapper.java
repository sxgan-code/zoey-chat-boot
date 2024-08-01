package cn.sxgan.chat.common.mappers;

import cn.sxgan.chat.common.entity.ChatUser;
import cn.sxgan.chat.common.entity.query.ChatUserQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 用户信息表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-01
 * @Version: 1.0.0
 **/
@Mapper
public interface IChatUserMapper extends BaseMapper<ChatUser> {
    List<ChatUser> selectChatUserByCondition(ChatUserQuery query);
}