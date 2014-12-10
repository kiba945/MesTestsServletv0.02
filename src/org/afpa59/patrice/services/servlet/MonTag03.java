package org.afpa59.patrice.services.servlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MonTag03 extends BodyTagSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name = null;

	
	public void setName (String string) {
		this.name = string;
	}
	

	@Override
	public int doStartTag() throws JspException{
		
		String value = pageContext.getRequest().getParameter(this.name);
       
		if (value != null){
			return EVAL_BODY_INCLUDE;
		}
				
		return SKIP_BODY;
		
	}
	
	@Override
	public void doInitBody() throws JspException{
		super.doInitBody();
	}
	
	@Override
	public int doAfterBody() throws JspException{
		return super.doAfterBody();
		
	}
	
	@Override
	public int doEndTag() throws JspException{
		return super.doEndTag();
	}
	
}
