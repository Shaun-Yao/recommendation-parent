package com.honji.recommendation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honji.recommendation.entity.Note;
import com.honji.recommendation.entity.User;
import com.honji.recommendation.mapper.NoteMapper;
import com.honji.recommendation.mapper.UserMapper;
import com.honji.recommendation.service.INoteService;
import com.honji.recommendation.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2019-03-01
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements INoteService {



}
