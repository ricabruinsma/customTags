package com.ricabruinsma.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Gives a greeting based on the time, date, and day of week
 */
public class TimeSmartGreetingTag extends SimpleTagSupport {


    /**
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        LocalDateTime dateTime = LocalDateTime.now();

        out.println("Happy " + determineDayOfWeek(dateTime) + "!");
        out.println(greetingBasedOnTimeOfDay(dateTime));
    }

    /**
     * Determine day of week.
     *
     * @param dateTime the date and time
     * @return the day of week
     */
    public DayOfWeek determineDayOfWeek(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek;
    }

    /**
     * Greeting based on time of day.
     *
     * @param dateTime the date and time
     * @return the greeting
     */
    public String greetingBasedOnTimeOfDay(LocalDateTime dateTime) {
        String greeting;
        int hourOfDay = dateTime.getHour();
        //int hourOfDay = 18;

        if ((hourOfDay > 5) && (hourOfDay < 8)) {
            greeting = "You're up early!";
        } else if ((hourOfDay > 1) && (hourOfDay <= 5)) {
            greeting = "Go to bed!";
        } else if ((hourOfDay >= 8) && (hourOfDay < 12)) {
            greeting = "Have a great start to your day - there's plenty of time!";
        } else if ((hourOfDay >= 12) && (hourOfDay < 17)) {
            greeting = "Keep going just a little bit longer...";
        } else {
            greeting = "Don't you have real life stuff to do?";
        }
        return greeting;
    }

}
