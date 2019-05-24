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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
    @RequestMapping(value = "/booking", method = RequestMethod.POST, produces = "application/json")
    public String postTo(JSONObject message) {

        JSONObject dataJSON = null;
        String type = null;
        String urlString = null;
        try {
            dataJSON = message.getJSONObject("data");
            type = message.getString("type");
            urlString = message.getString("url");


            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置允许输出

            conn.setDoInput(true);

            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod(type);
            // 设置维持长连接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置文件字符集:
            //转换为字节数组

            System.out.println(dataJSON.toString());
            String urlParameters = "";

            for (String key : dataJSON.keySet()) {
                urlParameters+= key+"="+dataJSON.getString(key)+"&";
            }
            //发送Post请求
            conn.setDoOutput(true);
            conn.connect();
            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //打印结果
            System.out.println(response.toString());
            if (response == null) return "";
            return response.toString();
        } catch (Exception e) {
            System.out.println("Parsing JSON went wrong!");
        }
        return "";
    }


}
