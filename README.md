# banque-persistance
projet dans le cadre de la maîtrise maven


####  Le mode commande de Maven
* ```mvn [options] [<goal(s)>] [<phase(s)>]```

```
  $ mvn --help 
     ...  
     Options: 
     ... 
     -D,--define <arg>             Define a system property 
     -V,--show-version             Display version information 
                                            WITHOUT stopping build 
     -v,--version                  Display version information 
     ...
```
exemple d'utilisation

```$ mvn help:effective-pom -Doutput=pom-complet.xml```

lancement du goal effective-pom du plugin help en passant une option avec le -D. 

### plugins Maven

le plugin est identifié au moment du lancement de la commande maven pour lancer une phase.
a travers le type du projet ( jar, war ou bien ear ) le cycle est retourné avec la configuration
de des plugin a utilisé. exemple la nom de plugin , la version dans une phase bien déterminé
tout cela est definie dans le fichier de configuration maven ``components.xml`` sous le repertoire ``MAVEN_HOME/lib/maven-core-3.0.2.jar!META-INF/plexus/components.xml``.

```
<component>
  <role>org.apache.maven.lifecycle.mapping.LifecycleMapping</role>
  <role-hint>jar</role-hint>
  <implementation>org.apache.maven.lifecycle.mapping.DefaultLifecycleMapping</implementation>
    <configuration>
        <lifecycles>
          <lifecycle>
              <id>default</id>
              <phases>
                  <process-resources>org.apache.maven.plugins:maven-resources-plugin:2.6:resources </process-resources>
                  <compile>org.apache.maven.plugins:maven-compiler-plugin:3.1:compile </compile>
                  <process-test-resources>org.apache.maven.plugins:maven-resources-plugin:2.6:testResources </process-test-resources>
                  <test-compile>org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile </test-compile>
                  <test>org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test </test>
                  <package>org.apache.maven.plugins:maven-jar-plugin:2.4:jar </package>
                  <install>org.apache.maven.plugins:maven-install-plugin:2.4:install </install>
                  <deploy>org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy </deploy>
              </phases>
          </lifecycle>
        </lifecycles>
     </configuration>
</component>
 ```