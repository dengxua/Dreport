package com.dsql.entity;

import java.util.Map;

/**
 * @author deh
 * @date 2019-11-26
 */
public class ReportEntity {
    /**
     * 报表名称
     */
    private  String  rName;
    /**
     * 报表sql
     */
    private  String  rSql;
    /**
     * 报表列
     */
    private String rClunm;

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrSql() {
        return rSql;
    }

    public void setrSql(String rSql) {
        this.rSql = rSql;
    }

    public String getrClunm() {
        return rClunm;
    }

    public void setrClunm(String rClunm) {
        this.rClunm = rClunm;
    }
}
