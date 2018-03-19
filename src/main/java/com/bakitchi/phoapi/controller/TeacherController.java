package com.bakitchi.phoapi.controller;

import com.bakitchi.phoapi.dao.BaseDAO;
import com.bakitchi.phoapi.dto.TeacherBasicInfoDTO;
import com.bakitchi.phoapi.entity.TechAllEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.util.List;

/**
 * @Author: Bakitchi
 * @Created-Time: 2018/3/14 下午3:49
 * @Description:
 */
@RestController
@RequestMapping(value="/teacher")
public class TeacherController {
  @Autowired
  BaseDAO baseDAO;

  //获得基本信息
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public TeacherBasicInfoDTO TechIn(@PathVariable(value = "id") Integer id) throws Exception {
    return baseDAO.daoGetTeacherInfoById(id);
  }


  //Get留言板
  @RequestMapping(value="/message/{id}",method=RequestMethod.GET)
  public TeacherBasicInfoDTO TechBor(@PathVariable(value="id") Integer id) throws Exception{
    return null;
  }

  //Get留言板回复
  @RequestMapping(value="reply/{tid}/{sid}",method=RequestMethod.GET)
  public TeacherBasicInfoDTO BorRep(@PathVariable(value="tid") Integer tid,
                                    @PathVariable(value="sid") Integer sid){
    return null;
  }

  //新建留言板主题
  @RequestMapping(value="newmessage/{id}/{topic}/{content}",method = RequestMethod.POST)
  public TeacherBasicInfoDTO NewMess(@PathVariable(value="id") Integer id,
                                     @PathVariable(value="topic") String topic,
                                     @PathVariable(value="content") String content){
    return null;
  }

  //新建留言板回复
  @RequestMapping(value="newreply/{id}/{topic}/{content}",method=RequestMethod.POST)
  public TeacherBasicInfoDTO NewReply(@PathVariable(value="id") Integer id,
                                      @PathVariable(value="topic")String toopic,
                                      @PathVariable(value="content")String content){
    return null;
  }

  //Get老师访问量
  @RequestMapping(value="visit/{id}",method = RequestMethod.GET)
  public Integer Visit(@PathVariable(value="id")Integer id){
    return baseDAO.daoGetVisitByTeacherId(id);
  }

  //Update老师访问量
  @RequestMapping(value="newvisit/{id}",method=RequestMethod.PATCH)
  public void NewVisit(@PathVariable(value="id")Integer id){
    baseDAO.daoUpdateVisitByTeacherId(id);
  }

  //修改教师基本信息
  @RequestMapping(value="newtechinfo/{id}",method = RequestMethod.PUT)
  public TeacherBasicInfoDTO NewTechInfo(@PathVariable(value="id")Integer id){
    return null;
  }

  //修改教师参与项目
  @RequestMapping(value="newpro/{id}",method = RequestMethod.PUT)
  public TeacherBasicInfoDTO NewProInfo(@PathVariable(value="id")Integer id){
    return null;
  }

  //修改教师论文
  @RequestMapping(value = "newpaper/{id}",method = RequestMethod.PUT)
  public TeacherBasicInfoDTO NewPaper(@PathVariable(value="id")Integer id){
    return null;
  }

  //获得访问次数最多的十个老师List
  @RequestMapping(value = "/maxVisit",method = RequestMethod.GET)
  public List<TechAllEntity> getMostVisitTeachers(){
    return baseDAO.daoGetMostVisitTeacher();
  }

  //获得最近修改的十个老师List
  @RequestMapping(value = "/recentModify",method = RequestMethod.GET)
  public List<TechAllEntity> getRecentModifyTeachers() throws ParseException {
    return baseDAO.daoGetRecentModifyTeacher();
  }

  //Get发送查询字符串和查询类别 获得查询结果
  //typ取NAME时按名字准确查找
  //typ取DIRECTION时按方向模糊查找
  //tpy取ABSTRCT时全文检索
  //tpy取其他值返回null
  @RequestMapping(value="/query",method = RequestMethod.GET)
  public List<TechAllEntity> getQueryResults(@RequestParam(value="typ")String typ,@RequestParam(value = "wd") String wd){
    System.out.println(typ+wd);
    return baseDAO.daoQueryTeacher(typ, wd);
  }

  //按教师ID更新教师基本信息
  @RequestMapping(value = "/modifyBrief/{id}",method = RequestMethod.PUT)
  public void updateTeacherInfo(@PathVariable(value = "id") Integer id, @RequestParam(value = "info") String info){
    baseDAO.daoUpdateAbstract(id, info);
  }

  //按教师ID更新教师项目
  @RequestMapping(value = "/modifyPro/{id}",method = RequestMethod.PUT)
  public void updateTeacher(@PathVariable(value = "id") Integer id, @RequestParam(value = "info") String info){
    baseDAO.daoUpdateTeacherPro(id, info);
  }

  //按教师ID更新教师招生信息
  @RequestMapping(value = "/modifyWanted/{id}",method = RequestMethod.PUT)
  public void updateTeacherWanted(@PathVariable(value = "id") Integer id, @RequestParam(value = "info") String info){
    baseDAO.daoUpdateTeacherWanted(id, info);
  }

}
