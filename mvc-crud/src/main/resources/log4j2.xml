<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <Appenders>
        <Socket name="A1" host="localHost" port="5000">
            <PatternLayout pattern="%t %-5p %c{2} - %m%n"/>
        </Socket>
        <Console name="STDOUT" target="SYSTEM_OUT">
            <PatternLayout pattern="%d %-5p [%t] %C{2} (%F:%L) - %m%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Logger name="org.apache.log4j.xml" level="debug">
            <AppenderRef ref="A1"/>
        </Logger>
        <Root level="debug">
            <AppenderRef ref="STDOUT"/>
        </Root>
    </Loggers>
</Configuration>