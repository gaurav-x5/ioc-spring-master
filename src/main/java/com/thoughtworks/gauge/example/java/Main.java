package com.thoughtworks.gauge.example.java;

import org.apache.maven.shared.invoker.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Main {

//    private static void findfile() throws IOException {
//        final String path = "resources/specs";
//        final File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//
//        if(jarFile.isFile()) {  // Run with JAR file
//            final JarFile jar = new JarFile(jarFile);
//            final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
//            while(entries.hasMoreElements()) {
//                final String name = entries.nextElement().getName();
//                if (name.startsWith(path + "/")) { //filter according to the path
//                    System.out.println(name);
//                }
//            }
//            jar.close();
//        }
//    }
    private static void exec() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "/Users/gauravkumar/Downloads/ioc-spring-master/pom.xml" ) );
        request.setGoals( Collections.singletonList( "test" ) );

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
        invoker.execute( request );
    }

    public static void main(String[] args) throws MavenInvocationException {
//        ClassLoader classLoader = Main.class.getClassLoader();
//        String cmd = "gauge run "+ classLoader.getResource("specs").getPath();

          exec();


//        ProcessBuilder builder = new ProcessBuilder(
//                "/bin/bash", "-c", "mvn test");
//        builder.redirectErrorStream(true);
//        Process p = builder.start();
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line;
//        while (true) {
//            line = r.readLine();
//            if (line == null) { break; }
//            System.out.println(line);
//        }
    }
}
