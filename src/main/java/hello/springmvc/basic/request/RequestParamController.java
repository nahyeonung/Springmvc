package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody //RestController를 사용하지 않고 response body에 데이터를 담아서 응답해주는 애노테이션
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge){
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    /**
     * 파마리터와 변수명이 같으면 파라미터명 생략 가능
     * @param userName
     * @param age
     */
    @ResponseBody 
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String userName,
                                 @RequestParam int age){
        log.info("username={}, age={}", userName, age);
        return "ok";
    }

    /**
     * 파마리터와 변수명이 같고, String, int, Integer 등 단순 타입이면 RequestParam 애노테이션도 생략 가능!!
     * 근데 너무 생략하기보단 애노테이션까지 있으면 가독성에 훨씬 유리함
     * @param userName
     * @param age
     * @return
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String userName,
                                 int age){
        log.info("username={}, age={}", userName, age);
        return "ok";
    }

    /**
     * required default value = true
     * 조건 충족 못할 시 400 Bad request error(int는 null이 들어갈 수 없으니 500 error)
     * @param userName
     * @param age
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true ) String userName,
                                       @RequestParam(required = false)int age){
        log.info("username={}, age={}", userName, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String userName,
                                       @RequestParam(required = false, defaultValue = "-1") int age){
        log.info("username={}, age={}", userName, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}", paramMap.get("username") , paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
