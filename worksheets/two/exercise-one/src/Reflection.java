import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Requires a class name as argument to program");
            System.exit(-1);
        }

        Class clazz = null;
        String file = args[0];
        try {
            clazz = Class.forName(file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("public method: " + methods[i]);
        }
    }
}
