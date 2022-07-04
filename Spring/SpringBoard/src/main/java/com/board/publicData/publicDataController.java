package com.board.publicData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/public")
public class publicDataController {
    @Autowired
    private publicDataService publicDataService;

    @GetMapping("/json")
    public String toJson(Model model) throws Exception {
        String rs = publicDataService.json();
        //JacksonDataBind -> ObjectMapper 클래스 이용
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(rs, Map.class);
        model.addAttribute("data", map);

        return "publicData/json";
    }

    @GetMapping("/xml")
    public String toXml(Model model) throws Exception {
        String rs = publicDataService.xml();
        //XmlMapper 클래스 이용
        XmlMapper xmlMapper = new XmlMapper();
        Map<String, Object> map = xmlMapper.readValue(rs, Map.class);
        model.addAttribute("data", map);

        return "publicData/xml";
    }

    @GetMapping("/ajax")
    public String toAjax() throws Exception {
        return "publicData/ajax";
    }
    @GetMapping("/home")
    public String toHome() throws Exception {
        return "publicData/dataHome";
    }

    @ResponseBody
    @GetMapping(value = "/getJson", produces = "application/json; charset=UTF-8")
    public String getJson() throws Exception {
        return publicDataService.json();
    }

    @ResponseBody
    @GetMapping(value = "/getXml", produces = "application/xml; charset=UTF-8")
    public String getXml() throws Exception {
        return publicDataService.xml();
    }
}
