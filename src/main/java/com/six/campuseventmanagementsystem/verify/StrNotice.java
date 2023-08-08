package com.six.campuseventmanagementsystem.verify;

public class StrNotice {
    /**
    *通知类型判断
     *1、实名验证类（RealName）
     * （1）submit 提交
     * （2）zzs or zbf 成功
     * （3）fail 失败
     *
     * 2、角色替换（Change）
     * （1）admin 管理员
     * （2）zzs 赞助商
     * （3）zbf 主办方
     *
     * 3、赛事类（Match）
     * （1）submit 提交
     * （2）success 审核通过
     * （3）fail 审核不通过
     *
     *4、更新类(Update)
     * （1）admin 管理员更新个人信息
     */
    public String Type(String Type, String action){
        if(Type.equals("RealName")){
            switch (action){
                case "submit":
                    return "发起实名验证";
                case "zzs":
                    return "实名验证成功";
                case "zbf":
                    return "实名验证成功";
                case "fail":
                    return "实名验证失败";
            }

        }
        else if(Type.equals("Change")){
            switch (action){
                case "admin":
                    return "管理员角色替换";
                case "zzs":
                    return "赞助商角色替换";
                case "zbf":
                    return "主办方角色替换";
            }
        }
        else if(Type.equals("Match")){
            switch (action){
                case "submit":
                    return "发起赛事申请";
                case "success":
                    return "赛事申请成功";
                case "fail":
                    return "赛事申请失败";
            }
        }
        else if(Type.equals("Update")) {
            switch (action) {
                case "admin":
                    return "个人信息更新";
            }
        }
        return "消息创建失败";
    }



    /**
     *通知内容判断
     *1、实名验证类（RealName）
     * （1）submit 提交
     * （2）zzs 成为赞助商
     * （3）zbf 成为主办方
     * （4）fail 失败
     *
     * 2、角色替换（Change）
     * （1）admin 成为管理员
     * （2）zzs 赞助商
     * （3）zbf 主办方
     *
     * 3、赛事类（Match）
     * （1）submit 提交
     * （2）success 审核通过
     * （3）fail 审核不通过
     */

    public String Message(String Type, String action){
        if(Type.equals("RealName")){
            switch (action){
                case "submit":
                    return "审核提交成功！";
                case "zzs":
                    return "您现在的身份是赞助商！";
                case "zbf":
                    return "您现在的身份是主办方！";
                case "fail":
                    return "审核不通过，实名验证失败。";
            }

        }
        else if(Type.equals("Change")){
            switch (action){
                case "admin":
                    return "您已被设定为管理员。";
                case "zzs":
                    return "您已被设定为赞助商。";
                case "zbf":
                    return "您已被设定为主办方。";
            }
        }
        else if(Type.equals("Match")){
            switch (action){
                case "submit":
                    return "的审核提交成功！";
                case "success":
                    return "的赛事已经通过审核！";
                case "fail":
                    return "的的赛事审核未通过批准。";
            }
        }
        else if(Type.equals("Update")) {
            switch (action) {
                case "admin":
                    return "管理员更新了您的个人信息。";
            }
        }
        return "消息创建失败";
    }

}
