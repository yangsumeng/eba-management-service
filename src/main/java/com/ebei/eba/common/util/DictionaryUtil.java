package com.ebei.eba.common.util;

import java.util.HashMap;
import java.util.Map;

public final class DictionaryUtil {

	/** 任务状态，未完成 **/
	public static final int TASK_STATE_START = 0;
	/** 任务状态，完成 **/
	public static final int TASK_STATE_FINISH = 1;
	/** 任务状态，过期 **/
	public static final int TASK_STATE_EXPIRE = 2;
	/** 任务状态，保养/维修中 **/
	public static final int TASK_STATE_MAINTAIN = 4;
	/** 任务状态，销单 **/
	public static final int TASK_STATE_DESTROY = 5;
	/** 任务状态，未派单状态  **/
	public static final int TASK_STATE_NOT_DISPATCH = 6;
	/** 任务状态，审核关闭  **/
	public static final int TASK_STATE_CLOSE_PASSED = 7;
	/** 工单池任务 **/
	public static final int WORK_ORDER_YES = 1;
	/** 非工单池任务,默认为非工单池 **/
	public static final int WORK_ORDER_NO = 0;
	/** 正常完成检查 **/
	public static final int FINISH_CHECK_TYPE_NOMAL = 0;
	/** 异常完成检查  **/
	public static final int FINISH_CHECK_TYPE_ABNOMAL = 1;
	
	/**
	 * 任务状态字典
	 */
	public static final Map<Integer, String> DICT_TASK_STATE = new HashMap<Integer, String>();

	/**
	 * 任务操作状态-0：申请关闭-不改变任务状态；审核确认后更改任务状态为TASK_STATE_CLOSE_PASSED，否则保持不变
	 */
	public static final int HANDLE_STATE_CLOSE_APPLY = 0;
	
	/**
	 * 处理状态字典
	 */
	public static final Map<Integer, String> DICT_HANDLE_STATE = new HashMap<Integer, String>();
	
	static
	{
	    DICT_TASK_STATE.put(TASK_STATE_START, "未完成");
	    DICT_TASK_STATE.put(TASK_STATE_FINISH, "完成");
	    DICT_TASK_STATE.put(TASK_STATE_EXPIRE, "过期");
	    DICT_TASK_STATE.put(TASK_STATE_DESTROY, "已销单");
	    DICT_TASK_STATE.put(TASK_STATE_NOT_DISPATCH, "未派单");
	    DICT_TASK_STATE.put(TASK_STATE_CLOSE_PASSED, "审核关闭");
	    DICT_HANDLE_STATE.put(HANDLE_STATE_CLOSE_APPLY, "关闭待审");
	}
	
}
