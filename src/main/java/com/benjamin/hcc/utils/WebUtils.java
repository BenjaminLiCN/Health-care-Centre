package com.benjamin.hcc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.benjamin.hcc.dto.UserContextDTO;
import com.benjamin.hcc.security.model.SimpleAuthority;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@SuppressWarnings("unchecked")
public class WebUtils {

    public static WebResults success(Object dat){
        return success(0,dat);
    }

    public static WebResults success(int code, Object dat){
        WebResults result = new WebResults();
        result.setCode(code);
        result.setMessage("OK");
        result.setData(dat);
        return result;
    }

    public static WebResults success(){
        return success(null);
    }

    public static WebResults error(int code, String msg){
        WebResults result = new WebResults();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static WebResults error(Exception ex){
        WebResults result = new WebResults();
        result.setCode(ex.hashCode());
        result.setMessage(ex.getMessage());
        return result;
    }

    public static String getString(WebResults webResults) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(webResults);
    }
    /**
     * token解析成UserContextDTO
     * @param token
     * @return
     */
    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (token != null) {
            try {
                Claims user = Jwts.parser()
                        .setSigningKey(SystemVars.JWT_SECRET)
                        .parseClaimsJws(token.replace(SystemVars.AUTHENTICATION_HEAD, ""))
                        .getBody();
                String userId = (String)user.get("sub");
                UserContextDTO userDto = new UserContextDTO();
                userDto.setUsername((String)user.get("username"));
                userDto.setId((String)user.get("id"));

                String authStr = (String)user.get("_auth");
                List<String> auths = Arrays.asList(StringUtils.commaDelimitedListToStringArray(authStr));
                List<SimpleAuthority> listPower = new ArrayList<SimpleAuthority>();

                for(String auth : auths){
                    SimpleAuthority sa = new SimpleAuthority();
                    String[] authObj = auth.split(";");
                    sa.setType(authObj[0]);
                    sa.setUrl(authObj[1]);
                    listPower.add(sa);
                }
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(userDto, null, listPower);
                }
            } catch (Exception ex) {
                return null;
            }
        }
        return null;
    }
}
