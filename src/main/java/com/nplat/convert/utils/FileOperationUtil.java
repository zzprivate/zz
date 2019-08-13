package com.nplat.convert.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by roy on 2018/11/29.
 */
public class FileOperationUtil {

    public static File createEmptyFile(String filename) throws Exception {

        File file = new File(filename);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        return file;
    }

    public static String getTitleRandom() {
        String str = "";
        for (int i = 0; i < 1; i++) {
            str = str + (char) (Math.random() * 26 + 'a');
        }
        long m = System.currentTimeMillis();
        str += m;
        return str;
    }

    public static String writeFileWithBuilder(String dirPath, StringBuilder builder) throws Exception {
        String filePath = dirPath+ FileOperationUtil.getTitleRandom()+".json";
        File emptyFile = FileOperationUtil.createEmptyFile(filePath);
        FileOutputStream outSTr = new FileOutputStream(emptyFile);
        BufferedOutputStream Buff = new BufferedOutputStream(outSTr);
        Buff.write(builder.toString().getBytes());
        Buff.flush();
        Buff.close();
        outSTr.close();
        builder.setLength(0);
        return filePath;
    }

    public static InputStream getFileBytes(String filePath) {
        InputStream inputStream = null;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                inputStream = new FileInputStream(file);
            }
            return inputStream;
        }catch (Exception e) {
            return inputStream;
        }
    }

}
