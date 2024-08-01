package cn.sxgan.chat.common.utils.file;

import cn.sxgan.chat.common.consts.FilePathConst;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description: 文件公共处理类
 * @Author: sxgan
 * @Date: 2024-08-01 16:40
 * @Version: 1.0
 **/
@Slf4j
public class FileUtil {
    
    /**
     * 写入文件到指定目录
     */
    public static void uploadFile(String data, String name) {
        String filePath = FilePathConst.ROOT_DIR + "/a-doc/upload/file/" + name;
        writeADocument(data, filePath, true);
    }
    
    /**
     * 向一个文件写入字符内容
     *
     * @param data 写入的内容
     * @param path 文件路径
     * @param type 写入方式（true:追加，false:覆盖）
     */
    public static void writeADocument(String data, String path, boolean type) {
        try {
            FileWriter fileWriter = new FileWriter(path, type);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(data);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
