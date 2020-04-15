package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller

public class TimeZoneController {

    @GetMapping ("/worldClock")
    public String getTimeZone(ModelMap modelMap, @RequestParam (name="city", required = false,defaultValue = "Asia/Ho_Chi_Minh")String city)
    {
        Date date=new Date();
        TimeZone local=TimeZone.getDefault();
        TimeZone locale= TimeZone.getTimeZone("city");
        long locale_time=date.getTime()+(locale.getRawOffset()-local.getRawOffset());
        date.setTime(locale_time);
        modelMap.addAttribute("date",date);
        modelMap.addAttribute("city",city);
        return "index";
    }

}
