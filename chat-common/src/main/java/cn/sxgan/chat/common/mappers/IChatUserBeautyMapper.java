package cn.sxgan.chat.common.mappers;

import cn.sxgan.chat.common.entity.ChatUserBeauty;
import cn.sxgan.chat.common.entity.query.ChatUserBeautyQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 靓号表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Mapper
public interface IChatUserBeautyMapper extends BaseMapper<ChatUserBeauty> {
    List<ChatUserBeauty> selectChatUserBeautyByCondition(ChatUserBeautyQuery query);
}