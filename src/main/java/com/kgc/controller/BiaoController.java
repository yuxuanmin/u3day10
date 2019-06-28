package com.kgc.controller;

import com.kgc.entity.Biao;
import com.kgc.service.BiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class BiaoController {
    @Autowired
    private BiaoService biaoService;

    @RequestMapping("/find")
    public String selectByExample(@RequestParam(value = "page",required = false,defaultValue = "1") int page, ModelMap map){
         map.put("pageInfo", biaoService.selectByExample(page,3));
        return "list";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteAjax(@PathVariable("id") int id){
        System.out.println("delete::"+id);
    //    int i = biaoService.deleteAjax(id);

        return "1";

    }
}
