/*
 * (C) 2007-2012 Alibaba Group Holding Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Authors:
 *   wuhua <wq163@163.com> , boyan <killme2008@gmail.com>
 */
package com.alibaba.napoli.metamorphosis.client.producer;

import javax.transaction.xa.XAResource;

import com.alibaba.napoli.metamorphosis.exception.MetaClientException;

/**
 * 支持XA事务的消息生产者
 * 
 * @author boyan
 * 
 */
public interface XAMessageProducer extends MessageProducer {
	/**
	 * 返回一个XAResource对象。事务管理器将使用该对象来管理XAMessageProducer参与到一个分布式事务中。
	 * 
	 * @return
	 */
	public XAResource getXAResource() throws MetaClientException;
}