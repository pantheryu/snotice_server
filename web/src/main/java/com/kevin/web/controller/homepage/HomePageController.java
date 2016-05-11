package com.kevin.web.controller.homepage;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by spirit on 2016/3/23.
 */
@Controller
public class HomePageController {

    @RequestMapping(value = "/wk",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    public String printWelcome(ModelMap model) {
        return "wenkai.jsp";
    }
}
