plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.intellij") version "1.15.0"
}

group = "com.wangchaozhi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


// 添加 Hutool 依赖和其他依赖项
dependencies {
    implementation("cn.hutool:hutool-all:5.8.20")  // Hutool 依赖
    implementation("org.dom4j:dom4j:2.1.4")  // 添加 dom4j 依赖
    implementation("log4j:log4j:1.2.17")
}


// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
//    version.set("2022.2.5")
//    type.set("IC") // Target IDE Platform
    version.set("2023.2.5")  // 对应的 IntelliJ IDEA 版本
    type.set("IU")           // Ultimate Edition (IU) 版本

    plugins.set(listOf("java", "org.jetbrains.kotlin","com.intellij.properties", "org.jetbrains.plugins.yaml"))
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("232.*")
//        sinceBuild.set("232")  // 使用与 IntelliJ IDEA 版本相对应的主版本号
//        untilBuild.set("232.*") // 设置为当前主版本号的最新次版本


    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
