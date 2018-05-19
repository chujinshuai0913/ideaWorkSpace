package common.service;

import common.model.TypeBook1;
import common.model.TypeBook2;
import common.model.TypeProfessional1;
import common.model.TypeProfessional2;

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

  /*  查询图书一级分类列表*/
  List<TypeBook1> queryTypeBook1List(TypeBook1 typeBook1);

  /*  查询图书一级分类*/
  TypeBook1 queryTypeBook1(TypeBook1 typeBook1);

  /*  查询图书一级分类*/
  String queryTypeBook1ById(int id);


  int insertTypeBook1(TypeBook1 typeBook1);
  int insertTypeBook1List(List<TypeBook1> typeBook1List);
  int updateTypeBook1(TypeBook1 typeBook1);
  int updateTypeBook1List(List<TypeBook1> typeBook1List);

  /*  查询图书二级分类*/
  List<TypeBook2> queryTypeBook2List(TypeBook2 typeBook2);

  /*  查询图书二级分类*/
  TypeBook2 queryTypeBook2(TypeBook2 typeBook2);

  /*  查询图书二级分类*/
  String queryTypeBook2ById(int id);

  int insertTypeBook2(TypeBook2 typeBook2);
  int insertTypeBook2List(List<TypeBook2> typeBook2List);
  int updateTypeBook2(TypeBook2 typeBook2);
  int updateTypeBook2List(List<TypeBook2> typeBook2List);
  /*  查询图书学院列表*/
  List<TypeProfessional1> queryTypeProfessional1List(TypeProfessional1 typeProfessional1);

  /*  查询学院*/
  TypeProfessional1 queryTypeProfessional1(TypeProfessional1 typeProfessional1);

  /*  学院*/
  String queryTypeProfessional1ById(int id);

  int insertTypeProfessional1(TypeProfessional1 typeProfessional1);
  int insertTypeProfessional1List(List<TypeBook1> typeProfessional1List);
  int updateTypeProfessional1(TypeProfessional1 typProfessional1);
  int updateTypeProfessional1List(List<TypeProfessional1> typProfessional1List);
  /*  查询专业*/
  List<TypeProfessional2> queryTypeProfessional2List(TypeProfessional2 typeProfessional2);

  /*  查询专业*/
  TypeProfessional2 queryTypeProfessional2(TypeProfessional2 typeProfessional2);

  /*  专业*/
  String queryTypeProfessional2ById(int id);

  int insertTypeProfessional2(TypeProfessional2 typeProfessional2);
  int insertTypeProfessional2List(List<TypeProfessional2> typeProfessional2List);
  int updateTypeProfessional2(TypeProfessional2 typProfessional2);
  int updateTypeProfessional2List(List<TypeProfessional2> typProfessional2List);
}
