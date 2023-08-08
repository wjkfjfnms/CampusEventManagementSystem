package com.six.campuseventmanagementsystem.service;

import com.six.campuseventmanagementsystem.entity.User;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.joda.time.DateTime;

import java.sql.Date;

public interface VisitorService {
    /**
     * 根据User的 实名验证数据 发送主办方or赞助商的申请
     * @return 返回更改记录数
     */
    Integer Submit(String token, String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType);
//    String RealName(String UserName, String Sex, String Nation, String birthday, String DocumentType, String DocumentNumber, String Unit, String Number, String Origin, String MAddress, String UserType);


    /**
     * 根据Visitor的ID删除 游客
     * @return 返回更改条数
     */
    Integer DeleteById(Integer ID);


}

