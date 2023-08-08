package com.six.campuseventmanagementsystem.verify;

public class StrVetting {
    /**
     * 审核类型判断
     * 1、实名验证类（RealName）
     * （1）zzs 赞助商实名验证申请
     * （2）zbf 主办方实名验证申请
     * <p>
     * 2、角色替换（Change）
     * （1）admin 成为管理员的申请
     * <p>
     * 3、赛事类（Match）
     * （1）submit 提交
     */
    public String Type(String Type, String action) {
        if (Type.equals("RealName")) {
            switch (action) {
                case "zzs":
                    return "的实名验证申请";
                case "zbf":
                    return "的实名验证申请";
            }
        } else if (Type.equals("Change")) {
            switch (action) {
                case "admin":
                    return "的管理员申请";
            }
        } else if (Type.equals("Match")) {
            switch (action) {
                case "submit":
                    return "的赛事申请";
            }
        }
        return "失败";
    }


    /**
     *审核内容判断
     *
     *1、实名验证类（RealName）
     * （1）zzs 成为赞助商的申请
     * （2）zbf 成为主办方的申请
     *
     * 2、角色替换（Change）
     * （1）admin 成为管理员的申请
     *
     * 3、赛事类（Match）
     * （1）submit 提交
     */

    public String Message(String Type, String action){
        if (Type.equals("RealName")) {
            switch (action) {
                case "zzs":
                    return "申请成为赞助商";
                case "zbf":
                    return "申请成为主办方";
            }

        } else if (Type.equals("Change")) {
            switch (action) {
                case "admin":
                    return "申请成为管理员";
            }
        } else if (Type.equals("Match")) {
            switch (action) {
                case "submit":
                    return "的赛事申请";
            }
        }
        return "失败";
    }
}


