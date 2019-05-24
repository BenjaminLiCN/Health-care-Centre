package com.benjamin.hcc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.benjamin.hcc.dao.UserDAO;
import com.benjamin.hcc.domain.UserDO;
import com.benjamin.hcc.dto.UserContextDTO;
import com.benjamin.hcc.dto.UserDTO;
import com.benjamin.hcc.dto.UserRegisterReqDTO;
import com.benjamin.hcc.exceptions.hccException;
import com.benjamin.hcc.service.UserService;
import com.benjamin.hcc.utils.WebUtils;
import com.benjamin.hcc.mapper.UserRegisterReqMapper;
import com.benjamin.hcc.utils.SystemVars;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther Benjamin Li li.benjamincn@gmail.com
 * @id 961543
 * @date 2018/9/30下午7:19
 */
@org.springframework.stereotype.Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;
    @Autowired
    private UserRegisterReqMapper userRegisterReqMapper;
    //账号只能是字母开头，允许6-20字节，允许字母数字下划线
    String usernamePattern = "^[a-zA-Z][a-zA-Z0-9_]{4,19}$";
    //密码只能是0~9, a~z, A~Z和下划线，长度为6~20
    String passwordPattern = "[A-Za-z0-9_]{6,20}";
    //标准邮箱格式
    String emailPattern = "(\\w|-)+(\\.(\\w|-)+)*@(\\w|-)+(\\.(\\w|-)+)*(\\.[a-z]{2,4})";
    @Override
    public String getTokenByLogin(UserDTO userDTO) {
        String token = null;
        UserDO userDO = userDao.findOne((root, criteriaQuery, criteriaBuilder) -> {
            Path<String> uidPath = root.get("username");
            Path<String> pwdPath = root.get("password");
            return criteriaBuilder.and(
                    criteriaBuilder.equal(uidPath, userDTO.getUsername()),
                    criteriaBuilder.equal(pwdPath, userDTO.getPassword())
            );
        });
        if (userDO == null) {
            throw new hccException("Incorrect username or password!");
        } else {
            Map<String, Object> claims = new HashMap<>();
            UserContextDTO userContextDTO  = getUserContextById(userDO.getId());
            claims.put("id", userContextDTO.getId());
            claims.put("name", userContextDTO.getName());
            claims.put("username", userContextDTO.getUsername());
            claims.put("email", userContextDTO.getEmail());
            claims.put("gender", userContextDTO.getGender());
            claims.put("number", userContextDTO.getNumber());
            token = Jwts.builder()
                    .setSubject(userDO.getId().toString())
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                    .signWith(SignatureAlgorithm.HS512, SystemVars.JWT_SECRET)
                    .compact();
        }
        return token;
    }

    @Override
    public List<UserContextDTO> getAllUsers(){
        return null;
    }

    @Override public void updateUserInfo(UserRegisterReqDTO userRegisterReqDTO){
        UserDO userDO = userRegisterReqMapper.to(userRegisterReqDTO);
        userDao.save(userDO);
    }
    public JSONObject getUserByLogin(UserDTO userDTO){
        UserDO userDO = userDao.findOne((root, criteriaQuery, criteriaBuilder) -> {
            Path<String> uidPath = root.get("email");
            Path<String> pwdPath = root.get("password");
            return criteriaBuilder.and(
                    criteriaBuilder.equal(uidPath, userDTO.getEmail()),
                    criteriaBuilder.equal(pwdPath, userDTO.getPassword())
            );
        });
        if (userDO == null) {
            throw new hccException("Incorrect username or password!");
        } else {

            UserContextDTO userContextDTO  = getUserContextById(userDO.getId());
            long id = userContextDTO.getId();
            int isAdmin = userContextDTO.getIsAdmin();
            String name = userContextDTO.getUsername();
            JSONObject response = new JSONObject();
            response.put("id",id);
            response.put("admin",isAdmin);
            response.put("name",name);
            return response;
        }

    }

    public void generateAdmin(){
        UserRegisterReqDTO userRegisterReqDTO = new UserRegisterReqDTO();
        userRegisterReqDTO.setEmail("admin@hcc.com.au");
        userRegisterReqDTO.setGender("0");
        userRegisterReqDTO.setUsername("Elena");
        userRegisterReqDTO.setHomeAddress("6 Wedgewood Rd., Hallam, Victoria.");
        userRegisterReqDTO.setPassword("123456");
        userRegisterReqDTO.setNumber("0452662817");
        userRegisterReqDTO.setIsAdmin(1);
        UserDO userDO = userRegisterReqMapper.to(userRegisterReqDTO);
        userDao.save(userDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(UserRegisterReqDTO userRegisterReqDTO) {
        if (userRegisterReqDTO.getUsername().equals("") ||userRegisterReqDTO.getEmail().equals("")|| userRegisterReqDTO.getPassword().equals("")) {
            throw new hccException("Register information cannot be null!");
        } else if (!userRegisterReqDTO.getUsername().matches(usernamePattern)){
            if (userRegisterReqDTO.getUsername().length()<5 || userRegisterReqDTO.getUsername().length()>20){
                throw new hccException("Username must be 5 to 20 characters!");
            }
        } else if (!userRegisterReqDTO.getPassword().matches(passwordPattern)) {
            if (userRegisterReqDTO.getPassword().length()<6 || userRegisterReqDTO.getPassword().length()>20){
                throw new hccException("Password must be 6 to 20 characters!");
            }else {
                throw new hccException("Password can only contain letters, numbers and underscores!");
            }
        } else if (!userRegisterReqDTO.getEmail().matches(emailPattern)){
            throw new hccException("Incorrect email!");
        } else {
            //查找账号是否存在
            long count = userDao.count((root, query, cb) -> {
                Path<String> emailPath = root.get("email");
                return cb.equal(emailPath, userRegisterReqDTO.getEmail());
            });
            if (count>0){
                throw new hccException("The email already exists!");
            } else {
                UserDO userDO = userRegisterReqMapper.to(userRegisterReqDTO);
                userDao.save(userDO);
            }
        }
    }
    @Override
    public String refreshToken() {
        String newToken = null;
        WebUtils webUtils = new WebUtils();
        UserContextDTO userContextDTO = (UserContextDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDO userDO = userDao.findOne(userContextDTO.getId());

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userDO.getId());
        claims.put("name", userDO.getName());
        claims.put("username", userDO.getUsername());
        claims.put("email", userDO.getEmail());
        claims.put("gender", userDO.getGender());
        claims.put("number", userDO.getNumber());
        newToken = Jwts.builder()
                .setSubject(userDO.getId().toString())
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(SignatureAlgorithm.HS512, SystemVars.JWT_SECRET)
                .compact();
        //存到session里
        UsernamePasswordAuthenticationToken authenticationToken = webUtils.getAuthentication (newToken);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        return newToken;
    }

    @Override
    public UserContextDTO getUserContextById(long id) {
        UserDO userDO = userDao.findOne(id);
        UserContextDTO userContextDTO = new UserContextDTO();
        userContextDTO.setId(userDO.getId());
        userContextDTO.setName(userDO.getName());
        userContextDTO.setUsername(userDO.getUsername());
        userContextDTO.setEmail(userDO.getEmail());
        userContextDTO.setGender(userDO.getGender());
        userContextDTO.setNumber(userDO.getNumber());
        userContextDTO.setIsAdmin(userDO.getIsAdmin());
        return userContextDTO;
    }

    @Override
    public UserContextDTO getMyUserContext() {
        UserContextDTO user = getUserContext();
        return getUserContextById(user.getId());
    }

}