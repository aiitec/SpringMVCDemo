package com.aiitec.base.comm;

public abstract class AbstractRespBody {
    /**
     * 状态码
     */
    public int s=1000;
    /**
     * 状态描述，用于记录日志和提示给客户端
     */
    public String desc="";
    /**
     * 系统时间
     */
    public long t = System.currentTimeMillis();

}
