/*(C) 2007-2012 Alibaba Group Holding Limited.	
 *This program is free software; you can redistribute it and/or modify	
*it under the terms of the GNU General Public License version 2 as	
* published by the Free Software Foundation.	
* Authors:	
*   junyu <junyu@taobao.com> , shenxun <shenxun@taobao.com>,	
*   linxuan <linxuan@taobao.com> ,qihao <qihao@taobao.com> 	
*/	
package com.taobao.tddl.common.sync;

public interface ReplicationTaskListener {
    void onTaskCompleted(RowBasedReplicationContext context, boolean success);
}
