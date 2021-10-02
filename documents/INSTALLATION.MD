## Installation

<!-- *	Default active profile is **`test`**. When the application is running, **Flyway** will create the necessary tables and system data along with sample data. In the **`test`** profile, the application uses **H2** database (data in memory).

* 	URL to access application UI: **http://localhost:8080/sbat/index** or **https://192.168.99.102:8080/sbat/index** if **SSL** is enabled.

* 	Other sample profiles like **`dev`**, **`production`**, **`qa`**, and  **`staging`** are available. Change the **spring.profiles.active** property in the **application.properties** file to any of the aforementioned profiles to use it.

*	To enable or disable **SSL** support, in the **application properties** file turn **server.ssl.enabled** to **true** or **false** -->
Default active profile is **`test`**.
When the application is running, **`Hibernate`** will create the tables and update if there was any change in the structrues or data in the appropriate  **`MySQL`** database.

<details open="open">
	<ul>
		<li><a href="#running-the-applications-with-ide">Running the applications with IDE</a></li>
		<li><a href="#running-the-applications-with-maven">Running the applications with Maven</a></li>
		<li><a href="#running-the-applications-with-maven">Running the applications without Maven</a></li>
		<li><a href="#running-the-application-with-executable-jar">Running the application with Executable JAR</a></li>
		<!-- <li>
			<ul>
				<li>
					<a href="#accessing-data-in-h2-database">Accessing Data in H2 Database</a>
					<ul>
						<li><a href="#h2-console">H2 Console</a></li>
					</ul>
				</li>
			</ul>
		</li> -->
		<!-- <li><a href="#running-the-application-via-docker-container">Running the application via docker container</a></li> -->
	</ul>
</details>

### Running the applications with IDE

There are several ways to run a Spring Boot application on your local machine.\
One way is to execute the `main` method in the claass which contains the @SpringBootApplication annotation.\
In the shopify-project:\
In order to run the ShopifyBackEnd project, simply execute the main method in the class: `org.nir.shopify.admin.ShopifyBackEndApplication ` \
Similarly, In order to run the ShopifyFrontEnd project, simply execute the main method in the class: `org.nir.shopify.ShopifyFrontEndApplication ` \



#### In Details: 
* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip or cloned it.
	* Select the project
* 	Open the folder of the Spring Boot Applications you wish to run(Either the ShopifyFrontEnd application or the ShopifyBackEnd application)
* Choose the Spring Boot Application file (search for @SpringBootApplication) 
* 	Right Click on the file and Run as Java Application

### Running the applications with Maven

#### Running the ShopifyBackEnd application with Maven :

 ```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project
$ mvn package -DskipTests
$ java -jar ShopifyWebParent/ShopifyBackEnd/target/ShopifyBackEnd-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```


#### Running the ShopifyFrontEnd application with Maven :

 ```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project
$ mvn package -DskipTests
$ java -jar ShopifyWebParent/ShopifyFrontEnd/target/ShopifyBackEnd-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```


Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

Run the ShopifyBackEnd project :

```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project/ShopifyWebParent/ShopifyBackEnd
$ mvn spring-boot:run
```

Run the ShopifyFrontEnd project: 

```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project/ShopifyWebParent/ShopifyFrontEnd
$ mvn spring-boot:run
```


### Running the applications without Maven

<!-- The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command.\ -->

If you don't have Maven installed on your local machine you can still build and run the 2 applications by using the .mvnw file

#### Running the ShopifyBackEnd application without Maven

```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project
$ ./mvnw package -DskipTests
$ java -jar ShopifyWebParent/ShopifyBackEnd/target/ShopifyBackEnd-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```

#### Running the ShopifyFrontEnd application without Maven

```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project
$ ./mvnw package -DskipTests
$ java -jar ShopifyWebParent/ShopifyFrontEnd/target/ShopifyFrontEnd-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```

### Running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command.

#### Running the ShopifyBackEnd application with Executable JAR

```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project
$ mvn package -DskipTests
$ java -jar ShopifyWebParent/ShopifyBackEnd/target/ShopifyBackEnd-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```

#### Running the ShopifyFrontEnd application with Executable JAR

```shell
$ git clone https://github.com/nir-programmer/shopify-project.git
$ cd shopify-project
$ mvn package -DskipTests
$ java -jar ShopifyWebParent/ShopifyFrontEnd/target/ShopifyFrontEnd-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```


To shutdown the jar, follow the below mentioned steps:

On a Windows machine:(Tested on Windows 10)

*	In command prompt execute the **jcmd** command to print a list of all running Java processes
*	**Taskkill /PID PROCESS_ID_OF_RUNNING_APP /F** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP** with the actual process id of the running jar found out from executing the previous command

On a Unix Machine:(Tested on Ubuntu 20)

*	In command prompt execute the **ps aux | grep java** command to print a list of all running Java processes
*	**kill -9 PID PROCESS_ID_OF_RUNNING_APP** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP** with the actual process id of the running jar found out from executing the previous command




<!-- ##### Accessing Data in H2 Database

###### H2 Console

URL to access H2 console: **http://localhost:8080/h2-console/login.jsp** or **https://192.168.99.102:8080/h2-console/login.jsp** if **SSL** is enabled.

Fill the login form as follows and click on Connect:

* 	Saved Settings: **Generic H2 (Embedded)**
* 	Setting Name: **Generic H2 (Embedded)**
* 	Driver class: **org.h2.Driver**
* 	JDBC URL: **jdbc:h2:mem:sbat;MODE=MySQL**
* 	User Name: **sa**
* 	Password:

<img src="images\h2db\h2-console-login.PNG"/>

<img src="images\h2db\h2-console-main-view.PNG"/>

#### Running the application via docker container

* 	Refer to [DOCKER.md](./DOCKER.md) for details. -->