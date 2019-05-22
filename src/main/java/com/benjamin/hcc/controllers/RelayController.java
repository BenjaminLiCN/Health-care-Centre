package com.benjamin.hcc.controllers;

import com.alibaba.fastjson.JSONObject;
import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import com.benjamin.hcc.service.RelayService;
import com.benjamin.hcc.service.UserService;
import com.benjamin.hcc.utils.WebResults;
import com.benjamin.hcc.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Auther Benjamin(Jingyi Li) Li
 * @Email jili@student.unimelb.edu.au
 * @ID 961543
 * @Date 2019-04-20 16:31
 */
@RestController
public class RelayController {
    @Autowired
    private RelayService service;
    @PostMapping("relay")
    public WebResults register(@RequestBody JSONObject message) {
        service.execute(message);
        return WebUtils.success();
    }
    @PostMapping("booking")
    public JSONObject postToPort(@RequestBody JSONObject message){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        JSONObject data = null;
        String type = null;
        String url = null;
        try {
            data = message.getJSONObject("data");
            type = message.getString("type");
            url = message.getString("url");
        } catch (Exception e) {
            System.out.println("Parsing JSON went wrong!");
        }

        HttpEntity<String> entity = new HttpEntity<>(data.toJSONString(), headers);

        HttpMethod method = null;
        switch (type.toUpperCase()){
            case "POST":
                method = HttpMethod.POST;
            break;
            case "GET":
                method = HttpMethod.GET;
            case "PUT":
                method = HttpMethod.PUT;
            break;
            case "DELETE":
                method = HttpMethod.DELETE;
            default:
                return null;

        }
        ResponseEntity<JSONObject> exchange = restTemplate.exchange(
                url,
                method,//可能需要switch() 然后post,get,delete,put分开
                entity,
                JSONObject.class);
        System.out.println(exchange.getBody().toString());
        return exchange.getBody();
    }


}
