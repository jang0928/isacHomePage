package com.homeDemo.demo.util;

import java.lang.reflect.Array;
import java.util.*;

import static org.springframework.util.ObjectUtils.isEmpty;

public class CommUtil {
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj)
    {
        if( obj instanceof String ) return obj==null || "".equals(obj.toString().trim());
        else if( obj instanceof List) return obj==null || ((List<?>)obj).isEmpty();
        else if( obj instanceof Map ) return obj==null || ((Map)obj).isEmpty();
        else if( obj instanceof Object[] ) return obj==null || Array.getLength(obj)==0;
        else return obj==null;
    }

    public static boolean isNotEmpty(Object obj)
    {
        return !isEmpty(obj);
    }

    public static boolean isEquals(Object sobj, Object tobj)
    {
        if(CommUtil.isNotEmpty(sobj))
        {
            return sobj.equals(tobj);
        }
        return false;
    }
    public static boolean isNotEquals(Object sobj, Object tobj)
    {
        return !isEquals(sobj,tobj);
    }

    public static String subString(String str, int start, int end)
    {
        return str.substring(start, end);
    }

}
