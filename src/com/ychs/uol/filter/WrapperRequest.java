package com.ychs.uol.filter;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @author wuzhijun
 * @version 1.0
 */
public class WrapperRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	private boolean hasEncode;

	public WrapperRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

	// 对需要增强的方法 进行覆盖
	@Override
	public Map getParameterMap() {
		// 先获得请求方式
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) { // post方式请求
			try {
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if (method.equalsIgnoreCase("get")) { // get方式请求
			Map<String, String[]> parameterMap = request.getParameterMap();
			if (!hasEncode) {
				for (String parameterName : parameterMap.keySet()) {
					String[] values = parameterMap.get(parameterName);
					if (values != null) {
						for (int i = 0; i < values.length; i++) {
							try {
								values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode = true;
			}
			return parameterMap;
		}
		return super.getParameterMap();
	}

	@Override
	public String getParameter(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		if (values == null) {
			return null;
		}
		return values[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}
}
