package com.dcs.util;

public class AttriInfo {

	private int order;
	private String excelColumName;
	private boolean needMerge;
	private String paramName;

	public AttriInfo(int order, String excelColumName, boolean needMerge,
			String paramName) {
		super();
		this.order = order;
		this.excelColumName = excelColumName;
		this.needMerge = needMerge;
		this.paramName = paramName;
	}

	@Override
	public String toString() {
		return "AttriInfo [order=" + order + ", excelColumName="
				+ excelColumName + ", needMerge=" + needMerge + ", paramName="
				+ paramName + "]";
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getExcelColumName() {
		return excelColumName;
	}

	public void setExcelColumName(String excelColumName) {
		this.excelColumName = excelColumName;
	}

	public boolean isNeedMerge() {
		return needMerge;
	}

	public void setNeedMerge(boolean needMerge) {
		this.needMerge = needMerge;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

}
