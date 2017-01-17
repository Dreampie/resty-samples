package cn.dreampie.user.valid;

import cn.dreampie.common.util.matcher.PatternMatcher;
import cn.dreampie.route.core.Params;
import cn.dreampie.route.core.RouteMatch;
import cn.dreampie.route.valid.ValidResult;
import cn.dreampie.route.valid.Validator;
import cn.dreampie.user.model.User;

/**
 * Created by ice on 15-1-26.
 */
public class UserValid extends Validator {

    public ValidResult validate(Params params, RouteMatch routeMatch) {

        ValidResult result = new ValidResult();

        User user = params.get("user");

        String username = user.get("username");
        if (!PatternMatcher.isGeneral(username, 5, 16)) {
            result.addError("username", "用户名错误!");
        }
        String password = user.get("password");
        if (!PatternMatcher.isLength(password, 6, 18)) {
            result.addError("password", "密码错误!");
        }
        return result;
    }
}
