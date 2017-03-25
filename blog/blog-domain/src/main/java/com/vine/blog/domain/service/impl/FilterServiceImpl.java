package com.vine.blog.domain.service.impl;

import com.vine.blog.domain.entity.condition.Condition;
import com.vine.blog.domain.entity.filter.Filter;
import com.vine.blog.domain.entity.ticket.Field;
import com.vine.blog.domain.entity.ticket.Ticket;
import com.vine.blog.domain.repository.BaseNativeSqlRepository;
import com.vine.blog.domain.service.FilterService;
import com.vine.blog.domain.repository.TicketRepository;
import com.vine.blog.domain.util.OperatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private BaseNativeSqlRepository baseNativeSqlRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public Page<Ticket> getFilterTickets(Filter filter,Pageable pageable) {
        if (filter == null) {
            return ticketRepository.findAll(pageable);
        }
        StringBuffer sqlBuffer = new StringBuffer("select * ");
        sqlBuffer.append(getFilterTicketsSql(filter));
        sqlBuffer.append(" limit ");
        sqlBuffer.append(pageable.getPageNumber()*pageable.getPageSize());
        sqlBuffer.append(",");
        sqlBuffer.append(pageable.getPageSize());
      //  List<Ticket> tickets = baseNativeSqlRepository.sqlObjectList(sql.toString(), Ticket.class);
        List<Ticket> tickets = (List<Ticket>)baseNativeSqlRepository.queryListByJdbcTemplate(sqlBuffer.toString(), Ticket.class);

        List<Long> ticketIds = new ArrayList<>(tickets.size());
        for(Ticket ticket : tickets){
            ticketIds.add(ticket.getId());
        }
        Page<Ticket> ticketList = ticketRepository.findByIdIn(ticketIds,pageable);
        return ticketList;
    }

    private StringBuffer getFilterTicketsSql(Filter filter) {
        List<Condition> all = filter.getAll();
        List<Condition> any = filter.getAny();
        StringBuffer sql = new StringBuffer();
        sql.append(" from tickets where 1=1 ");
        for (Condition condition : all) {
            sql.append(" and " + condition.getSource() + " " + OperatorUtils.getOperator(condition.getOperator()) + " '" + condition.getValue() + "'");
        }
        if (any.size() > 0) {
            sql.append(" and (");
            for (Condition condition : any) {
                sql.append(condition.getSource() + " " + OperatorUtils.getOperator(condition.getOperator()) + " '" + condition.getValue() + "'");
                sql.append(" or ");
            }
            sql.delete(sql.length() - 4, sql.length() - 1);
            sql.append(" )");
        }
        // sql.append( " group by "+filter.getGroupField());
        sql.append(" order by updated_at desc ");
        return sql;
    }

    @Override
    public List<Field> findFields(List<Ticket> tickets,List<String> showFields) {
        List<Field> fieldList = new ArrayList<>();
        Field field  =null;
        List<Object> values = null;
        for(Ticket ticket : tickets){
            field = new Field();
            values = new ArrayList<>();
            for(String showField : showFields){
                values.add(OperatorUtils.getFieldValueByName(showField,ticket));
            }
            field.setValue(values);
            fieldList.add(field);
        }
        return fieldList;
//
//
//
//
//        List<DiyFields> diyFieldsArrayList = new ArrayList<>(tickets.size());
//        List<DiyField> diyFieldArrayList =null;
//        DiyField diyField = null;
//        DiyFields diyFields =null;
//        if(filter !=  null && !CollectionUtils.isEmpty(filter.getShowField())) {
//            for (Ticket ticket : tickets) {
//                diyFields = new DiyFields();
//                diyFieldArrayList = new ArrayList<>();
//                for (String field : filter.getShowField()) {
//                    diyField = new DiyField();
//                    diyField.setName(field);
//                    diyField.setValue(OperatorUtils.getFieldValueByName(field, ticket));
//                    diyFieldArrayList.add(diyField);
//                }
//                diyFields.setDiyField(diyFieldArrayList);
//                diyFieldsArrayList.add(diyFields);
//            }
//        }else{
//            for (Ticket ticket : tickets) {
//                diyFields = new DiyFields();
//                diyFieldArrayList = new ArrayList<>();
//                //默认给标题 状态 发起人 受理客服组 受理人 创建时间
//                String []fields = new String[]{"id","status","requester_id","group_id","created_at"};
//                for (String field : fields) {
//                    diyField = new DiyField();
//                    diyField.setName(field);
//                    diyField.setValue(OperatorUtils.getFieldValueByName(field, ticket).toString());
//                    diyFieldArrayList.add(diyField);
//                }
//                diyFields.setDiyField(diyFieldArrayList);
//                diyFieldsArrayList.add(diyFields);
//            }
//        }
//        return diyFieldsArrayList;
    }




}
