package com.dcs.util;

import java.lang.annotation.AnnotationFormatError;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AttributeBuildExcelUtils {
	public static List<AttriInfo> parseParamsAttriInfo(Field[] params)
			throws Exception {
		boolean isThereNoAttributaBuildExcel = true;
		List<AttriInfo> paramInfos = new ArrayList<AttriInfo>();

		for (Field param : params) {
			AttributeBuildExcel annotation = param
					.getAnnotation(AttributeBuildExcel.class);
			if (annotation != null) {
				isThereNoAttributaBuildExcel = false;
				int order = annotation.order();
				String excelColumName = annotation.excelColumName();
				boolean needMerge = annotation.needMerge();
				String paramName = param.getName();
				AttriInfo attriInfo = new AttriInfo(order, excelColumName,
						needMerge, paramName);

				paramInfos.add(attriInfo);
			} else {
			}
		}

		if (isThereNoAttributaBuildExcel)
			throw new AnnotationFormatError(
					"CAN'T FIND Annotation -- @AttributeBuilExcel");

		Collections.sort(paramInfos, new Comparator<AttriInfo>() {
			@Override
			public int compare(AttriInfo o1, AttriInfo o2) {
				if (o1 != null && o2 != null)
					return o1.getOrder() - o2.getOrder();
				else if (o2 == null)
					return -1;
				else
					return -1;
			}
		});
		return paramInfos;
	}
}
