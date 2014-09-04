phoenix-java-sdk
================

The MediaSilo Java SDK

### Maven

``` xml
    <repositories>
        <repository>
            <id>artifacts.mediasilo.com</id>
            <url>scpexe://artifacts.mediasilo.com/m2repo</url>
            <releases>
                <enabled>true</enabled>
                <updatePolicy>never</updatePolicy>
                <checksumPolicy>fail</checksumPolicy>
            </releases>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>never</updatePolicy>
                <checksumPolicy>fail</checksumPolicy>
            </snapshots>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.mediasilo.phoenix</groupId>
            <artifactId>phoenix-java-sdk</artifactId>
            <version>0.0.1</version>
        </dependency>
    </dependencies>
```

### Usage
```java
		MediaSiloSdk mediaSiloSdk = com.mediasilo.sdk.MediaSiloSdk.getInstance();
		mediaSiloSdk.init("username", "password", "hostname");
		QuickLinkResponse quickLinkResponse = mediaSiloSdk.quicklinks().read("my quicklink id");
```
