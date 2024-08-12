package cn.sxgan.chat.common.mappers;

import cn.sxgan.chat.common.entity.UserContact;
import cn.sxgan.chat.common.entity.query.UserContactQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 联系人关联表映射mapper
 * @Author: sxgan sxgan@foxmail.com
 * @Date: 2024-08-12
 * @Version: 1.0.0
 **/
@Mapper
public interface IUserContactMapper extends BaseMapper<UserContact> {
    List<UserContact> selectUserContactByCondition(UserContactQuery query);
}