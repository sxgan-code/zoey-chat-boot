package cn.sxgan.chat.common.mappers;

import cn.sxgan.chat.common.entity.ChatGroup;
import cn.sxgan.chat.common.entity.query.ChatGroupQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 群组表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Mapper
public interface IChatGroupMapper extends BaseMapper<ChatGroup> {
    List<ChatGroup> selectChatGroupByCondition(ChatGroupQuery query);
}