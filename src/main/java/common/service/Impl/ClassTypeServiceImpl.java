package common.service.Impl;

import com.alibaba.fastjson.JSONObject;
import common.mapper.*;
import common.model.*;
import common.query.TypeBook1Query;
import common.query.TypeBook2Query;
import common.query.TypeProfessional1Query;
import common.query.TypeProfessional2Query;
import common.service.ClassTypeService;
import common.util.DateUtils;
import common.util.ServiceResult;
import common.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class ClassTypeServiceImpl implements ClassTypeService {
    private static final Logger logger = getLogger(ClassTypeServiceImpl.class);

    @Autowired
    private UserManagerMapper userManagerMapper;
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
    public ServiceResult<List<TypeBook1Vo>> getTypeBook1Lists(TypeBook1Query query) {
        try {
            List<TypeBook1Vo> typeBook1Vos=new ArrayList<>();
            List<TypeBook1> typeBook1s=new ArrayList<>();

            ServiceResult<List<TypeBook1>> serviceResult=new ServiceResult<>(typeBook1Mapper.queryTypeBook1Lists(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (TypeBook1 typeBook1:serviceResult.getBody()) {
                    TypeBook1Vo typeBook1Vo= new TypeBook1Vo();
                    typeBook1Vos.add(this.getTypeBook1Vo(typeBook1Vo,typeBook1));
                }
            }
            return new ServiceResult<>(typeBook1Vos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }
   private TypeBook1Vo getTypeBook1Vo(TypeBook1Vo typeBook1Vo,TypeBook1 typeBook1){
       try {
           typeBook1Vo = JSONObject.parseObject(JSONObject.toJSONString(typeBook1),TypeBook1Vo.class);
           typeBook1Vo.setcUser("");
           typeBook1Vo.setcTime("");
           if(typeBook1.getcT()!=null&&typeBook1.getcT()>0)
           {
               typeBook1Vo.setcTime(DateUtils.getDateStringByTimeStamp(typeBook1.getcT(),DateUtils.YMDHMS));
           }
           if (typeBook1.getcU()!=null&&typeBook1.getcU()>0){
               ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(typeBook1.getcU()));
               if(result.getSuccess()&&result.getBody()!=null){
                   typeBook1Vo.setcUser(result.getBody().getUsername());
               }
           }
           return typeBook1Vo;
       }catch (Exception e){
           logger.error(e.getMessage(),e);
           return new TypeBook1Vo();
       }
    }
    @Override
    public int getTypeBook1ListCount(TypeBook1Query query) {
        return typeBook1Mapper.queryTypeBook1Count(query);
    }

    @Override
    public ServiceResult<List<TypeBook2Vo>> getTypeBook2Lists(TypeBook2Query query) {
        try {
            List<TypeBook2Vo> typeBook2Vos=new ArrayList<>();
            List<TypeBook2> typeBook2s=new ArrayList<>();

            ServiceResult<List<TypeBook2>> serviceResult=new ServiceResult<>(typeBook2Mapper.queryTypeBook2Lists(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (TypeBook2 typeBook2:serviceResult.getBody()) {
                    TypeBook2Vo typeBook2Vo= new TypeBook2Vo();
                    typeBook2Vos.add(this.getTypeBook2Vo(typeBook2Vo,typeBook2));
                }
            }
            return new ServiceResult<>(typeBook2Vos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }

    }
    private TypeBook2Vo getTypeBook2Vo(TypeBook2Vo typeBook2Vo,TypeBook2 typeBook2){
        try {
            typeBook2Vo = JSONObject.parseObject(JSONObject.toJSONString(typeBook2),TypeBook2Vo.class);
            typeBook2Vo.setcUser("");
            typeBook2Vo.setcTime("");
            if(typeBook2.getcT()!=null&&typeBook2.getcT()>0)
            {
                typeBook2Vo.setcTime(DateUtils.getDateStringByTimeStamp(typeBook2.getcT(),DateUtils.YMDHMS));
            }
            if (typeBook2.getcU()!=null&&typeBook2.getcU()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(typeBook2.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    typeBook2Vo.setcUser(result.getBody().getUsername());
                }
            }
            return typeBook2Vo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new TypeBook2Vo();
        }
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
    public int queryTypeBook1ByName(TypeBook1Query query) {
        return typeBook1Mapper.queryTypeBook1ByName(query);
    }

    @Override
    public int queryTypeBook2ByName(TypeBook2Query query) {
        return  typeBook2Mapper.queryTypeBook2ByName(query);
    }

    @Override
    public int queryTypeProfessional1ByName(TypeProfessional1Query query) {
        return  typeProfessional1Mapper.queryTypeProfessional1ByName(query);
    }

    @Override
    public int queryTypeProfessional2ByName(TypeProfessional2Query query) {
        return  typeProfessional2Mapper.queryTypeProfessional2ByName(query);
    }

    @Override
    public int insertTypeBook1(TypeBook1Query query) {
        return typeBook1Mapper.insert(query);
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
    public int insertTypeBook2(TypeBook2Query query) {
       return   typeBook2Mapper.insert(query);
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
    public ServiceResult<List<TypeProfessional1Vo>> getTypeProfessional1Lists(TypeProfessional1Query query) {
        try {
            List<TypeProfessional1Vo> typeProfessional1Vos=new ArrayList<>();
            List<TypeProfessional1> typeProfessional1s=new ArrayList<>();

            ServiceResult<List<TypeProfessional1>> serviceResult=new ServiceResult<>(typeProfessional1Mapper.queryTypeProfessional1Lists(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (TypeProfessional1 typeProfessional1:serviceResult.getBody()) {
                    TypeProfessional1Vo typeProfessional1Vo= new TypeProfessional1Vo();
                    typeProfessional1Vos.add(this.getTypeProfessional1Vo(typeProfessional1Vo,typeProfessional1));
                }
            }
            return new ServiceResult<>(typeProfessional1Vos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }
    private TypeProfessional1Vo getTypeProfessional1Vo(TypeProfessional1Vo typeProfessional1Vo,TypeProfessional1 typeProfessional1){
        try {
            typeProfessional1Vo = JSONObject.parseObject(JSONObject.toJSONString(typeProfessional1),TypeProfessional1Vo.class);
            typeProfessional1Vo.setcUser("");
            typeProfessional1Vo.setcTime("");
            if(typeProfessional1.getcT()!=null&&typeProfessional1.getcT()>0)
            {
                typeProfessional1Vo.setcTime(DateUtils.getDateStringByTimeStamp(typeProfessional1.getcT(),DateUtils.YMDHMS));
            }
            if (typeProfessional1.getcU()!=null&&typeProfessional1.getcU()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(typeProfessional1.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    typeProfessional1Vo.setcUser(result.getBody().getUsername());
                }
            }
            return typeProfessional1Vo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new TypeProfessional1Vo();
        }
    }
    @Override
    public int getTypeProfessional1ListCount(TypeProfessional1Query query) {
        return typeProfessional1Mapper.queryTypeProfessional1Count(query);
    }

    @Override
    public ServiceResult<List<TypeProfessional2Vo>> getTypeProfessional2Lists(TypeProfessional2Query query) {
        try {
            List<TypeProfessional2Vo> typeProfessional2Vos=new ArrayList<>();
            List<TypeProfessional2> typeProfessional2s=new ArrayList<>();

            ServiceResult<List<TypeProfessional2>> serviceResult=new ServiceResult<>(typeProfessional2Mapper.queryTypeProfessional2Lists(query));
            if (serviceResult.getSuccess()&&serviceResult.getBody()!=null){
                for (TypeProfessional2 typeProfessional2:serviceResult.getBody()) {
                    TypeProfessional2Vo typeProfessional2Vo= new TypeProfessional2Vo();
                    typeProfessional2Vos.add(this.getTypeProfessional2Vo(typeProfessional2Vo,typeProfessional2));
                }
            }
            return new ServiceResult<>(typeProfessional2Vos) ;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new ServiceResult<>(11,e.getMessage());
        }
    }
    private TypeProfessional2Vo getTypeProfessional2Vo(TypeProfessional2Vo typeProfessional2Vo,TypeProfessional2 typeProfessional2){
        try {
            typeProfessional2Vo = JSONObject.parseObject(JSONObject.toJSONString(typeProfessional2),TypeProfessional2Vo.class);
            typeProfessional2Vo.setcUser("");
            typeProfessional2Vo.setcTime("");
            if(typeProfessional2.getcT()!=null&&typeProfessional2.getcT()>0)
            {
                typeProfessional2Vo.setcTime(DateUtils.getDateStringByTimeStamp(typeProfessional2.getcT(),DateUtils.YMDHMS));
            }
            if (typeProfessional2.getcU()!=null&&typeProfessional2.getcU()>0){
                ServiceResult<UserManager> result=new ServiceResult<>(userManagerMapper.queryUserShareManagerById(typeProfessional2.getcU()));
                if(result.getSuccess()&&result.getBody()!=null){
                    typeProfessional2Vo.setcUser(result.getBody().getUsername());
                }
            }
            return typeProfessional2Vo;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new TypeProfessional2Vo();
        }
    }
    @Override
    public int getTypeProfessional2ListCount(TypeProfessional2Query query) {
        return typeProfessional2Mapper.queryTypeProfessional2Count(query);
    }

    @Override
    public String queryTypeProfessional1ById(int id) {
        return typeProfessional1Mapper.queryTypeProfessional1ById(id);
    }

    @Override
    public int insertTypeProfessional1(TypeProfessional1Query query) {
        return typeProfessional1Mapper.insert(query);
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
    public int insertTypeProfessional2(TypeProfessional2Query query) {
        return typeProfessional2Mapper.insert(query);
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

    @Override
    public ServiceResult<Integer> updateBookClass1Status(List<Integer> ids, int status, int cU, int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + typeBook1Mapper.updateBookClass1Status(id, status,cU,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> updateBookClass2Status(List<Integer> ids, int status, int cU, int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + typeBook2Mapper.updateBookClass2Status(id, status,cU,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> updateTypeProfessional1Status(List<Integer> ids, int status, int cU, int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + typeProfessional1Mapper.updateTypeProfessional1Status(id, status,cU,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> updateTypeProfessional2Status(List<Integer> ids, int status, int cU, int cTime) {
        int count = 0;
        ServiceResult<Integer> serviceResult = new ServiceResult();
        serviceResult.setBody(0);
        for (Integer id : ids) {
            count = count + typeProfessional2Mapper.updateTypeProfessional2Status(id, status,cU,cTime);
        }
        if (count == ids.size()) {
            serviceResult.setBody(1);
        }

        return serviceResult;
    }


}
