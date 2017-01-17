package cn.dreampie.config;

import cn.dreampie.orm.ActiveRecordPlugin;
import cn.dreampie.orm.provider.druid.DruidDataSourceProvider;
import cn.dreampie.route.cache.CacheInterceptor;
import cn.dreampie.route.config.*;
import cn.dreampie.route.handler.cors.CORSHandler;
import cn.dreampie.route.interceptor.transaction.TransactionInterceptor;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by ice on 14-12-29.
 */
public class AppConfig extends Config {

    public void configConstant(ConstantLoader constantLoader) {
        //通过后缀来返回不同的数据类型  你可以自定义自己的  render  如：FreemarkerRender
        //constantLoader.addRender("json", new JsonRender());
        constantLoader.addJsonSerializerFeature(SerializerFeature.WriteNullStringAsEmpty);
    }

    public void configResource(ResourceLoader resourceLoader) {
        //设置resource的目录  减少启动扫描目录
        resourceLoader.addIncludePackages("cn.dreampie.user.resource");
    }

    public void configPlugin(PluginLoader pluginLoader) {
//    //第一个数据库
        DruidDataSourceProvider ddsp = new DruidDataSourceProvider("default");
        ActiveRecordPlugin activeRecordDdsp = new ActiveRecordPlugin(ddsp);
        activeRecordDdsp.addIncludePackages("cn.dreampie.user.model");
        pluginLoader.add(activeRecordDdsp);
    }

    public void configInterceptor(InterceptorLoader interceptorLoader) {
        //缓存
        interceptorLoader.add(new CacheInterceptor());
        //事务的拦截器 @Transaction
        interceptorLoader.add(new TransactionInterceptor());
    }

    public void configHandler(HandlerLoader handlerLoader) {
        //跨域
        handlerLoader.add(new CORSHandler("GET,POST,PUT,DELETE"));
    }
}
