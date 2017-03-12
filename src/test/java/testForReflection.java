import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/9.
 */
public class testForReflection {
    @Test
    public void testForGetClass() throws ClassNotFoundException {
        Boolean var1 = true;
        Class<?> classType2 = var1.getClass();
        System.out.println(classType2);

        Class<?> classType4 = Boolean.class;
        System.out.println(classType4);

        Class<?> classType5 = Class.forName("java.lang.Boolean");
        System.out.println(classType5);

        Class<?> classType3 = Boolean.TYPE;
        System.out.println(classType3);

        Class<?> classType = ExtendType.class;

// 使用getFields获取属性
        Field[] fields =  classType.getFields();
        for (Field f : fields)
        {
            String  c = f.getName();
//            if (c.equals(""))
            System.out.println("属性的名字为"+c);
        }

        System.out.println();

// 使用getDeclaredFields获取属性
        fields = classType.getDeclaredFields();
        for (Field f : fields)
        {
            System.out.println(f);
        }
    }

    @Test
    public void testForGetMethod(){
        Class<?> classType = ExtendType.class;
        Method[] methods = classType.getMethods();
        for (Method m : methods)
        {
            System.out.println(m);
        }

        System.out.println();

// 使用getDeclaredMethods获取函数
        methods = classType.getDeclaredMethods();
        for (Method m : methods)
        {
            System.out.println(m);
        }
    }


//    @Test

    /**
     *
     * @param t
     * @throws ClassNotFoundException
     */
    public void testForConstructor(Class<?> t) throws ClassNotFoundException {

        Class<?> classType = Class.forName(t.getName());
        Constructor<?>[] constructors = classType.getConstructors();
        for (Constructor<?> m : constructors)
        {
            System.out.println(m);
        }

        System.out.println();

// 使用getDeclaredConstructors获取构造器
        constructors = classType.getDeclaredConstructors();
        for (Constructor<?> m : constructors)
        {
            System.out.println(m);
        }


    }

    @Test
    public void testForConstructor2() throws ClassNotFoundException {
        ExtendType extendType = new ExtendType();
        testForConstructor(extendType.getClass());
    }

    @Test
    public void testForUseConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> classType = ExtendType.class;
        Constructor<?> constructor2 =
                classType.getDeclaredConstructor(int.class, String.class);
        Object inst = constructor2.newInstance(1, "123");

        Method logMethod = classType.getDeclaredMethod("Log", String.class);

        logMethod.invoke(inst, "test");//也就是说用了自己的该对象的方法，还可以使用其他对象的方法
//        if (inst instanceof ExtendType){
//
//
//            Method[] methods = inst.getClass().getDeclaredMethods("Log", String.class);
//            for (Method m : methods)
//            {
//                m.invoke(inst,"log");
//            }
//        }
    }
}
