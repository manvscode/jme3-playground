plugins {
    java
}

group = "com.joemarrero"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

val jmeVersion: String = "3.2.0-stable"

dependencies {
    testCompile("junit", "junit", "4.12")

    compile("org.jmonkeyengine:jme3-core:${jmeVersion}")
    runtime("org.jmonkeyengine:jme3-desktop:${jmeVersion}")
    runtime("org.jmonkeyengine:jme3-lwjgl:${jmeVersion}")
    //runtime("org.jmonkeyengine:jme3-lwjgl3:${jmeVersion}")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8

}