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

Il est très important de définir clairement dans chaque POM les plugins ainsi que les versions utilisées pour le projet. 
Ces informations assurent la stabilité du projet en cas de changement de version d’Apache Maven et donc, potentiellement, 
des versions par défaut des plugins qui vont etre changé d'une version a une autre. 
* Au niveau de l’élément <plugins>, sous-élément de <build> pour la construction du projet.
  
*  Au niveau de l’élément <pluginManagement> pour la gestion des plugins.


The [super pom](https://maven.apache.org/ref/3.6.1/maven-model-builder/super-pom.html) defines some parts (folder structure) but the [life cycle binding](https://maven.apache.org/ref/3.6.1/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging) defines other parts like the binding to the appropriate life cycle phases. The [life cycle phases](https://maven.apache.org/ref/3.6.1/maven-core/lifecycles.html) itself are defined here.
  
The versions of the plugins depend on which version of Maven you are using cause the life cycle binding is being updated. If you like to be sure which version of a plugin is being used the best practice is to define all plugins you are using via pluginManagement in your pom which should be done in a corporate pom file to avoid duplication

#### Recherche plugin
Lors d'une recherche d'un plugin quelconque au moment d'un appel, maven va chercher dans deux endroits (groupID) differents selon la convension de nomage:
* org.apache.maven.plugins ( les plugin maven) si le nom est de la forme `maven-${name}-plugin`.

exp : le plugin `clean`, `org.apache.maven.plugins:maven-clean-plugin`

* org.codehaus.mojo si le nom est de la forme `${name}-maven-plugin`.

_**Il est possible d’inclure d’autres groupId dans cette recherche en configurant l’élément `<pluginGroups>` du fichier settings.xml.**_

#### Configuration des plugins
Par defaut chaque plugin possède sa propre configuration, par contre vi le ficher pom on peut modifier sa configuration initial.
Vi un bloc de `<configuration>` pour plus d'information sur la conf il faut voir le site office Toute la documentation officielle  à l’adresse : http://maven.apache.org/plugins/.

#### Ajouter un traitement à une phase autres à ceux qui sont par defaut
Lors de l'excution d'un cycle maven, maven va lancer tous les goals qui sont définie par defaut pour chaque phase.
il arrive parfois qu'on veut ajouter un traitement spécifique dans une phase bien déterminée dans un projet,
Il est ainsi possible d’ajouter des traitements grâce à l’exécution de goals de plugins sur une phase du cycle.
exp: ajouter le code source d'un projet dans le jar, cela est faisable grâce au plugin `maven-source-plugin`.

  ```
<plugin> 
    <groupId>org.apache.maven.plugins</groupId> 
    <artifactId>maven-jar-plugin</artifactId> 
    <version>2.4</version> 
    <configuration>...</configuration> 
  </plugin> 
<plugin> 
    <groupId>org.apache.maven.plugins</groupId> 
    <artifactId>maven-source-plugin</artifactId> 
    <version>3.0.1</version>  
    <executions> 
       <execution> 
         <id>attach-source</id>  
         <goals> 
           <goal>jar-no-fork</goal>  
         </goals> 
       </execution> 
    </executions> 
  </plugin>
``` 

C’est le cas, pour le MOJO jar-no-fork qui est associé à la phase package comme je plugin jar, avec la valeur attach-source comme identifiant de ce traitement.

![cap1](screnshot/cap1.PNG) 

La phase package exécute désormais deux cibles associées à des plugins différents.

Il est aussi possible de surcharger la phase définie par défaut dans le MOJO du plugin à partir de la configuration du POM

    <executions> 
       <execution> 
         <id>attach-sources</id> 
         <goals> 
           <goal>jar-no-fork</goal> 
         </goals>  
         <phase>verify</phase> 
       </execution> 
    </executions> 
    
Maitenant le goal `jar-nor-fork` est attaché a la phase `verify`.

Il est important de noter que tous les MOJO ne définissent pas obligatoirement de phase par défaut pour s’exécuter. 
heursement le `jar-nor-fork` est configuré avec la phase package.
Ainsi, **si dans le POM aucune phase du cycle n’est associée au goal, comme dans l’exemple précédent, celle-ci ne sera pas appelée et le traitement non effectué.**