package com.mypro.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

public class FileUtils {
    /**
     * springMVC 处理文件上传
     * @param partFile 上传的文件
     * @param type 文件存放的目录 例如:/mnt/file/
     * @return 传入的文件参数若为空，或者传入的文件名称为空时返回值为null,否则返回文件在数据库中存储的相对路径+文件名称
     *         返回值(存储的相对路径+文件名称)=当前年月+随机数
     *         文件存放的绝对路径+文件名称=rootPath+当前年月+随机数
     *         例如：上传的文件类型为jpg rootPath:/mnt/file/ 当前年月为 :201611 生成随机数为:7a932fe2-61a1-4fd8-ad56-385b289c9cd3
     *               返回值(存储的相对路径+文件名称)=201611/7a932fe2-61a1-4fd8-ad56-385b289c9cd3.jpg
     *               文件存放的绝对路径+文件名称=/mnt/file/201611/7a932fe2-61a1-4fd8-ad56-385b289c9cd3.jpg
     * @throws java.io.IOException
     * @throws IllegalStateException
     */
    public static String uploadFile(MultipartFile partFile, String type,HttpServletRequest request) throws IllegalStateException, IOException {
        if(partFile!=null&&partFile.getOriginalFilename()!=null&&partFile.getOriginalFilename().length()>0){
            Calendar cal = Calendar.getInstance();
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
            String filePath="/resources/"+type+"/"+year+month+"/";
            String fileOriginalName=partFile.getOriginalFilename();
            String newFileName=UUID.randomUUID()+fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newpath=request.getSession().getServletContext().getRealPath(filePath+newFileName);
            File file=new File(newpath);
            //            如果不存在文件夹，则创建，多级
            if(!file.getParentFile().exists());
            file.getParentFile().mkdirs();

            //文件写入磁盘
            partFile.transferTo(file);
            //返回存储的相对路径+文件名称
            return filePath+newFileName;
        }
        else
            return null;
    }

}
