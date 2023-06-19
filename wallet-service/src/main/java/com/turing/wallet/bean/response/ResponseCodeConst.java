package com.turing.wallet.bean.response;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * 返回状态码常量
 *
 * @author wangleichao
 * @since 2018-08-14
 */
@Slf4j
public class ResponseCodeConst {

    // 范围声明
    static {
        // 系统功能，从0开始，step=1000
        ResponseCodeContainer.register(ResponseCodeConst.class, 0, 1000);
    }

    /**
     * 返回成功状态码 1;
     */
    public static final int SUCC_CODE = 1;
    /**
     * 正常成功返回
     */
    public static ResponseCodeConst SUCC = new ResponseCodeConst(SUCC_CODE, "success", true);
    public static ResponseCodeConst LOGIN = new ResponseCodeConst(100, "请先登录！");
    public static ResponseCodeConst ERROR_PARAM = new ResponseCodeConst(101, "参数异常！");
    public static ResponseCodeConst NOT_EXIST = new ResponseCodeConst(102, "数据不存在");
    public static ResponseCodeConst ADD_FAILED = new ResponseCodeConst(103, "添加失败");
    public static ResponseCodeConst UPDATE_FAILED = new ResponseCodeConst(104, "修改失败");
    public static ResponseCodeConst DELETE_FAILED = new ResponseCodeConst(105, "删除失败");
    public static ResponseCodeConst SYS_ERROR = new ResponseCodeConst(106, "系统错误");
    public static ResponseCodeConst AlREADY_EXIT = new ResponseCodeConst(107, "数据已存在");
    public static ResponseCodeConst AlREADY_EXIT_LOGIN_NAME = new ResponseCodeConst(108, "用户名重复");
    public static ResponseCodeConst IMPORT_FAIL = new ResponseCodeConst(109, "导入失败!!!");
    public static ResponseCodeConst NO_ROLE = new ResponseCodeConst(110, "无角色！");
    public static ResponseCodeConst LOFING_FAIL_ACCOUNT = new ResponseCodeConst(111, "登录账号或密码错误");
    public static ResponseCodeConst NO_PSERMISSION = new ResponseCodeConst(112, "无权限");
    public static final ResponseCodeConst SMS_CODE_ERROR = new ResponseCodeConst(113, "短信验证码错误");
    public static final ResponseCodeConst SMS_CODE_EXPIRED = new ResponseCodeConst(114, "短信验证码已过期");
    public static final ResponseCodeConst NEED_IMG_VALIDATE_CODE = new ResponseCodeConst(115, "需要图片验证码");
    public static final ResponseCodeConst SMS_CODE_MAXIMUM = new ResponseCodeConst(116, "获取短信验证码过于频繁，请稍后重试");
    public static final ResponseCodeConst IMG_VALIDATE_CODE_ERROR = new ResponseCodeConst(117, "图片验证码错误");
    public static final ResponseCodeConst PHONE_ERROR = new ResponseCodeConst(118, "手机号错误");
    public static final ResponseCodeConst IMG_VALIDATE_CODE_EXPIRED = new ResponseCodeConst(119, "验证码已过期，请刷新后重新输入");
    public static final ResponseCodeConst GET_SMS_CODE_FAIL = new ResponseCodeConst(120, "获取短信验证码失败,请稍后再试");
    public static ResponseCodeConst REQUEST_METHOD_ERROR = new ResponseCodeConst(121, "请求方式错误");
    public static ResponseCodeConst JSON_FORMAT_ERROR = new ResponseCodeConst(122, "JSON格式错误");
    /**
     * 状态码
     */
    protected int code;
    /**
     * 错误信息
     */
    protected String msg;

    /**
     * 是否成功
     */
    protected boolean success;

    public ResponseCodeConst() {
    }

    public ResponseCodeConst(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
        ResponseCodeContainer.put(this);
    }

    public ResponseCodeConst(int code) {
        super();
        this.code = code;
        ResponseCodeContainer.put(this);
    }

    public ResponseCodeConst(int code, String msg, boolean success) {
        super();
        this.code = code;
        this.msg = msg;
        this.success = success;
        ResponseCodeContainer.put(this);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    // =======================分割=======================

    /**
     * 内部类，用于检测code范围
     *
     * @author Anders
     */
    private static class ResponseCodeContainer {

        private static final Map<Integer, ResponseCodeConst> RESPONSE_CODE_MAP = new HashMap<>();

        private static final Map<Class<? extends ResponseCodeConst>, int[]> RESPONSE_CODE_RANGE_MAP = new HashMap<>();

        /**
         * id的范围：[start, end]左闭右闭
         */
        private static void register(Class<? extends ResponseCodeConst> clazz, int start, int end) {
            if (start > end) {
                throw new IllegalArgumentException("<AdjustResponseDTO> start > end!");
            }

            if (RESPONSE_CODE_RANGE_MAP.containsKey(clazz)) {
                throw new IllegalArgumentException(
                        String.format("<AdjustResponseDTO> Class:%s already exist!", clazz.getSimpleName()));
            }
            RESPONSE_CODE_RANGE_MAP.forEach((k, v) -> {
                if ((start >= v[0] && start <= v[1]) || (end >= v[0] && end <= v[1])) {
                    throw new IllegalArgumentException(String.format(
                            "<AdjustResponseDTO> Class:%s 's id range[%d,%d] has " + "intersection with " + "class:%s",
                            clazz.getSimpleName(), start, end, k.getSimpleName()));
                }
            });

            RESPONSE_CODE_RANGE_MAP.put(clazz, new int[]{start, end});

            // 提前初始化static变量，进行范围检测
            Field[] fields = clazz.getFields();
            if (fields.length != 0) {
                try {
                    fields[0].get(clazz);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    log.error("e:{}", ExceptionUtils.getStackTrace(e));
                }
            }
        }

        public static void put(ResponseCodeConst codeConst) {
            int[] idRange = RESPONSE_CODE_RANGE_MAP.get(codeConst.getClass());
            if (idRange == null) {
                throw new IllegalArgumentException(String.format("<AdjustResponseDTO> Class:%s has not been registered!",
                        codeConst.getClass().getSimpleName()));
            }
            int code = codeConst.code;
            if (code < idRange[0] || code > idRange[1]) {
                throw new IllegalArgumentException(
                        String.format("<AdjustResponseDTO> Id(%d) out of range[%d,%d], " + "class:%s", code, idRange[0],
                                idRange[1], codeConst.getClass().getSimpleName()));
            }
            RESPONSE_CODE_MAP.put(code, codeConst);
        }
    }
}
