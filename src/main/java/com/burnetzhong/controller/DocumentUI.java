package com.burnetzhong.controller;

import com.burnetzhong.domain.Swagger;
import com.burnetzhong.repo.SwaggerDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Project: zhcore
 *
 * @Comments
 * @Author Zhong Han
 * @Created Date 2017/4/6
 */

@RestController
@RequestMapping(path = "/api")
public class DocumentUI {

    @Autowired
    private SwaggerDocRepo swaggerDocRepo;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Swagger> getSwaggers(){
        List<Swagger> swaggers = (List<Swagger>) swaggerDocRepo.findAll();
        return swaggers;
    }

    @RequestMapping(path = "/{basePath}", method = RequestMethod.GET)
    public Swagger getByBasePath(@PathVariable  String basePath){
        if(!basePath.startsWith("/")){
            basePath = "/" + basePath;
        }
        Swagger swagger = swaggerDocRepo.findByBasePath(basePath);
        return swagger;
    }

}
