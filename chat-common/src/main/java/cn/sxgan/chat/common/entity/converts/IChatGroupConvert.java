package cn.sxgan.chat.common.entity.converts;


import cn.sxgan.chat.common.entity.ChatGroup;
import cn.sxgan.chat.common.entity.vo.ChatGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 群组表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Mapper
public interface IChatGroupConvert {
    IChatGroupConvert INSTANCE = Mappers.getMapper(IChatGroupConvert.class);
    
    ChatGroup convert(ChatGroupVO vo);
    
    ChatGroupVO convert(ChatGroup entity);
    
    List<ChatGroupVO> convertList(List<ChatGroup> list);
    
}