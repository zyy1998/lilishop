package cn.lili.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户名验证工具类
 * 项目里没有用到，项目中都是通过注解实现的校验
 * @see cn.lili.common.validation.Phone
 *
 * @author Chopper
 */
public class RegularUtil {


    /**
     * 手机号
     */
    private static final Pattern MOBILE = Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$");

    /**
     * 邮箱
     */
    private static final Pattern EMAIL = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$");

    public static boolean mobile(String v){

        Matcher m = MOBILE.matcher(v);
        if(m.matches()){
            return true;
        }
        return false;
    }

    public static boolean email(String v){

        Matcher m = EMAIL.matcher(v);
        if(m.matches()){
            return true;
        }
        return false;
    }
}
