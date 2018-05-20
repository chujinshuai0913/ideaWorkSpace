package common.service.Impl;

import common.mapper.TypeBook1Mapper;
import common.mapper.TypeBook2Mapper;
import common.mapper.TypeProfessional1Mapper;
import common.mapper.TypeProfessional2Mapper;
import common.model.TypeBook1;
import common.model.TypeBook2;
import common.model.TypeProfessional1;
import common.model.TypeProfessional2;
import common.query.TypeBook1Query;
import common.query.TypeBook2Query;
import common.service.ClassTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.apache.log4j.Logger.getLogger;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/10 10:40 星期二
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ClassTypeServiceImpl implements ClassTypeService {
    private static final Logger logger = getLogger(ClassTypeServiceImpl.class);

    @Autowired
    private TypeBook1Mapper typeBook1Mapper;

    @Autowired
    private TypeBook2Mapper typeBook2Mapper;

    @Autowired
    private TypeProfessional2Mapper typeProfessional2Mapper;

    @Autowired
    private TypeProfessional1Mapper typeProfessional1Mapper ;

    @Override
    public List<TypeBook1> queryTypeBook1List(TypeBook1 typeBook1) {
        return typeBook1Mapper.queryTypeBook1List(typeBook1);
    }

    @Override
    public List<TypeBook1> getTypeBook1Lists(TypeBook1Query query) {
        return typeBook1Mapper.queryTypeBook1Lists(query);
    }

    @Override
    public int getTypeBook1ListCount(TypeBook1Query query) {
        return typeBook1Mapper.queryTypeBook1Count(query);
    }

    @Override
    public List<TypeBook2> getTypeBook2Lists(TypeBook2Query query) {
        return typeBook2Mapper.queryTypeBook2Lists(query);
    }

    @Override
    public int getTypeBook2ListCount(TypeBook2Query query) {
        return typeBook2Mapper.queryTypeBook2Count(query);
    }
    @Override
    public TypeBook1 queryTypeBook1(TypeBook1 typeBook1) {
        return null;
    }

    @Override
    public String queryTypeBook1ById(int id) {
        return typeBook1Mapper.queryTypeBook1ById(id);
    }

    @Override
    public int insertTypeBook1(TypeBook1 typeBook1) {
        return typeBook1Mapper.insert(typeBook1);
    }

    @Override
    public int insertTypeBook1List(List<TypeBook1> typeBook1List) {
        return 0;
    }

    @Override
    public int updateTypeBook1(TypeBook1 typeBook1) {
        return typeBook1Mapper.updateByPrimaryKeySelective(typeBook1);
    }

    @Override
    public int updateTypeBook1List(List<TypeBook1> typeBook1List) {
        return 0;
    }

    @Override
    public List<TypeBook2> queryTypeBook2List(TypeBook2 typeBook2) {
        return typeBook2Mapper.queryTypeBook2List(typeBook2);
    }

    @Override
    public TypeBook2 queryTypeBook2(TypeBook2 typeBook2) {
        return null;
    }

    @Override
    public String queryTypeBook2ById(int id) {
        return typeBook2Mapper.queryTypeBook2ById(id);
    }

    @Override
    public int insertTypeBook2(TypeBook2 typeBook2) {
        return 0;
    }

    @Override
    public int insertTypeBook2List(List<TypeBook2> typeBook2List) {
        return 0;
    }

    @Override
    public int updateTypeBook2(TypeBook2 typeBook2) {
        return 0;
    }

    @Override
    public int updateTypeBook2List(List<TypeBook2> typeBook2List) {
        return 0;
    }

    @Override
    public List<TypeProfessional1> queryTypeProfessional1List(TypeProfessional1 typeProfessional1) {
        return typeProfessional1Mapper.queryTypeProfessional1List(typeProfessional1);
    }

    @Override
    public TypeProfessional1 queryTypeProfessional1(TypeProfessional1 typeProfessional1) {
        return null;
    }

    @Override
    public String queryTypeProfessional1ById(int id) {
        return typeProfessional1Mapper.queryTypeProfessional1ById(id);
    }

    @Override
    public int insertTypeProfessional1(TypeProfessional1 typeProfessional1) {
        return 0;
    }

    @Override
    public int insertTypeProfessional1List(List<TypeBook1> typeProfessional1List) {
        return 0;
    }

    @Override
    public int updateTypeProfessional1(TypeProfessional1 typProfessional1) {
        return 0;
    }

    @Override
    public int updateTypeProfessional1List(List<TypeProfessional1> typProfessional1List) {
        return 0;
    }

    @Override
    public List<TypeProfessional2> queryTypeProfessional2List(TypeProfessional2 typeProfessional2) {
        return typeProfessional2Mapper.queryTypeProfessional2List(typeProfessional2);
    }

    @Override
    public TypeProfessional2 queryTypeProfessional2(TypeProfessional2 typeProfessional2) {
        return null;
    }

    @Override
    public String queryTypeProfessional2ById(int id) {
        return typeProfessional2Mapper.queryTypeProfessional2ById(id);
    }

    @Override
    public int insertTypeProfessional2(TypeProfessional2 typeProfessional2) {
        return 0;
    }

    @Override
    public int insertTypeProfessional2List(List<TypeProfessional2> typeProfessional2List) {
        return 0;
    }

    @Override
    public int updateTypeProfessional2(TypeProfessional2 typProfessional2) {
        return 0;
    }

    @Override
    public int updateTypeProfessional2List(List<TypeProfessional2> typProfessional2List) {
        return 0;
    }
}
