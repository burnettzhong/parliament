package com.burnetzhong.controller;

import com.burnetzhong.domain.Swagger;
import com.burnetzhong.repo.SwaggerDocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: zhcore
 *
 * @Comments
 * @Author Zhong Han
 * @Created Date 2017/4/5
 */
@RestController
@RequestMapping(path = "/swagger")
public class SwaggerPublish {

    @Autowired
    private SwaggerDocRepo swaggerDocRepo;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World!";
    }

    @RequestMapping(path = "/publish", method = RequestMethod.POST, consumes = "application/json;charset=utf-8" )
    public void publish(@RequestBody Swagger swagger){
        Swagger original = swaggerDocRepo.findByBasePath(swagger.getBasePath());

        // MongoDB docs cannot contain "$" when update, so we must delete old one and save the new one.
        swaggerDocRepo.delete(original.getId());

        swaggerDocRepo.save(swagger);
    }
}
