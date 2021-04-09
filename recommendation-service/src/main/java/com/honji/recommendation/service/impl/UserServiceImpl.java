package com.honji.recommendation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honji.recommendation.entity.User;
import com.honji.recommendation.mapper.UserMapper;
import com.honji.recommendation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2019-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {



}
