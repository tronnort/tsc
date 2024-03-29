快速选中一个方法的所有代码
```
定位到方法开始行
ctrl + w w
```
修改class或属性
```
定位到要修改的位置
shift + F6     enter
```
快速定位到错误行
```
F2    ctrl+F1 显示错误信息   alt+enter 添加异常  ctrl+alt+t/code选项 添加try
```

跳转接口，接口实现类
```
ctrl + b  到接口    ctrl + alt + b  列出实现类
```

显示当前类的方法列表
```
ctrl + F12
```

复制一行代码
```
ctrl + d     
```
删除一行代码
```text
ctrl + y
```
折叠代码
```text
ctrl + shift + "+"  ctrl + shift + "-"
```
快速选取代码
```text
atl + j  逐个选取   ctrl + alt + shift + j 选取所有  
alt + shift + j  从后向前单个取消
```

```text
ctrl + shift + 空格    快速提示return   在类中可以提示可以调用的方法
```

```text
输入if  ctrl + shift + enter  可以快速补齐代码
```

提示并替换当先值
```text
提示出当前可选的值   按tab 替换  不要按enter
```

代码重构
```text
ctrl + alt + c   将自定义变量抽取成常量
ctrl + alt + m   将代码块抽取成方法
ctrl + alt + p   将方法中使用的属性抽取成方法传参
cltr + alt + v   修改方法参数提出成方法变量
```

查看被调用方法的具体代码
```text
ctrl + shift + i
```

高亮一个参数在代码中的使用位置
```text
ctrl + shift + F7
```
```text
重复使用ctrl + c 可以将多行复制到剪切板, ctrl + shift + v  选择剪切板中的内容.   delete  删除剪切板中的内容
```
```text
ctrl + G  快速定位到代码行
```

```text
返回修改位置，ctrl + alt + 方向键
```
```text
显示最近编辑的文件 ctrl + E
```

```text
开启IDEA的自动编译（动态）
具体步骤：同时按住 Ctrl + Shift + Alt + / 然后进入Registry ，勾选自动编译并调整延时参数。

compiler.automake.allow.when.app.running -> 自动编译
compile.document.save.trigger.delay -> 自动更新文件
```

```text
ctrl + f11 标记代码
```



类注释模板

```
/**
  *@description		TODO      
  *@auther  ${USER}
  *@create  ${YEAR}-${MONTH}-${DAY}
  */ 
```

方法注释模板

```
名称  *       使用方法   /** +　tab


*
  *@Description      TODO
  *@params $param$
  *@return $return$
  *@create $date$
  *@auther $user$
  */ 
```

```
注释报错
Editor ---  inspections --- javadoc problems      去掉
```



