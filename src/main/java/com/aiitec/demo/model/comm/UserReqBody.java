package com.aiitec.demo.model.comm;

import com.aiitec.base.comm.AbstractTableReqBody;
import com.aiitec.base.comm.Table;

public class UserReqBody extends AbstractTableReqBody<UserReqBody.UserWhere> {

    public UserReqBody() {
        super(new Table(new UserReqBody.UserWhere()));
    }
    public static class UserWhere {
        public String sk;

    }
}
