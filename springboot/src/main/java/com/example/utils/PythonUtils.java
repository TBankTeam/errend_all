package com.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonUtils {
//    private int userid = 31;
    public void runPythonScript(int userid) {
        try {
            // 创建一个 ProcessBuilder 对象，传入 Python 解释器的路径和要执行的 Python 脚本的路径
            ProcessBuilder pb = new ProcessBuilder("C:\\Users\\86131\\PycharmProjects\\pythonProject\\venv\\Scripts\\python.exe", "C:\\Users\\86131\\Desktop\\errend_all-second (2)\\pythonUtils\\RA_NOdistance.py",String.valueOf(userid));

            // 启动进程并执行 Python 脚本
            Process process = pb.start();

            // 读取 Python 脚本的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            // 等待 Python 脚本执行完毕
            int exitCode = process.waitFor();
            System.out.println("Python script execution completed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
