# UITest

该工程是一个基于 gradle 构建的 Android uiautomator 1.0（区别于 Espresso 中的 uiautomator 2.0）模板工程。

使用时需要将 `build.gralde` 文件中的 `ANDROID_HOME` 和 `BUILD_TOOL_VERSION` 两个变量替换为自己的配置：

```gradle
def ANDROID_HOME = 'D:\\develop\\Android\\sdk'
def BUILD_TOOL_VERSION = '25.0.2'
```

`build.gradle` 中部分代码参考自网络，忘记出处了，如有知情者，请告知。