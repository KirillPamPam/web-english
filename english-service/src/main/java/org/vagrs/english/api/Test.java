package org.vagrs.english.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kirill Zhitelev on 27.05.2018.
 */
@RestController
public class Test {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
