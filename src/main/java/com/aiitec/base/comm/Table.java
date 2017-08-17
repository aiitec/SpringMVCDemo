package com.aiitec.base.comm;

/**
 * Where条件
 * @param <WHERE>
 */
public class Table<WHERE>{
    public int pa =1;
    public int li=20;
    public int ob= 0;
    public int ot=0;
    public WHERE where;

    public Table(WHERE where){
        this.where = where;
    }
}
