package org.afpa59.patrice.services.servlet;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MonTag05 extends BodyTagSupport{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	public int doStartTag() throws JspException {
		return EVAL_BODY_TAG;
	}

	public int doAfterBody() throws JspException {
		
		try {
			if ( getBodyContent()!=null ) {
				String bodyString = getBodyContent().getString();
				bodyString = bodyString.toUpperCase();
				getBodyContent().getEnclosingWriter().println( bodyString );
			}
		} catch (IOException e) {
			throw new JspException (e);
		}
		
		return EVAL_PAGE;
	}
	
	@Override
	public void doInitBody() throws JspException{
		super.doInitBody();
	}
	
	
	@Override
	public int doEndTag() throws JspException{
		return super.doEndTag();
	}
	
}
