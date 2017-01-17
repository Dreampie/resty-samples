package cn.dreampie.user.resource;

import cn.dreampie.orm.transaction.Transaction;
import cn.dreampie.route.annotation.*;
import cn.dreampie.route.core.Resource;
import cn.dreampie.user.model.User;
import cn.dreampie.user.valid.UserValid;

import java.util.Date;
import java.util.List;

/**
 * Created by ice on 14-12-29.
 */
@API("/users")
public class UserResource extends Resource {

    //查询集合
    @GET
    public List<User> findAll() {
        return User.dao.findColsAll("username,created_at");
    }

    //查询单个user对象 curl -X GET localhost:9090/users/1
    @GET("/:id")
    public User findById(String id) {
        return User.dao.findById(id);
    }

    //更新 curl -X PUT localhost:9090/users/1 -d '{"user":"{%json%}"}' -H "Content-Type: application/json"
    //%json% 换成你的user的json数据
    @PUT(value = "/:id", valid = {UserValid.class})
    @Transaction
    public User updateById(String id, User user) {
        user.set("id", id);
        user.update();
        return user;
    }

    //保存 curl -X POST localhost:9090/users -d '{"user":"{%json%}"}' -H "Content-Type: application/json"
    //%json% 换成你的user的json数据
    @POST(valid = {UserValid.class})
    @Transaction
    public User save(User user) {
        user.set("created_at", new Date());
        user.save();
        return user;
    }

    //删除 curl -X PUT localhost:9090/users/1 -H "Content-Type: application/json"
    @DELETE("/:id")
    @Transaction
    public boolean deleteById(String id) {
        return User.dao.deleteById(id);
    }
}
