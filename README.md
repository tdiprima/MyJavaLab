## How to add a JDK

### Install graalvm.

[Download release](https://github.com/graalvm/graalvm-ce-builds/releases)

Choose: Java 17, macOS (amd64).

### Run

```sh
cd $HOME/Downloads/
tar -xzf graalvm-ce-java17-darwin-amd64-22.3.1.tar.gz
sudo mv graalvm-ce-java17-22.3.1 /Library/Java/JavaVirtualMachines
```

### .zshrc

```sh
export JAVA_HOME="/Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.3.1/Contents/Home"
export PATH=$HOME/bin:/usr/local/opt/python/libexec/bin:$JAVA_HOME/bin:$PATH
```

### IntelliJ Idea

Set up the project JDK / SDK whatever.

I clicked on a Java file, and it wigged out that it didn't have one.

When I clicked on it, it brought me to the right place.

I think I just put

`/Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.3.1`

and let ***it*** figure it out.

<!--File | Project Structure | Project Settings | Project -> SDKs

JDK Home Path: /Library/Java/JavaVirtualMachines/graalvm-ce-java17-22.3.1/Contents/Home
-->

### It won't build the project without this dependency

`filereader.ReadDoc` uses an Apache package that works with Microsoft Word files.

[Apache POI - Download Release Artifacts](https://poi.apache.org/download.html)

Binary Distribution -> use the tgz file; that's the one for Mac.

<!--https://dlcdn.apache.org/poi/release/bin/poi-bin-5.2.3-20220909.tgz-->


**Project -> Right-click -> Open Module Settings**

Dependencies

`+` JARs or Directories...

Select all the jar files from the `poi-bin-5.2.3` folder.

Gweat!  You're done.
