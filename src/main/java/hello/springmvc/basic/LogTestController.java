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
        String name = "Spring";

        System.out.println("name = " + name);

        /***
         * log를 남기는 방식 중에 파라미터를 넘기는 방식이 아니라 Java의 연산 방식을 사용해서 남기는 것도 가능하다.
         * 하지만 이 방식은 Java 연산 특성상 무조건 수행하기 때문에 log가 남기지 않는 상황에서도 일단 연산을 수행한다.
         * 그러므로 남겨지지도 않는 로그에 대해 불필요하게 연산을 수행하여 CPU, MEM를 잡아먹을 수 있기에 해당 방식은 사용을 금한다.
         * 결론: log 코드를 연산식으로 작성하면 혼난다.
         */
        log.trace("trace log="+ name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
