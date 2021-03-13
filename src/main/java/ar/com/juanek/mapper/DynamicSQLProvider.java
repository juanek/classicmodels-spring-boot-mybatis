package ar.com.juanek.mapper;

import org.apache.ibatis.jdbc.SQL;


public class DynamicSQLProvider {


    public String selectMany(){
        return new SQL(){
            {
                SELECT("*");
                FROM("products");
                WHERE("productLine = 'Planes'");
            }
        }.toString();
    }


}
