package com.inmyshow.webbase.action.utils;

import java.util.List;
/**提供给jqGird的数据格式
 * @author HanHongmin
 *
 */
@SuppressWarnings("rawtypes")
public class GirdJsonObject {
	private String page;
	private long total;
	private String records;

	private List rows;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records = records;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
