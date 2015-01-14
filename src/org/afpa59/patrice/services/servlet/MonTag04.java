package org.afpa59.patrice.services.servlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class MonTag04 extends BodyTagSupport{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count = 0;

	private int current;
	
	public int getCount() {
		return count;
	}	

	public void setCount(int i) {
		count = i;
	}

	public int doStartTag() throws JspException {
		current = 0;
		
		if (current < count){
			
			pageContext.setAttribute("count", count);
			
			return Tag.EVAL_BODY_INCLUDE;
	}
		return Tag.SKIP_BODY;
	}

	public int doAfterBody() throws JspException {
		current++;
		if (current < count)
			return IterationTag.EVAL_BODY_AGAIN;
		return Tag.SKIP_BODY;
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
