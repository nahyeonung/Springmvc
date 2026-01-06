package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass()); -> @Slf4j Annotation으로 대체 가능

    @RequestMapping("/log-test")
    public String logTest(){

        log.trace("trace log={}", getClass());
        log.debug("debug log={}", getClass());
        log.info("info log={}", getClass());
        log.warn("warn log={}", getClass());
        log.error("error log={}", getClass());

        return "ok";
    }
}
