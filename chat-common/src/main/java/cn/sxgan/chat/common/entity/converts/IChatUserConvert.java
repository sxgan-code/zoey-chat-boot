package cn.sxgan.chat.common.entity.converts;


import cn.sxgan.chat.common.entity.ChatUser;
import cn.sxgan.chat.common.entity.vo.ChatUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 用户信息表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-01
 * @Version: 1.0.0
 **/
@Mapper
public interface IChatUserConvert {
    IChatUserConvert INSTANCE = Mappers.getMapper(IChatUserConvert.class);
    
    ChatUser convert(ChatUserVO vo);
    
    ChatUserVO convert(ChatUser entity);
    
    List<ChatUserVO> convertList(List<ChatUser> list);
    
}