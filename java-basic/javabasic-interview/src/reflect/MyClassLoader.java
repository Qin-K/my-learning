package reflect;

import java.io.*;

/**
 * @author Qin Kai
 * @date 2019-11-13
 */
public class MyClassLoader extends ClassLoader {
    private String path;
    public MyClassLoader(String path) {
        this.path = path;
    }
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] b = loadClassData(className);
        return defineClass(className, b, 0, b.length);
    }

    private byte[] loadClassData(String className) {
        File file = new File(path, className + ".class");
        InputStream is = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(file);
            int len;
            byte[] buff=  new byte[1024];
            while ((len = is.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return out.toByteArray();
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader classLoader = new MyClassLoader("F:\\");
        Class<?> aClass = classLoader.findClass("Test");
        aClass.newInstance();
    }
}
