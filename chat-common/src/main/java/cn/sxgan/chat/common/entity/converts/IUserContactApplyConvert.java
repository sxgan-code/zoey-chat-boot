package cn.sxgan.chat.common.entity.converts;


import cn.sxgan.chat.common.entity.UserContactApply;
import cn.sxgan.chat.common.entity.vo.UserContactApplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 联系人申请表实体转换接口
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Mapper
public interface IUserContactApplyConvert {
    IUserContactApplyConvert INSTANCE = Mappers.getMapper(IUserContactApplyConvert.class);
    
    UserContactApply convert(UserContactApplyVO vo);
    
    UserContactApplyVO convert(UserContactApply entity);
    
    List<UserContactApplyVO> convertList(List<UserContactApply> list);
    
}