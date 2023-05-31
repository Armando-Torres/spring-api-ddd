FROM tomcat:10.1.9-jdk17

# Enable tomcat apps
RUN cp -r /usr/local/tomcat/webapps.dist/manager /usr/local/tomcat/webapps/manager

# Allow access to tomcat manager for development purposes only with admin user
RUN sed -i 's/<\/tomcat-users>/  <user username="admin" password="admin" roles="manager-gui"\/>\n<\/tomcat-users>/g' /usr/local/tomcat/conf/tomcat-users.xml

# Open access to manager comment the org.apache.catalina.valves.RemoteAddrValve
RUN sed -i 's/sameSiteCookies="strict" \/>/sameSiteCookies="strict" \/>\n<!--/' /usr/local/tomcat/webapps/manager/META-INF/context.xml \
    && sed -i 's/<Manager sessionAttributeValueClassNameFilter/-->\n<Manager sessionAttributeValueClassNameFilter/' /usr/local/tomcat/webapps/manager/META-INF/context.xml
