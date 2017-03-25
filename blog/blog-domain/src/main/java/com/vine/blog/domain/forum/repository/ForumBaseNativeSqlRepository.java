package com.vine.blog.domain.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumBaseNativeSqlRepository {

    @Autowired
    private JdbcTemplate template;

//    @PersistenceUnit
//    @Qualifier("primaryDataSource")
//    private EntityManagerFactory emf;
//
//    /**
//     * 不推荐emf方式,好多坑
//     * 查询多个属性
//     * 返回List<Object[]>数组形式的List，数组中内容按照查询字段先后
//     * @param sql   原生SQL语句
//     * @return
//     */
//    public List<Object[]> sqlArrayList(String sql){
//        EntityManager em=emf.createEntityManager();
//        Query query=em.createNativeQuery(sql);
//        List<Object[]> list = query.getResultList();
//        em.close();
//        return  list;
//    }
//
//    /**
//     * 查询多个属性
//     * 返回List<Object>对象形式的List，Object为Class格式对象
//     * @param sql   原生SQL语句
//     * @param obj   Class格式对象
//     * @return
//     */
//    public List sqlObjectList(String sql, Class cls){
//        EntityManager em=emf.createEntityManager();
//        Query query=em.createNativeQuery(sql, cls.getClass());
//        List list = query.getResultList();
//        em.close();
//        return  list;
//    }
//
//    /**
//     * 查询单个属性
//     * 返回List<Object>对象形式的List，Object为对象数据类型
//     * @param sql  原生SQL语句
//     * @return
//     */
//    public List sqlSingleList(String sql){
//        EntityManager em=emf.createEntityManager();
//        Query query=em.createNativeQuery(sql);
//        List list = query.getResultList();
//        em.close();
//        return  list;
//    }

    public List queryListByJdbcTemplate(String sql,Class cls){
        return template.query(sql,new BeanPropertyRowMapper(cls));
    }


}
