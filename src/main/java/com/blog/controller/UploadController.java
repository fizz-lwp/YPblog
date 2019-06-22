package com.blog.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    private static final String UPLOADED_FOLDER = "D://upload//blog_photo//";
    private static final String URL = "/upload/blog_photo/";

    //处理文件上传
    @RequestMapping("/uploadFile")
    public @ResponseBody Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<>();
        System.out.println(request.getContextPath());
        String fileName = file.getName();
        //保存
        try {
            byte[] bytes = file.getBytes();
            // 文件存储路径
            Path path = Paths.get(UPLOADED_FOLDER + file.getName());
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            // 文件映射路径
            resultMap.put("url",URL + fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        return resultMap;
    }

}
