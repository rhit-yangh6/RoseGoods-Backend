package com.example.rosegoodsbackend.rdbms.service.impl;

import com.example.rosegoodsbackend.rdbms.entity.Table;
import com.example.rosegoodsbackend.rdbms.mapper.TableMapper;
import com.example.rosegoodsbackend.rdbms.service.ITableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jason Qiu
 * @since 2021-09-17
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableMapper, Table> implements ITableService {

}
