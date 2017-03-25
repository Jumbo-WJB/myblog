package com.vine.blog.domain.util;


import com.vine.blog.domain.entity.condition.Condition;
import com.vine.blog.domain.entity.ticket.Ticket;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class FilterUtils {

    private List<Ticket> tickets;

    public FilterUtils(List<Ticket> tickets){
        this.tickets = tickets;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public FilterUtils filterAll(List<Condition> all){
        if(tickets.size() == 0){
            return this;
        }
        for (Iterator<Ticket> iterator = tickets.iterator();iterator.hasNext();) {
            Boolean removeTag = true;
            Ticket ticket = iterator.next();
            Field[] fields = ticket.getClass().getDeclaredFields();
            for (Field field : fields) {
                for (Condition condition : all) {
                    if (field.getName().equals(condition.getSource())) {
                        if(!compare(getFieldValueByName(field.getName(),ticket),OperateEnum.valuesOf(condition.getOperator()),condition.getValue())){
                            removeTag =false;
                            break;
                        }
                    }
                }
            }
            if(!removeTag){
                iterator.remove();
                if(tickets.size() == 0){
                    return this;
                }
            }
        }
        return this;
    }

    private Boolean compare(Object o, OperateEnum operateEnum, String value) {
        switch (operateEnum){
            case IS:
                return o.equals(value)||value.compareTo(o.toString()) == 0;
            case IS_NOT:
                return !o.equals(value);
            case GREATER_THAN:
                return value.compareTo(o.toString()) > 0;
            case LESS_THAN:
                return value.compareTo(o.toString()) < 0;
            default:
                return false;
        }
    }

    public FilterUtils filterAny(List<Condition> any){
        return this;
    }

    public FilterUtils group(String field,int sort){
        return this;
    }

    public FilterUtils sort(String field,int sort){
        return this;
    }

    enum OperateEnum{
        IS("is"),
        IS_NOT("is_not"),
        LESS_THAN("less_than"),
        GREATER_THAN("greater_than");
        private String operation;
        OperateEnum(String operation){
            this.operation = operation;
        }
        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
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

}
