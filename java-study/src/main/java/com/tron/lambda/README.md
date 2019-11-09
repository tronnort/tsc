#####代码重构之路

```text
用lambda表达式取代匿名函数
用方法引用重构lambda表达式
用Stream重构命令式数据处理
```

#####lambda表达式的理解
```text
Runnable runnable = new Runnable(){
    public void run(){
        System.out.println("toDO someThing");
    }
}
要关注的仅是run方法的传参和返回值类型，至于为什么不需要方法名，是因为函数式接口规定了只能有一个抽象方法。
所以java8的编译器自己会识别方法名

Runnable runnable = () -> System.out.println("toDO someThing");

lambda表达式 是一种传递匿名函数的方式，它没有名称但是有参数列表，主体，返回类型。
lambda表达式 可以赋值给一个变量，或者传递给一个接受函数式接口作为参数的方法。
```


#####基础语法
```text
(parameters) -> expression      //后跟表达式
或（请注意语句的花括号）
(parameters) -> { statements; }   //后跟语句

正确示例
(1) () -> {}
(2) () -> "Raoul"
(3) () -> {return "Mario";}
(4) (String s) -> s.length()           传参String  返回int    隐含return
(5) (Apple a) -> a.getWeigth > 150     传参对象  返回boolean   隐含return
(6) (int x, int y) -> {
    System.out.print(x);
    System.out.print(y);
}                  传参int  void返回

错误示例
(1) (Integer i) -> return "Alan" + i;
(2) (String s) -> {"IronMan";}

总结   不加{}时,lambda隐含了 return,手动添加会导致错误。 加{}时，确保{}内是完整的语句。
```

#####什么是方法签名
```text
(参数)->返回类型
```

#####需要记住的几个函数式接口
```java
@FunctionalInterface
public interface Predicate<T>{         //断言接口  传入泛型 返回true  false
boolean test(T t);
}

@FunctionalInterface
public interface Consumer<T>{          //消费接口 传入泛型  没有返回值
void accept(T t);
}

@FunctionalInterface
public interface Function<T, R>{       //函数接口   传入泛型  返回泛型
R apply(T t);
}

@FunctionalInterface
public interface Supplier<T>{         //供给接口   传入空  返回泛型
T get();
}


```

#####方法引用---调用当前参数的xx方法
```text
如果lambda代表的只是“直接调用这个方法”

当lamdba表达式完全匹配类的方法时
(Apple a) -> a.getWeight()               Apple::getWeight
(String s) -> System.out.println(s)      System.out::println
(str, i) -> str.substring(i)             String::substring

方法引用主要有三类
(1) 指向静态方法的方法引用（例如Integer的parseInt方法，写作Integer::parseInt）
(2) 指向任意类型实例方法的方法引用（ 例如String 的length 方法， 写作
String::length）
(3) 指向现有对象的实例方法的方法引用（假设你有一个局部变量expensiveTransaction
用于存放Transaction类型的对象，它支持实例方法getValue，那么你就可以写expensive-
Transaction::getValue）
```


