#####基础语法
```
(parameters) -> expression      //后跟表达式
或（请注意语句的花括号）
(parameters) -> { statements; }   //后跟语句

正确示例
(1) () -> {}
(2) () -> "Raoul"
(3) () -> {return "Mario";}

错误示例
(1) (Integer i) -> return "Alan" + i;
(2) (String s) -> {"IronMan";}
```

#####什么是方法签名
```
(参数)->返回类型
```

#####需要记住的几个函数式接口
```
@FunctionalInterface
public interface Predicate<T>{
boolean test(T t);
}

@FunctionalInterface
public interface Consumer<T>{
void accept(T t);
}

@FunctionalInterface
public interface Function<T, R>{
R apply(T t);
}

@FunctionalInterface
public interface Supplier<T>{
T get();
}


```

#####方法引用---调用当前参数的xx方法
```
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
