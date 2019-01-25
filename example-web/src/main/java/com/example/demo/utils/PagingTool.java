package com.example.demo.utils;

import java.util.List;

/**
 * 
 * <p>Project: Credo's Base</p>
 * <p>Description: 适合于Oralce 数据库的分页工具类</p>
 * <p>Copyright (c) 2019 LionCredo.All Rights Reserved.</p>
 * @author <a href="zhaoqianjava@foxmail.com">LionCredo</a>
 */
public class PagingTool  <T>{
	/** 
     * 总条数
     */
    private int totalNumber;
    /**
     * 当前第几页
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示条数
     */
    private int pageSize = 5;
    /**
     * 数据库中从第几条开始取（dbIndex, dbNumber配合在Oracle中使用）
     */
    private int dbIndex;
    /**
     * 数据库发分页后一共取多少条
     */
    private int dbNumber;
    
    // 取到第几条（dbIndex, dbEnd配合在oracle中使用）
    private int dbEnd;
    
    private List<T> dataList;
    /**
     * 根据当前对象中属性值计算并设置相关属性值
     */
    public void count() {
        // 计算总页数
        int totalPageTemp = this.totalNumber / this.pageSize;
        int plus = (this.totalNumber % this.pageSize) == 0 ? 0 : 1;
        totalPageTemp = totalPageTemp + plus;
        if(totalPageTemp <= 0) {
            totalPageTemp = 1;
        }
        this.totalPage = totalPageTemp;
        // 设置当前页数
        // 总页数小于当前页数，应将当前页数设置为总页数
        if(this.totalPage < this.currentPage) {
            this.currentPage = this.totalPage;
        }
        // 当前页数小于1设置为1
        if(this.currentPage < 1) {
            this.currentPage = 1;
        }
        
        // 设置rownum的参数
        this.dbIndex = (this.currentPage - 1) * this.pageSize +1;
        this.dbNumber = this.pageSize;
        if(currentPage ==totalPage ) {
        	this.dbEnd =  totalNumber;
        }else {
        	this.dbEnd =  this.currentPage * this.pageSize;        	
        }
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
        this.count();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }

    public int getDbEnd() {
        return dbEnd;
    }

    public void setDbEnd(int dbEnd) {
        this.dbEnd = dbEnd;
    }

  
	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	@Override
    public String toString() {
        return "Page [totalNumber=" + totalNumber + ", currentPage="
                + currentPage + ", totalPage=" + totalPage + ", pageNumber="
                + pageSize + ", dbIndex=" + dbIndex + ", dbNumber="
                + dbNumber + ", dbEnd=" + dbEnd + "]";
    }

	
}
