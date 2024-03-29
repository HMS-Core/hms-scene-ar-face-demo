# 华为图形引擎服务原子化接口ARView&FaceView示例代码
中文 | [English](README.md)
## 目录

* [简介](#简介)
* [开发准备](#开发准备)
* [开发环境](#开发环境)
* [运行结果](#运行结果)
* [技术支持](#技术支持)
* [许可证](#许可证)

## 简介

原子化接口ARView&FaceView示例代码演示了如何使用原子化接口实现AR场景添加物体与添加面部AR特效。

[了解更多关于图形引擎服务](https://developer.huawei.com/consumer/cn/hms/huawei-scenekit)。

## 开发准备

   1. 检查Android Studio开发环境是否就绪。使用Android Studio打开示例代码工程路径下的build.gradle文件。
   2. 注册[华为账号](https://developer.huawei.com/consumer)。
   3. 创建应用并在AppGallery连接中配置应用信息。
      详情请查看: [华为图形引擎服务开发指南](https://developer.huawei.com/consumer/cn/doc/development/graphics-Guides/dev-process-0000001064186384)。
   4. 如果App中添加了`agconnect-services.json`文件则需要在**buildscript -> dependencies**中增加AGC插件配置。
      详情请查看: [集成HMS Core SDK](https://developer.huawei.com/consumer/cn/doc/development/graphics-Guides/integrating-sdk-0000001063754635)。
   5. 为了保证工程构建成功，请使用3.6.1版本以上的Android Studio。
   6. 原子化接口ARView、FaceView部分特性依赖AREngineServer，需确认您的设备上已安装AREngineServer。
   7. 在您的设备或模拟器上运行示例代码。

## 开发环境

* Android Stuido 3.6.1及以上版本
* JDK 1.8（推荐）
* targetSdkVersion：28（推荐）
* AREngine Server：3.12.0及以上版本
* HMS Core (APK) 4.0.2.300及以上版本
* EMUI 10.0及以上版本（推荐）

## 运行结果

<img src="SceneKitARFaceDemo/ARView.gif" width = 30% height = 30%>
<img src="SceneKitARFaceDemo/FaceView.gif" width = 30% height = 30%>

## 技术支持

如果您对HMS Core还处于评估阶段，可在[Reddit社区](https://www.reddit.com/r/HuaweiDevelopers/)获取关于HMS Core的最新讯息，并与其他开发者交流见解。

如果您对使用HMS示例代码有疑问，请尝试：

- 开发过程遇到问题上[Stack Overflow](https://stackoverflow.com/questions/tagged/huawei-mobile-services?tab=Votes)，在`huawei-mobile-services`标签下提问，有华为研发专家在线一对一解决您的问题。
- 到[华为开发者论坛](https://developer.huawei.com/consumer/cn/forum/blockdisplay?fid=18) HMS Core板块与其他开发者进行交流。

如果您在尝试示例代码中遇到问题，请向仓库提交[issue](https://github.com/HMS-Core/hms-scene-ar-face-demo/issues)，也欢迎您提交[Pull Request](https://github.com/HMS-Core/hms-scene-ar-face-demo/pulls)。

## 许可证

原子化接口ARView&FaceView示例代码采用的许可证为[Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

3D模型素材'Spinosaurus_animation'（未经修改），原作者为seirogan，采用的许可证为[Creative Commons Attribution license](https://creativecommons.org/licenses/by/4.0/legalcode)。

了解更多关于[Spinosaurus_animation](https://sketchfab.com/3d-models/spinosaurus-animation-c11709dbf9e3472f9533343f1f342564)。
