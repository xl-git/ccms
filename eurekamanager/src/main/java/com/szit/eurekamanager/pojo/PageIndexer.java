package com.szit.eurekamanager.pojo;

import java.io.Serializable;

/**
 * 分页实体类
 * @author 肖林
 * @version 1.0 2020-03-31
 */
public class PageIndexer implements Serializable {
	private Integer pageIndex;//页码
	private Integer pageSize;//每页记录数
	private Integer pageCount;//总页码
	private Integer count;//总记录数

	public PageIndexer(){
		
	}
	
	public PageIndexer(Integer pageIndex,Integer pageSize,Integer pageCount,Integer count){
		this.pageIndex=pageIndex;
		this.pageSize=pageSize;
		this.pageCount=pageCount;
		this.count=count;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
