package com.zgy.learn.crud.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @Author: renjiaxin
 * @Description: 文件上传
 * @Date: 2019-11-24 02:55
 * @Modified by:
 */
@Controller
public class UploadController {
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, ModelMap mp) throws IOException {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("/") +
        //        "upload/" + sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
        String path = "/Users/renjiaxin/123.jpg";
        FileOutputStream fos2 = new FileOutputStream(path);
        String fileInfo = String.format("文件名: %s, 路径是: %s", fileName, path);
        fos2.write(file.getBytes());
        fos2.flush();
        fos2.close();
        mp.addAttribute("fileInfo", fileInfo);
        return "uploadresult";
    }
}
