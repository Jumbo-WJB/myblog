package com.vine.blog.domain.util;

import java.lang.reflect.Method;

public class OperatorUtils {


    public static String getOperator(String operation){
        return OperateEnum.getOperator(operation);
    }

    public static  Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return "";
        }
    }

     enum OperateEnum{
        IS("is","="),
        IS_NOT("is_not"," != "),
        LESS_THAN("less_than", "<"),
        GREATER_THAN("greater_than",">");
        private String operation;
        private String operator;
        OperateEnum(String operation,String operator){
            this.operation = operation;
            this.operator = operator;
        }
        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public static String getOperator(String operation){
              return   OperateEnum.valuesOf(operation).getOperator();
        }

        public static OperateEnum valuesOf(String operation){
            for(OperateEnum operateEnum :OperateEnum.values()){
                if(operateEnum.getOperation().equals(operation)){
                    return operateEnum;
                }
            }
            return null;
        }

    }
}
