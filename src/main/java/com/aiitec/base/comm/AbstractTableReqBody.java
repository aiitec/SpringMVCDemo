package com.aiitec.base.comm;

import com.aiitec.demo.model.comm.UserRespBody;

public abstract class AbstractTableReqBody<WHERE> {
    public int action=1;
    public Table<WHERE> table;
    public AbstractTableReqBody(Table<WHERE> where){
        this.table=where;
    }
}
