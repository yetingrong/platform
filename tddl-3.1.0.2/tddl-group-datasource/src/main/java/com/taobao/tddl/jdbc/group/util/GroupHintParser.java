//Copyright(c) Taobao.com
package com.taobao.tddl.jdbc.group.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taobao.tddl.common.util.TStringUtil;
import com.taobao.tddl.jdbc.group.dbselector.DBSelector;

/**
 * @description
 * @author <a href="junyu@taobao.com">junyu</a>
 * @version 1.0
 * @since 1.6
 * @date 2010-12-24上午10:32:16
 */
public class GroupHintParser {
	public static Log log = LogFactory.getLog(GroupHintParser.class);

	public static Integer convertHint2Index(String sql) {
		String groupIndexHint = extractTDDLGroupHintString(sql);
		if (null != groupIndexHint && !groupIndexHint.equals("")) {
		    String[] piece=groupIndexHint.split(":");
		    return Integer.valueOf(piece[1]);
		} else {
			return DBSelector.NOT_EXIST_USER_SPECIFIED_INDEX;
		}
	}

	private static String extractTDDLGroupHintString(String sql) {
		return TStringUtil.getBetween(sql.toLowerCase(), "/*+tddl_group({", "})*/");
	}

	public static String removeTddlGroupHint(String sql) {
		String tddlHint= extractTDDLGroupHintString(sql);
		if(null==tddlHint||"".equals(tddlHint)){
			return  sql;
		}
		
	    sql=TStringUtil.removeBetweenWithSplitor(sql.toLowerCase(), "/*+tddl_group({", "})*/");
	    return sql;
	}

	public static void main(String[] args) {
		String sql="/*+TDDL_GROUP({groupIndex:12})*/select * from tab";

		System.out.println(convertHint2Index(sql));
		System.out.println(removeTddlGroupHint(sql));
	}
}
