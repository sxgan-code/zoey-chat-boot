package cn.sxgan.chat.common.entity.converts;


import cn.sxgan.chat.common.entity.ChatUserBeauty;
import cn.sxgan.chat.common.entity.vo.ChatUserBeautyVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 靓号表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Mapper
public interface IChatUserBeautyConvert {
    IChatUserBeautyConvert INSTANCE = Mappers.getMapper(IChatUserBeautyConvert.class);
    
    ChatUserBeauty convert(ChatUserBeautyVO vo);
    
    ChatUserBeautyVO convert(ChatUserBeauty entity);
    
    List<ChatUserBeautyVO> convertList(List<ChatUserBeauty> list);
    
}