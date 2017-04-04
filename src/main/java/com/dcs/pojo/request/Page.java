package com.dcs.pojo.request;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * ClassName: Request
 * 
 * @Description: 请求分页参数基类
 * @author zongzi
 * @date 2016年7月27日 下午2:03:38
 */
public class Page implements Serializable {

	/**
	 */
	private static final long serialVersionUID = -4459581002535608627L;
	// 当前页
	private Integer pageIndex;
	// 每页条数
	private Integer pageSize;
	//结尾页数
	private Integer totalSize;
	private Integer pageEnd;
	// 开始记录
	@SuppressWarnings("unused")
	private Integer pageStart;
	// null或者0分页；1：不分页
	private Integer all;
	private String startDate;
	private String endDate;
	// 排序字段
	private String sortField;
	// desc or asc
	private String orderType;

	public Page(){}
	
	
	public Integer getPageEnd() {
		int temp=pageSize/10;
		return pageSize%10>0?temp+1:temp;
	}

	public Integer getPageIndex() {
		if (pageIndex == null || pageIndex == 0) {
			return 1;
		}
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		if (pageSize == null) {
			return 10;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getAll() {
		return all;
	}

	public void setAll(Integer all) {
		this.all = all;
	}

	public Integer getPageStart() {
		if (pageIndex == null || pageIndex == 0) {
			return 0;
		}
		return (pageIndex - 1) * pageSize;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		if (pageIndex == null) {
			this.sortField="id";
		} else{
			this.sortField = sortField;
		}
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		if (pageIndex == null) {
			this.sortField="asc";
		} else{
			this.sortField = orderType;
		}
	}


	public Integer getTotalSize() {
		return totalSize;
	}


	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	
}
