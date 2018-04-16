package com.am.newblog.controller.article;

import com.am.newblog.constant.StateConstants;
import com.am.newblog.entity.Article;
import com.am.newblog.util.OSSClientUtils;
import com.am.newblog.util.ReponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AMan
 * @Date 2018/2/7 21:33
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public ReponseResult<Map<String,String>> uploadBlogs(String srcText,String title,MultipartFile file) throws IOException {
      Map<String,String> result = new HashMap<>();

      File nomalFile = File.createTempFile(file.getOriginalFilename(),null);
      file.transferTo(nomalFile);
      InputStream inputStream = new FileInputStream(nomalFile);
      String path = OSSClientUtils.uploadFile(inputStream,file.getOriginalFilename());
        result.put("url:",path);

       return ReponseResult.successResponse("success",result);

    }

    @RequestMapping("/test")
    public String test(ModelAndView modelAndView){
        return "test";
    }

}
