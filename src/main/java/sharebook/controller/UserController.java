package sharebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sharebook.model.User;
import sharebook.service.UserService;
import org.apache.log4j.Logger;
import javax.annotation.Resource;

@Controller
@RequestMapping("/sharehome")
@ResponseBody
public class UserController {
    @Resource
    private UserService service;
    private static  final Logger LOGGER = Logger.getLogger(UserController.class);
    @RequestMapping("/list")
    public String login(ModelMap rs, Integer code, User user) {
        rs.put("code", code);
        rs.put("mb", user);
        return "sharebook/jsp/shareindex";
    }
    @RequestMapping("/show1")
    public ModelAndView showUser(ModelAndView modelAndView) {
        LOGGER.debug("开始");
        User user = service.queryByNamePwd(new User());
        modelAndView.addObject("list",user);
        System.out.println(user.getUsername()+"-------------------------------------------");
        return modelAndView;
    }
    @RequestMapping("/show")
    public String showUser(Model model) {
        LOGGER.debug("开始");
        User user = service.queryByNamePwd(new User());
        model.addAttribute("list",user);
        System.out.println(user.getUsername()+"-------------------------------------------");
        return "sharebook/jsp/shareindex";
    }
//    @RequestMapping("/loginSubmit")
//    public String loginSubmit(User user, HttpSession session) {
//        int code = 1;
//        if (Ts.hv(user.getUserName()) && Ts.hv(user.getUserPwd())) {
//            User ps = service.queryByNamePwd(user);
//            if (ps != null) {
//                session.setAttribute(Constant.USER_SESSION, ps);
//                return "redirect:showUser";
//            } else {
//                // 不存在
//                code = 2;
//            }
//        }
//        return "redirect:login?code=" + code+"&username="+user.getUserName();
//    }

//    @RequestMapping("/showUser")
//    public String showUser(Model model) {
//        User user=new User();
//        model.addAttribute("list",user);
//        return "showUser";
//    }
//    //跳转上传下载页面
//    @RequestMapping("/uploadDownload")
//    public String upDownload() {
//        return "UploadDownload";
//    }
//    //文件上传
//    @RequestMapping("/upload")
//    public @ResponseBody String upload(MultipartFile file, HttpServletRequest request) throws IOException {
//        String path = request.getSession().getServletContext().getRealPath("upload");
//        String fileName = file.getOriginalFilename();
//        File dir = new File("E://",fileName);
//        if(!dir.exists()){
//            dir.mkdirs();
//        }
//        System.out.println(file);
//        System.out.println(fileName);
//        //MultipartFile自带的解析方法
//        file.transferTo(dir);
//        return "ok!";
//    }
//    //文件下载
//    @RequestMapping("/download")
//    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{
//        //模拟文件，myfile.txt为需要下载的文件
//        String fileName = "E://"+"C5}I]X9Y$}7KIS}H69IWDR7.png";
//        //获取输入流
//        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
//        //假如以中文名下载的话
//        String filename = "img.png";
//        //转码，免得文件名中文乱码
//        filename = URLEncoder.encode(filename,"UTF-8");
//        //设置文件下载头
//        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
//        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
//        response.setContentType("multipart/form-data");
//        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
//        int len = 0;
//        while((len = bis.read()) != -1){
//            out.write(len);
//            out.flush();
//        }
//        out.close();
//    }

}
