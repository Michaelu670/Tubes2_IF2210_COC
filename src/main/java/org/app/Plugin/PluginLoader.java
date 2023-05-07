package org.app.Plugin;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import org.app.GUI.MainGUI;


public class PluginLoader {
    // Get all class name from .jar file
    public static ArrayList<String> getAllClassNames(String filePath) {
        ArrayList<String> classNames = new ArrayList<>();

        try {
            JarInputStream jarFile = new JarInputStream(new FileInputStream(filePath));
            JarEntry jarEntry;

            while (true) {
                jarEntry = jarFile.getNextJarEntry();
                if (jarEntry == null) {
                    break;
                }
                if (jarEntry.getName().endsWith(".class")) {
                    classNames.add(jarEntry.getName().replaceAll("/", "\\.").replace(".class", ""));
                }
            }
            jarFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return classNames;
    }

    public static void load(String filePath, MainGUI mainGUI) {
        try {
            ArrayList<String> classNames = getAllClassNames(filePath);

            File file = new File(filePath);
            URL url = file.toURI().toURL();

            try (URLClassLoader classLoader = new URLClassLoader(new URL[] { url })) {
                // Load .class file in the jar
                for (String className : classNames) {
                    try {
                        classLoader.loadClass(className);
                    } catch (Exception e) {
                        System.out.println("Exception: " + className);
                    } catch (Error e) {
                        System.out.println("Error: " + className);
                    }
                }

                Class<?> clazz = classLoader.loadClass("org.app.Plugin." + file.getName().replace(".jar", ""));
                Plugin plugin = (Plugin) clazz.newInstance();

                plugin.onEnable(mainGUI, mainGUI.dataStore);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
