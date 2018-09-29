# About ViewModel And LiveData
### 关于ViewModel

ViewModel类的设计目的是以一种关注生命周期的方式存储和管理与UI相关的数据。  
例如：Activity在配置发生改变时(屏幕旋转)，Activity就会重新创建，onCreate()方法也会重新调用。我们可以在onSaveInstanceState()方法中保存数据，并从onCreate()方法中通过Bundle恢复数据，但这种方法只适用于可以对其进行序列化的少量数据，而不适用于潜在的大量数据。使用ViewModel的话ViewModel会自动保留之前的数据并给新的Activity或Fragment使用。直到当前Activity被系统销毁时，Framework会调用ViewModel的onCleared()方法，我们可以在onCleared()方法中做一些资源清理操作。

### 关于LiveData

LiveData是一个可观察的数据持有者类。与常见的观察者不同，LiveData是有生命周期感知的。这意味着它尊重其他应用程序组件的生命周期，比如Activity、Fragment或Service。这种感知确保LiveData只更新处于生命周期状态内的应用程序组件。

LiveData是由observer类表示的观察者视为处于活动状态，如果其生命周期处于STARTED或RESUMED状态。LiveData会将观察者视为活动状态，并通知其数据的变化。LiveData未注册的观察对象以及非活动观察者是不会收到有关更新的通知。

### LiveData的优点：

- 确保UI界面的数据状态
>LiveData遵循观察者模式。LiveData在生命周期状态更改时通知Observer对象，更新这些Observer对象中的UI。观察者可以在每次应用程序数据更改时更新UI，而不是每次发生更改时更新UI。

- 没有内存泄漏  
>当观察者被绑定他们对应的LifeCycle以后，当页面销毁时他们会自动被移除，不会导致内存溢出。

- 不会因为Activity的不可见导致Crash
>当Activity不可见时，即使有数据变化，LiveData也不会通知观察者。因为此时观察者的LifeCyele并不处于Started或者RESUMED状态。

- 配置的改变
>当前Activity配置改变（如屏幕方向），导致重新从onCreate走一遍，这时观察者们会立刻收到配置变化前的最新数据。

- 共享资源
>只需要一个LocationLivaData,连接系统服务一次，就能支持所有的观察者。

- 不用再人为的处理生命周期
>Activity或者Fragment只要在需要观察数据的时候观察数据即可，不需要理会生命周期变化了。这一切都交给LiveData来自动管理。

### 添加ViewModel和LiveData库的依赖

首先在Google的Maven存储库(项目最外层的build.gradle文件中添加如下：

```Java
allprojects {
    repositories {
        jcenter()
        google()
    }
}
```

然后再app/build.gradle文件中添加相关依赖

```Java
dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    // ViewModel和LiveData依赖
    implementation "android.arch.lifecycle:extensions:1.1.1"
    annotationProcessor "android.arch.lifecycle:compiler:1.1.1"
    ......
}
```

### 定义ViewModel和创建LiveData

参看demo的代码