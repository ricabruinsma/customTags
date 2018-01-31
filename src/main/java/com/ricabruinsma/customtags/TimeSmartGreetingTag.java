package com.ricabruinsma.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class TimeSmartGreetingTag extends SimpleTagSupport {



    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        out.println("Happy " + dayOfWeek + "!");
        out.println("Do you know what time it is???");
    }

}
