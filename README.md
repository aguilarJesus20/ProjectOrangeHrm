# ProjectOrangeHrm

Es un proyecto de automatización realizado en Java POM TestNg framework y Cucumber con patrón de diseño Page Object Model.

Se crearon las siguientes validaciones.

 - Validación al momento de crear un Empleado
 - Validaciones en los campos del formulario de creación del empleado
 - Validaciones en el formulario de busqueda de un empleado
 - Validación al momento de crear un usuario de sistema
 - Validaciones en el formulario de usuario de sistema
 - Validaciones en los campos del formulario de busqueda de usuario de sistema.


#Requisitos para el proyecto
- Apache Maven 3.8.6
- Java version: 11.0.16.1
 


#Ejecución por comando
mvn clean install
mvn clean test -Durl=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login 

#Reportes
Al momento de ejecutar este proyecto el sistema creará un reporte de los casos ejecutados en la ruta
./target/surefire-reports
./target/cucumber-reports


