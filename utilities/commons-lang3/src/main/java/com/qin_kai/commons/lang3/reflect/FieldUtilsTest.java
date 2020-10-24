package com.qin_kai.commons.lang3.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * @author qin kai
 * @date 2020/10/19
 */
public class FieldUtilsTest {

    static class SuperObj {
        public String superField = "superField";
    }

    static class SubObj extends SuperObj {
        public String publicField = "public";
        private String subField = "subField";
        public static String staticField = "staticField";
    }

    public static void main(String[] args) throws IllegalAccessException {
        SubObj subObj = new SubObj();
        FieldUtils.writeField(subObj, "publicField", "publicField");
        Object publicField = FieldUtils.readField(subObj, "publicField");
        System.out.println(publicField);
        String subField = (String) FieldUtils.readDeclaredField(subObj, "subField", true);
        System.out.println(subField);
        Object staticField = FieldUtils.readStaticField(SubObj.class, "staticField");
        System.out.println(staticField);
        Object superField = FieldUtils.readField(subObj, "superField");
        // Declare 不包括父类继承的属性
//        Object superField = FieldUtils.readDeclareField(subObj, "superField");
        System.out.println(superField);
    }
}
