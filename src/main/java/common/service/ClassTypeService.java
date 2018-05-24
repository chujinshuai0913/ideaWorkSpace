package common.service;

import common.model.*;
import common.query.TypeBook1Query;
import common.query.TypeBook2Query;
import common.query.TypeProfessional1Query;
import common.query.TypeProfessional2Query;
import common.util.ServiceResult;
import common.vo.TypeBook1Vo;
import common.vo.TypeBook2Vo;
import common.vo.TypeProfessional1Vo;
import common.vo.TypeProfessional2Vo;

import java.util.List;

/**
 * Title: <br>
 * Description: <br>
 * Copyright: Copyright (c) 2017<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author :chujinshuai
 * @time :2018/4/10 10:39 星期二
 */
public interface ClassTypeService {


   /*浏览历史*/
   ServiceResult<List<SearchHistory>> getSearchHistoryList(SearchHistory query);

  /*  查询图书一级分类列表*/
  ServiceResult<List<TypeBook1>> queryTypeBook1List(TypeBook1Query query);

  ServiceResult<List<TypeBook1Vo>> getTypeBook1Lists(TypeBook1Query query);

  int getTypeBook1ListCount(TypeBook1Query query);

  ServiceResult<List<TypeBook2Vo>> getTypeBook2Lists(TypeBook2Query query);

  int getTypeBook2ListCount(TypeBook2Query query);

  ServiceResult<List<TypeBook1Vo>> queryTypeBook12List(TypeBook1Query query);

  ServiceResult<List<TypeProfessional1Vo>> queryTypeProfessional12List(TypeProfessional1Query query);


  /*  查询图书一级分类*/
  TypeBook1 queryTypeBook1(TypeBook1Query query);

  /*  查询图书一级分类*/
  String queryTypeBook1ById(int id);

  int queryTypeBook1ByName(TypeBook1Query query);

  int queryTypeBook2ByName(TypeBook2Query query);

  int queryTypeProfessional1ByName(TypeProfessional1Query query);

  int queryTypeProfessional2ByName(TypeProfessional2Query query);
  int insertTypeBook1(TypeBook1Query query);
  int insertTypeBook1List(List<TypeBook1> typeBook1List);
  int updateTypeBook1(TypeBook1 typeBook1);
  int updateTypeBook1List(List<TypeBook1> typeBook1List);

  /*  查询图书二级分类*/
  ServiceResult<List<TypeBook2>> queryTypeBook2List(TypeBook2Query query);

  /*  查询图书二级分类*/
  TypeBook2 queryTypeBook2(TypeBook2 typeBook2);

  /*  查询图书二级分类*/
  String queryTypeBook2ById(int id);

  int insertTypeBook2(TypeBook2Query query);
  int insertTypeBook2List(List<TypeBook2> typeBook2List);
  int updateTypeBook2(TypeBook2 typeBook2);
  int updateTypeBook2List(List<TypeBook2> typeBook2List);
  /*  查询图书学院列表*/
  ServiceResult<List<TypeProfessional1>> queryTypeProfessional1List(TypeProfessional1Query typeProfessional1);

  /*  查询学院*/
  TypeProfessional1 queryTypeProfessional1(TypeProfessional1 typeProfessional1);


  ServiceResult<List<TypeProfessional1Vo>> getTypeProfessional1Lists(TypeProfessional1Query query);

  int getTypeProfessional1ListCount(TypeProfessional1Query query);

  ServiceResult<List<TypeProfessional2Vo>> getTypeProfessional2Lists(TypeProfessional2Query query);

  int getTypeProfessional2ListCount(TypeProfessional2Query query);

  /*  学院*/
  String queryTypeProfessional1ById(int id);

  int insertTypeProfessional1(TypeProfessional1Query query);
  int insertTypeProfessional1List(List<TypeBook1> typeProfessional1List);
  int updateTypeProfessional1(TypeProfessional1 typProfessional1);
  int updateTypeProfessional1List(List<TypeProfessional1> typProfessional1List);
  /*  查询专业*/
  ServiceResult<List<TypeProfessional2>>queryTypeProfessional2List(TypeProfessional2Query typeProfessional2);

  /*  查询专业*/
  TypeProfessional2 queryTypeProfessional2(TypeProfessional2 typeProfessional2);

  /*  专业*/
  String queryTypeProfessional2ById(int id);

  int insertTypeProfessional2(TypeProfessional2Query query);
  int insertTypeProfessional2List(List<TypeProfessional2> typeProfessional2List);
  int updateTypeProfessional2(TypeProfessional2 typProfessional2);
  int updateTypeProfessional2List(List<TypeProfessional2> typProfessional2List);

   ServiceResult<Integer> updateBookClass1Status(List<Integer> ids,int status,int cU,int cTime);

  ServiceResult<Integer> updateBookClass2Status(List<Integer> ids,int status,int cU,int cTime);


  ServiceResult<Integer> updateTypeProfessional1Status(List<Integer> ids,int status,int cU,int cTime);

  ServiceResult<Integer> updateTypeProfessional2Status(List<Integer> ids,int status,int cU,int cTime);
}
