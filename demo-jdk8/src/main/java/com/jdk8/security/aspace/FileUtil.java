package com.jdk8.security.aspace;

import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author zhouj
 * @date 2020/4/25 23:43
 */
public class FileUtil {
    // 工程 A 执行文件的路径
    private final static String FOLDER_PATH = "E:\\ideaworkspace\\AllTest\\demo-all\\demo-jdk8\\src\\main\\java\\com\\jdk8\\security\\aspace";

    public static void makeFile(String fileName) {
        try {
            // 尝试在工程 A 执行文件的路径中创建一个新文件
            File fs = new File(FOLDER_PATH + "\\" + fileName);
            fs.createNewFile();
        } catch (AccessControlException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doPrivilegedAction(final String fileName) {
        // 用特权访问方式创建文件
        AccessController.doPrivileged(new PrivilegedAction<String>() {
            @Override
            public String run() {
                makeFile(fileName);
                return null;
            }
        });
    }
}
