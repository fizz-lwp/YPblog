package com.blog.controller;
import com.blog.entity.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    UserService userService;

    private static final String UPLOADED_BP_FOLDER = "D://upload//blog_photo//";
    private static final String UPLOADED_HP_FOLDER = "D://upload//head_photo//";
    private static final String BP_URL = "/upload/blog_photo/";
    private static final String HP_URL = "/upload/head_photo/";

    //处理文件上传
    @RequestMapping("/uploadFile")
    public @ResponseBody Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<>();
        String fileName = file.getOriginalFilename();
        //保存
        try {
            byte[] bytes = file.getBytes();
            // 文件存储路径
            Path path = Paths.get(UPLOADED_BP_FOLDER + fileName);
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            // 文件映射路径
            resultMap.put("url",BP_URL + fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        return resultMap;
    }

    @RequestMapping("/head_photo_cut")
    public String head_photo_cut(@RequestParam(value = "file", required = false)MultipartFile file,Model model,HttpSession session){
        String fileName = file.getOriginalFilename();
        User user = (User)session.getAttribute("loginUser");
        //保存
        try {
            byte[] bytes = file.getBytes();
            // 文件存储路径
            Path path = Paths.get(UPLOADED_HP_FOLDER + fileName);
            Files.write(path, bytes);
            user.setHeadPhoto(HP_URL + fileName);
            userService.updateUser(user);
            session.setAttribute("loginUser",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("src",HP_URL + fileName);
        return "login_only/head_photo_cut";
    }

    @RequestMapping("/cutImage")
    public String cutImage(int x, int y, int w, int h,HttpSession session){
        User user = (User)session.getAttribute("loginUser");
        String fileName = user.getHeadPhoto().substring(19);
        String srcImageFile = UPLOADED_HP_FOLDER + fileName;
        abscut(srcImageFile,x,y,w,h);
        return "login_only/edit_userinfo";
    }

    /**
     *  缩放后裁剪图片方法
     * @param srcImageFile 源文件
     * @param x  x坐标
     * @param y  y坐标
     * @param w 最终生成的图片宽
     * @param h 最终生成的图片高
     */
    public static void abscut(String srcImageFile,int x, int y, int w,
                              int h) {
        try {
            Image img; // 截取图像
            ImageFilter cropFilter; // 图像过滤器
            BufferedImage bi = ImageIO.read(new File(srcImageFile)); // 读取源图像
            int srcWidth = bi.getWidth(); // 源图宽度
            int srcHeight = bi.getHeight(); // 源图高度
            int proportion = srcWidth / 350; // 原图与页面图大小比例
            int finalWidth = 350;
            int finalHeight = srcHeight / proportion;
//            if (srcWidth >= destWidth && srcHeight >= destHeight) {
            // 获取缩放后的图片大小
            Image image = bi.getScaledInstance(finalWidth,finalHeight,Image.SCALE_DEFAULT);
            cropFilter = new CropImageFilter(x, y, w, h);
            // 生成截取后的图
            img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
            // 绘制截取后的图
            BufferedImage tag = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(img, 0, 0, null); //
            g.dispose();
            // 输出为文件
            ImageIO.write(tag, "JPEG", new File(srcImageFile));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
