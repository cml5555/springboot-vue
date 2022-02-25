package com.cml.demo.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cml.demo.dao.Mapper;
import com.cml.demo.pojo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired(required = false)
    private Mapper mapper;

    @GetMapping("")
    public List<User> save1(){
        System.out.println("查询所有..");
       // List<User> users = mapper.selectAll();
        List<User> users = mapper.selectList(null);
        return users;
    }
    @PostMapping("")
    public Integer save(@RequestBody User user){
        System.out.println(user);
        return mapper.insert(user);
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return mapper.deleteById(id);

    }
    @PutMapping()
    public Integer update(@RequestBody User user){
       return mapper.update(user,null);

    }
    @GetMapping("/page")
    public IPage<User> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                    @RequestParam String username,@RequestParam String email,@RequestParam String phoneNum){
//        pageNum=(pageNum-1)*pageSize;
//        username="%"+username+"%";
//        email="%"+email+"%";
//        phoneNum="%"+phoneNum+"%";
//        Integer total=mapper.selectTotal(username,email,phoneNum);
//        List<User> users = mapper.page(pageNum, pageSize,username,email,phoneNum);
//        Map<String,Object> map=new HashMap<>();
//        map.put("data",users);
//        map.put("total",total);
//        return map;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("username",username).like("email",email).like("phoneNum",phoneNum);
        //IPage<User> page = new Page<>(pageNum,pageSize,true);

        return mapper.selectPage(new Page<User>(pageNum,pageSize,true), wrapper);

    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<User> users = mapper.selectList(null);
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(users);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename=user.xls");
        ServletOutputStream out=response.getOutputStream();

        writer.flush(out, true);
// 关闭writer，释放内存
        writer.close();
//此处记得关闭输出Servlet流
        IoUtil.close(out);
    }
}
