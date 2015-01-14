package org.afpa59.patrice.services.servlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MonTag06 extends BodyTagSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = null;
	
	public void setName (String string) {
		this.name = string;
	}

	public int doStartTag() throws JspException {
		String value = pageContext.getRequest().getParameter(this.name);
		if (value!=null) {
			pageContext.setAttribute("value", value);
			return EVAL_BODY_INCLUDE;
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException {
		pageContext.removeAttribute("value");
		return EVAL_PAGE;
	}
	
	@Override
	public void doInitBody() throws JspException{
		super.doInitBody();
	}
	
	
}
