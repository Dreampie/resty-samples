package cn.dreampie.user.model;

import cn.dreampie.orm.Model;
import cn.dreampie.orm.annotation.Table;

/**
 * Created by ice on 14-12-31.
 */
@Table(name = "user")
public class User extends Model<User> {
    public static User dao = new User();
}
