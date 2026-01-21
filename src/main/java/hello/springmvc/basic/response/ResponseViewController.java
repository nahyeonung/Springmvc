package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    /**
     * 권장하지 않는 방법!!
     * url 매핑 경로랑 뷰 템플릿 경로랑 같으면 return 생략 가능
     * 명시하는 방법이 더 직관적이고 좋음
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
    }
}
