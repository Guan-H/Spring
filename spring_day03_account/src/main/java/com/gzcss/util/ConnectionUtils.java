package com.gzcss.util;


import javax.sql.DataSource;
import java.sql.Connection;

/*
*  连接的工具类，他用于从数据源中获取一个连接，并且实现与线程的绑定
* */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;



    /*
    *   datasource的set方法让spring自动注入
    * */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){

        try {
            //1、先从Thread上获取
            Connection conn = tl.get();
            //2、判断当前线程上是否有连接
            if(conn == null){
                System.out.println("空连接。。。");
                //3、从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }

            //4、返回当前线程上的连接
            return conn;
        }catch (Exception e){
            System.out.println("获取异常");
            throw  new RuntimeException(e);
        }

    }

    /*
    *  释放connection和线程的绑定
    * */
    public void removeConnection(){
        tl.remove();
    }

}
