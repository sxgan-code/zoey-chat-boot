package cn.sxgan.chat.common.entity.converts;


import cn.sxgan.chat.common.entity.UserContact;
import cn.sxgan.chat.common.entity.vo.UserContactVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 联系人关联表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Mapper
public interface IUserContactConvert {
    IUserContactConvert INSTANCE = Mappers.getMapper(IUserContactConvert.class);
    
    UserContact convert(UserContactVO vo);
    
    UserContactVO convert(UserContact entity);
    
    List<UserContactVO> convertList(List<UserContact> list);
    
}