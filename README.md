[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg)](http://opensource.org/licenses/MIT)
[![Travis Build Status](https://travis-ci.org/mavogel/ilias-client-lib.svg?branch=master)](https://travis-ci.org/mavogel/ilias-client-lib)
[![Code Coverage](https://img.shields.io/codecov/c/github/mavogel/ilias-client/master.svg)](https://codecov.io/github/mavogel/ilias-client-lib?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.mavogel/ilias-client-lib/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.mavogel/ilias-client-lib)

# Ilias-client-lib: A library for accessing the [ilias](http://ilias.de/) e-Learning platform
Currently a small part of the [SOAP](https://en.wikipedia.org/wiki/SOAP) interface of the Ilias e-Learning platform is implemented.

## Table of Contents
- [Features](#features)
- [Usage](#usage)
    - [Maven Dependecy](#maven-dependency)
    - [Built it on your own](#built-it-on-your-own)
- [Important Notes](#important-notes)
- [License](#license)

## <a name="features"></a>Features
1. **Remove all users** from all or only some groups in one course.
2. **Remove all uploaded materials** from all or only some groups in one course.
3. **Set or update a registration period** in all or only some groups in one course.
3. **Set or update a maximum amount of members** in all or only some groups in one course.
4. **File upload permission** can be set for the group members role.
5. **Groups with its members can be** passed to Velocity template and **printed**. Two example templates are provided in `src/main/resources/templates`. 

## <a name="usage"></a>Usage
You can download the built artifact from Sonatype which is preferred or built it on your own. 

A [jdk8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) is required in both cases.

### <a name="maven-dependency"></a>Maven dependency 

```xml
<dependency>
    <groupId>com.github.mavogel</groupId>
    <artifactId>ilias-client-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

### <a name="built-it-on-your-own"></a>Built it on your own
This additionally requires [maven](https://maven.apache.org/).

```bash
$ git clone https://github.com/mavogel/ilias-client-lib.git && cd ilias-client-lib 
$ mvn clean install
```

## <a name="important-notes"></a>Important notes
- The WDSL of the SOAP interface, which is used to generate the Java classes, is part of the jar bundle. Hence even if you change the endpoint property on the provided file for execution, the WDSL behind this url will never be used in the tool. Hopefully all new versions of the Ilias are downgradable.
- The WDSL used in this client is of the **Ilias version 5.0.0**
- For setting a new registration date it is assumed that the Ilias server runs in the same timezone like the machine this client is running.
- It is assumed that `groups` are always in `folder` nodes.

## <a name="license"></a>License
    Copyright (c) 2017 Manuel Vogel
    Source code is open source and released under the MIT license.