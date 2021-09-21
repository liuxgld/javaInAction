import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class MyClassLoader extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String fileName = "Hello.xlass/Hello.xlass";
        Class<?> clazz = new MyClassLoader().findClass(fileName);
        Method method = clazz.getMethod("hello");
        method.invoke(clazz.newInstance());
    }
    @Override
     protected   Class<?> findClass(String fileName) {
        String className = fileName.replaceAll("/",".").substring(0,fileName.lastIndexOf("."));
        try {
            InputStream inputStream = new FileInputStream(new File(fileName));
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            for( int index = 0; index < bytes.length; index ++) {
                int byteInt = 255 - Byte.toUnsignedInt(bytes[index]);
                bytes[index] = (byte) byteInt;
            }
            System.out.println(new String(bytes));
            return defineClass("Hello",bytes,0,bytes.length);
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return null;
     }
}
