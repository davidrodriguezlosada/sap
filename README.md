# SAP

This is an old project I made a few years ago to test Spring and Flutter. A lot of things have changed since then,
but I think it's multimodule maven setup can be used as inspiration for Service Oriented Architectures where multiple
services will share one or more databases.

The following image explains the purpose of each module

![Project diagram explaining every module](/resources/sap-diagram.png)

This kind of distribution in multiple modules has some pros, like having a single place to define each one of
the objects that we have in our project, and also sharing configurations, dependency versions, etc. This can make
the project to move faster and probably stay cleaner, since the whole structure of the project tells the developers
where to put each component.

Of course, you will also see some cons, like the risk of everything becoming very complex if the services tend to
increase a lot in size.

## Getting Started
### Prerequisites
Before using this program, ensure you have the following prerequisites:

* Java
* Maven
* Flutter if you want to use the UI.
* SQL Server for the database

### Installation & Usage
Run a SQL Server database, create a database called sap and configurate credentials in both db-installer-sap and
customer-service-sap.

Build:

    mvn install

## Contributing
Feel free to contribute to this project by submitting issues, feature requests, or pull requests. Your contributions are highly appreciated.

## License
This project is licensed under the MIT License - see the LICENSE file for details.