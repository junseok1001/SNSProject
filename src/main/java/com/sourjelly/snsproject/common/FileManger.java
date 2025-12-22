package com.sourjelly.snsproject.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManger {

//    public final static String FILE_UPLOAD_PATH="D:\\jun_project\\springProject\\upload\\snsproject";
    public final static String FILE_UPLOAD_PATH="D:\\webInventer\\springProject\\upload\\snsproject";

    public static String saveFile(long userId, MultipartFile file){

        if(file == null){
            return null;
        }

        // 파일 저장 규격 userId_UnixTime
        String directoryName = "/"+ userId + "_" + System.currentTimeMillis();


        String directoryPath = FILE_UPLOAD_PATH + directoryName;

        File directory = new File(directoryPath);

        if(!directory.mkdir()){
            //디렉토리 생성 실패
            return null;
        }

        String filePath = directoryPath + "/" + file.getOriginalFilename();

        try {

            byte[] bytes = file.getBytes();

            Path path = Paths.get(filePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            return null;
        }


        return "/images" + directoryName + "/" + file.getOriginalFilename();
    }


    public static boolean removeFile(String imagePath){
        // image넣는게 필수가 아니여서
        // image 경로가 null 이라면 false 기능수행 정지
        if(imagePath == null){
            return false;
        }

        String fullFilePath = FILE_UPLOAD_PATH + imagePath.replace("/images", "");

        Path path = Paths.get(fullFilePath);
        Path directoryPath = path.getParent();

        try {
            Files.delete(path);
            Files.delete(directoryPath);
        } catch (IOException e) {
            return false;
        }

        return true;


    }



}
