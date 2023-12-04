//package com.spring.gta.common;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class PythonLauncher {
//
//    public PythonLauncher() {
//        System.out.println("================python launcher start===================");
//        try {
//            // 운영체제 확인
//            String os = System.getProperty("os.name").toLowerCase();
//            // 포트 사용중인 프로세스 종료
//            if (os.contains("win")) {
//                killProcessWindows(5000);
//            } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
//                killProcessLinux(5000);
//            }
//            // Python Flask 애플리케이션 실행
//            runFlaskApp();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void killProcessLinux(int port) throws IOException, InterruptedException {
//        String command = "lsof -t -i:" + port;
//        Process p = Runtime.getRuntime().exec(command);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            Runtime.getRuntime().exec("kill -9 " + line);
//        }
//        p.waitFor();
//    }
//
//    private void killProcessWindows(int port) throws IOException, InterruptedException {
//        String line;
//        String pid = null;
//        // 포트를 사용하는 프로세스의 PID 찾기
//        Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "netstat -ano | findstr :" + port});
//        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        while ((line = reader.readLine()) != null) {
//            if (line.contains("LISTENING")) {
//                pid = line.substring(line.lastIndexOf(' ') + 1);
//                break;
//            }
//        }
//        reader.close();
//        // 프로세스 종료
//        if (pid != null) {
//            Runtime.getRuntime().exec("taskkill /F /PID " + pid);
//            System.out.println("Process with PID " + pid + " on port " + port + " has been terminated.");
//        } else {
//            System.out.println("No process found on port " + port);
//        }
//    }
//
//    private void runFlaskApp() throws IOException {
//        // Python 가상 환경과 Flask 애플리케이션 실행 명령어
//        String pythonEnvPath = "C:/Users/rlarb/anaconda3/envs/kim/python.exe";
//        String appPath = "C:/Users/rlarb/PycharmProjects/pythonProject/GTA/app3.py";
//        String appCommand = pythonEnvPath + " " + appPath;
//        Runtime.getRuntime().exec(appCommand);
//        System.out.println("================Flask app started===================");
//    }
//}
