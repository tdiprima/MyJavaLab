## How to Add a JDK with GraalVM

### Install GraalVM

To get started, [download the latest release of GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases). Choose the version that matches your platform: Java 17, macOS (amd64).

### Extract and Install GraalVM

Once downloaded, extract the archive using the following command:

```sh
cd $HOME/Downloads/
tar -xzf graalvm-ce-java17-darwin-amd64-22.3.1.tar.gz
sudo mv graalvm-ce-java17-22.3.1 /Library/Java/JavaVirtualMachines
```

### Configure Your Shell

Add the following lines to your `.zshrc` file to set the `JAVA_HOME` and `PATH` environment variables:

```sh
export JAVA_HOME="/Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.3.1/Contents/Home"
export PATH=$HOME/bin:/usr/local/opt/python/libexec/bin:$JAVA_HOME/bin:$PATH
```

### Set Up Your JDK in IntelliJ IDEA

To use the JDK in IntelliJ IDEA, follow these steps:

1. Go to File > Project Structure > Project Settings > Project SDKs
2. Click on the "+" button to add a new SDK
3. Select "JDK" and enter the JDK home path: `/Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.3.1`

Alternatively, you can also navigate to a Java file, right-click on it, and select "Open Module Settings" to add the JDK.

### Add Apache POI Dependency

The `filereader.ReadDoc` Class uses Apache POI, which requires a Microsoft Word file dependency. To add this dependency, download the binary distribution of Apache POI from [the Apache POI download page](https://poi.apache.org/download.html). For Mac, use the `tgz` file.

### Configure the Apache POI Dependency in Your Project

In your project, navigate to the "Dependencies" section and click on the "+" button to add a new dependency. Select "JARs or Directories..." and add all the jar files from the `poi-bin-5.2.3` folder.

That's it! You should now be able to build your project successfully.

<br>
